package org.example

data class EnergyModel(
    val trainingHours: Double,
    val energyPerHourKWh: Double,
    val costPerKWh: Double,
    val carbonPerKWh: Double
) {
    fun totalEnergyUsed(): Double = trainingHours * energyPerHourKWh
    fun totalCost(): Double = totalEnergyUsed() * costPerKWh
    fun totalEmissions(): Double = totalEnergyUsed() * carbonPerKWh

    fun report() {
        println("---- AI Training Energy Report ----")
        println("Training Hours: $trainingHours")
        println("Total Energy Used (kWh): ${totalEnergyUsed()}")
        println("Total Cost ($): ${totalCost()}")
        println("Total Emissions (kg CO2): ${totalEmissions()}")
    }
}