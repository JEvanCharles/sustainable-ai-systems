
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EnvironmentalImpactCalculatorTest {

    private fun createEnergyModel() = EnergyModel(
        trainingHours = 10.0,
        energyPerHourKWh = 5.0,
        costPerKWh = 0.12,
        carbonPerKWh = 0.4
    )

    private fun createHardwareModel() = HardwareModel(
        manufacturingCarbon = 2000.0,
        manufacturingWater = 50000.0,
        lifespanHours = 20000.0,
        gpuCount = 4,
        utilizationRate = 0.75,
        allocationShare = 1.0
    )

    private fun createWaterModel(itEnergy: Double = 50.0) = WaterModel(
        itEnergyKWh = itEnergy,
        waterUsageEffectiveness = 0.5,
        electricityWaterFactor = 1.0,
        powerUsageEffectiveness = 1.2
    )

    @Test
    fun `combined report should calculate total carbon correctly`() {
        val report = EnvironmentalImpactCalculator().calculate(
            createEnergyModel(),
            createHardwareModel(),
            createWaterModel()
        )

        assertEquals(28.0, report.totalCarbonKg, 0.0001)
    }

    @Test
    fun `combined report should calculate total water correctly`() {
        val report = EnvironmentalImpactCalculator().calculate(
            createEnergyModel(),
            createHardwareModel(),
            createWaterModel()
        )

        assertEquals(185.0, report.totalWaterLiters, 0.0001)
    }

    @Test
    fun `combined report should include facility electricity cost`() {
        val report = EnvironmentalImpactCalculator().calculate(
            createEnergyModel(),
            createHardwareModel(),
            createWaterModel()
        )

        assertEquals(7.20, report.electricityCostUSD, 0.0001)
    }

    @Test
    fun `mismatched energy inputs should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalImpactCalculator().calculate(
                createEnergyModel(),
                createHardwareModel(),
                createWaterModel(itEnergy = 100.0)
            )
        }
    }
}
