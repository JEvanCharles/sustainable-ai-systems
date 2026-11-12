
package org.example

fun main() {

    // Step 1: Define the AI training job
    val energy = EnergyModel(
        trainingHours = 10.0,
        energyPerHourKWh = 5.0,
        costPerKWh = 0.12,
        carbonPerKWh = 0.4
    )

    // Step 2: Define the hardware
    val hardware = HardwareModel(
        manufacturingCarbon = 2000.0,
        manufacturingWater = 50000.0,
        lifespanHours = 20000.0,
        gpuCount = 4,
        utilizationRate = 0.75,
        allocationShare = 1.0
    )

    // Step 3: Define operational water factors
    val water = WaterModel(
        itEnergyKWh = energy.totalEnergyUsed(),
        waterUsageEffectiveness = 0.5,
        electricityWaterFactor = 1.0,
        powerUsageEffectiveness = 1.2
    )

    // Step 4: Combine all three models
    val calculator = EnvironmentalImpactCalculator()

    val report = calculator.calculate(
        energy = energy,
        hardware = hardware,
        water = water
    )

    // Step 5: Display the environmental impact report
    println("======================================")
    println("   SUSTAINABLE AI SYSTEMS REPORT")
    println("======================================")

    println("\nENERGY")
    println("IT Energy: ${report.itEnergyKWh} kWh")
    println("Facility Energy: ${report.facilityEnergyKWh} kWh")
    println("Electricity Cost: $${"%.2f".format(report.electricityCostUSD)}")

    println("\nCARBON")
    println("Operational Carbon: ${report.operationalCarbonKg} kg CO2e")
    println("Embodied Carbon: ${report.embodiedCarbonKg} kg CO2e")
    println("Total Carbon: ${report.totalCarbonKg} kg CO2e")

    println("\nWATER")
    println("Direct Cooling Water: ${report.directWaterLiters} L")
    println("Indirect Electricity Water: ${report.indirectWaterLiters} L")
    println("Embodied Hardware Water: ${report.embodiedWaterLiters} L")
    println("Total Water: ${report.totalWaterLiters} L")

    println("\n======================================")
}
