package org.example

data class HardwareModel(
    val manufacturingCarbon: Double, // total kg CO2
    val manufacturingWater: Double,  // total liters
    val lifespanHours: Double        // total usable hours
) {

    fun carbonPerHour(): Double {
        return manufacturingCarbon / lifespanHours
    }

    fun waterPerHour(): Double {
        return manufacturingWater / lifespanHours
    }

    fun allocatedCarbon(jobHours: Double): Double {
        return carbonPerHour() * jobHours
    }

    fun allocatedWater(jobHours: Double): Double {
        return waterPerHour() * jobHours
    }
}