
package org.example

fun main() {

    // Step 1: Define environmental factors
    val factors = EnvironmentalFactorSet(
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

    // Step 2: Create models using validated factors
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

    // Step 3: Calculate environmental impact
    val report = EnvironmentalImpactCalculator().calculate(
        energy = energy,
        hardware = hardware,
        water = water
    )

    // Step 4: Display results
    println("=== Sustainable AI Systems ===")
    println()
    println("ENERGY")
    println("IT Energy: ${report.itEnergyKWh} kWh")
    println("Facility Energy: ${report.facilityEnergyKWh} kWh")
    println("Electricity Cost: $${"%.2f".format(report.electricityCostUSD)}")
    println()
    println("CARBON")
    println("Operational Carbon: ${report.operationalCarbonKg} kg CO2e")
    println("Embodied Carbon: ${report.embodiedCarbonKg} kg CO2e")
    println("Total Carbon: ${report.totalCarbonKg} kg CO2e")
    println()
    println("WATER")
    println("Direct Water: ${report.directWaterLiters} L")
    println("Indirect Water: ${report.indirectWaterLiters} L")
    println("Embodied Water: ${report.embodiedWaterLiters} L")
    println("Total Water: ${report.totalWaterLiters} L")
    println()
    println("ENVIRONMENTAL DATA PROVENANCE")
    println("Region: ${factors.carbonIntensity.region}")
    println("Reference Year: ${factors.carbonIntensity.referenceYear}")
    println("Carbon Source: ${factors.carbonIntensity.source}")
    println("Electricity Water Source: ${factors.electricityWater.source}")
    println("Cooling Water Source: ${factors.coolingWater.source}")
    println()
    println("Note: All environmental factors are illustrative, not measured data.")
}
