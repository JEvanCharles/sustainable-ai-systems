
package org.example

object EnvironmentalModelFactory {

    fun createEnergyModel(
        trainingHours: Double,
        energyPerHourKWh: Double,
        costPerKWh: Double,
        factors: EnvironmentalFactorSet
    ): EnergyModel {
        return EnergyModel(
            trainingHours = trainingHours,
            energyPerHourKWh = energyPerHourKWh,
            costPerKWh = costPerKWh,
            carbonPerKWh = factors.carbonIntensity.value
        )
    }

    fun createWaterModel(
        itEnergyKWh: Double,
        powerUsageEffectiveness: Double,
        factors: EnvironmentalFactorSet
    ): WaterModel {
        return WaterModel(
            itEnergyKWh = itEnergyKWh,
            waterUsageEffectiveness = factors.coolingWater.value,
            electricityWaterFactor = factors.electricityWater.value,
            powerUsageEffectiveness = powerUsageEffectiveness
        )
    }
}
