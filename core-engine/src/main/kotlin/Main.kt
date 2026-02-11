package org.example

fun main() {
    val model = EnergyModel(
        trainingHours = 10.0,
        energyPerHourKWh = 5.0,
        costPerKWh = 0.12,
        carbonPerKWh = 0.4
    )

    ReportGenerator.generate(model)
}