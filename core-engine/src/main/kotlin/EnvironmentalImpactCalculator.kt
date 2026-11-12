
package org.example

class EnvironmentalImpactCalculator {

    fun calculate(
        energy: EnergyModel,
        hardware: HardwareModel,
        water: WaterModel
    ): EnvironmentalImpactReport {

        val itEnergy = energy.totalEnergyUsed()
        val facilityEnergy = water.facilityEnergyKWh()

        require(
            kotlin.math.abs(itEnergy - water.itEnergyKWh) < 0.0001
        ) {
            "EnergyModel and WaterModel must use the same IT energy."
        }

        val operationalCarbon =
            facilityEnergy * energy.carbonPerKWh

        val electricityCost =
            facilityEnergy * energy.costPerKWh

        val embodiedCarbon =
            hardware.allocatedCarbon(energy.trainingHours)

        val embodiedWater =
            hardware.allocatedWater(energy.trainingHours)

        return EnvironmentalImpactReport(
            itEnergyKWh = itEnergy,
            facilityEnergyKWh = facilityEnergy,
            electricityCostUSD = electricityCost,
            operationalCarbonKg = operationalCarbon,
            embodiedCarbonKg = embodiedCarbon,
            directWaterLiters = water.directWaterLiters(),
            indirectWaterLiters = water.indirectWaterLiters(),
            embodiedWaterLiters = embodiedWater
        )
    }
}
