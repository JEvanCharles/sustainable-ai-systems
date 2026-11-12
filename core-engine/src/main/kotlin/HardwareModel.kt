package org.example

data class HardwareModel(
    val manufacturingCarbon: Double,
    val manufacturingWater: Double,
    val lifespanHours: Double,
    val gpuCount: Int = 1,
    val utilizationRate: Double = 1.0,
    val allocationShare: Double = 1.0
) {
    init {
        require(manufacturingCarbon >= 0.0)
        require(manufacturingWater >= 0.0)
        require(lifespanHours > 0.0)
        require(gpuCount > 0)
        require(utilizationRate in 0.0..1.0)
        require(allocationShare in 0.0..1.0)
    }

    fun carbonPerHour(): Double {
        return (manufacturingCarbon / lifespanHours) *
                gpuCount * allocationShare
    }

    fun waterPerHour(): Double {
        return (manufacturingWater / lifespanHours) *
                gpuCount * allocationShare
    }

    fun allocatedCarbon(jobHours: Double): Double {
        require(jobHours >= 0.0)
        return carbonPerHour() * jobHours
    }

    fun allocatedWater(jobHours: Double): Double {
        require(jobHours >= 0.0)
        return waterPerHour() * jobHours
    }
}
