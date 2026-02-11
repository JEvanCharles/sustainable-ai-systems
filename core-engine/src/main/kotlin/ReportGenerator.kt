package org.example

object ReportGenerator {

    fun generate(model: EnergyModel) {
        println("---- AI Training Energy Report ----")
        println("Training Hours: ${model.trainingHours}")
        println("Total Energy Used (kWh): ${model.totalEnergyUsed()}")
        println("Total Cost ($): ${model.totalCost()}")
        println("Total Emissions (kg CO2): ${model.totalEmissions()}")
    }
}