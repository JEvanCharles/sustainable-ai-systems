
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class EnvironmentalModelFactoryTest {

    private fun createFactors() = EnvironmentalFactorSet(
        carbonIntensity = EnvironmentalFactor(
            name = "Electricity Carbon Intensity",
            value = 0.4,
            unit = "kg CO2e/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025,
            type = EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
        ),
        electricityWater = EnvironmentalFactor(
            name = "Electricity Water Consumption",
            value = 1.0,
            unit = "L/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025,
            type = EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION
        ),
        coolingWater = EnvironmentalFactor(
            name = "Water Usage Effectiveness",
            value = 0.5,
            unit = "L/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025,
            type = EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS
        )
    )

    @Test
    fun `factory should transfer carbon intensity correctly`() {
        val energy = EnvironmentalModelFactory.createEnergyModel(
            trainingHours = 10.0,
            energyPerHourKWh = 5.0,
            costPerKWh = 0.12,
            factors = createFactors()
        )

        assertEquals(0.4, energy.carbonPerKWh, 0.0001)
        assertEquals(50.0, energy.totalEnergyUsed(), 0.0001)
    }

    @Test
    fun `factory should transfer cooling water factor correctly`() {
        val water = EnvironmentalModelFactory.createWaterModel(
            itEnergyKWh = 50.0,
            powerUsageEffectiveness = 1.2,
            factors = createFactors()
        )

        assertEquals(25.0, water.directWaterLiters(), 0.0001)
    }

    @Test
    fun `factory should transfer electricity water factor correctly`() {
        val water = EnvironmentalModelFactory.createWaterModel(
            itEnergyKWh = 50.0,
            powerUsageEffectiveness = 1.2,
            factors = createFactors()
        )

        assertEquals(60.0, water.indirectWaterLiters(), 0.0001)
    }

    @Test
    fun `factory models should produce expected combined impact`() {
        val factors = createFactors()

        val energy = EnvironmentalModelFactory.createEnergyModel(
            trainingHours = 10.0,
            energyPerHourKWh = 5.0,
            costPerKWh = 0.12,
            factors = factors
        )

        val water = EnvironmentalModelFactory.createWaterModel(
            itEnergyKWh = energy.totalEnergyUsed(),
            powerUsageEffectiveness = 1.2,
            factors = factors
        )

        val hardware = HardwareModel(
            manufacturingCarbon = 2000.0,
            manufacturingWater = 50000.0,
            lifespanHours = 20000.0,
            gpuCount = 4,
            allocationShare = 1.0
        )

        val report = EnvironmentalImpactCalculator().calculate(
            energy = energy,
            hardware = hardware,
            water = water
        )

        assertEquals(28.0, report.totalCarbonKg, 0.0001)
        assertEquals(185.0, report.totalWaterLiters, 0.0001)
    }
}
