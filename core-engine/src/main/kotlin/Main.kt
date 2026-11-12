package org.example


fun main() {

    val energyModel = EnergyModel(
        trainingHours = 10.0,
        energyPerHourKWh = 5.0,
        costPerKWh = 0.12,
        carbonPerKWh = 0.4
    )

    val hardware = HardwareModel(
        manufacturingCarbon = 2000.0,
        manufacturingWater = 50000.0,
        lifespanHours = 20000.0,
        gpuCount = 4,
        utilizationRate = 0.75,
        allocationShare = 1.0
    )


    val jobHours = 10.0

    println("---- Operational Impact ----")
    energyModel.report()

    println("\n---- Embodied Hardware Impact ----")
    println("Embodied Carbon (kg CO2): ${hardware.allocatedCarbon(jobHours)}")
    println("Embodied Water (liters): ${hardware.allocatedWater(jobHours)}")

    println("GPU Count: ${hardware.gpuCount}")
    println("Utilization Rate: ${hardware.utilizationRate * 100}%")
}