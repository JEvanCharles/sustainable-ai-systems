
package org.example

data class EnvironmentalImpactReport(
    val itEnergyKWh: Double,
    val facilityEnergyKWh: Double,
    val electricityCostUSD: Double,
    val operationalCarbonKg: Double,
    val embodiedCarbonKg: Double,
    val directWaterLiters: Double,
    val indirectWaterLiters: Double,
    val embodiedWaterLiters: Double
) {
    val totalCarbonKg: Double
        get() = operationalCarbonKg + embodiedCarbonKg

    val operationalWaterLiters: Double
        get() = directWaterLiters + indirectWaterLiters

    val totalWaterLiters: Double
        get() = operationalWaterLiters + embodiedWaterLiters
}
