
package org.example

data class WaterModel(
    val itEnergyKWh: Double,
    val waterUsageEffectiveness: Double,
    val electricityWaterFactor: Double,
    val powerUsageEffectiveness: Double = 1.0
) {
    init {
        require(itEnergyKWh >= 0.0 && itEnergyKWh.isFinite())
        require(waterUsageEffectiveness >= 0.0 && waterUsageEffectiveness.isFinite())
        require(electricityWaterFactor >= 0.0 && electricityWaterFactor.isFinite())
        require(powerUsageEffectiveness >= 1.0 && powerUsageEffectiveness.isFinite())
    }

    fun directWaterLiters(): Double {
        return itEnergyKWh * waterUsageEffectiveness
    }

    fun facilityEnergyKWh(): Double {
        return itEnergyKWh * powerUsageEffectiveness
    }

    fun indirectWaterLiters(): Double {
        return facilityEnergyKWh() * electricityWaterFactor
    }

    fun totalWaterLiters(): Double {
        return directWaterLiters() + indirectWaterLiters()
    }
}
