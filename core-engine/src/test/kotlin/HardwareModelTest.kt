package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class HardwareModelTest {

    @Test
    fun `four GPUs should allocate four kilograms of carbon`() {
        val hardware = HardwareModel(
            manufacturingCarbon = 2000.0,
            manufacturingWater = 50000.0,
            lifespanHours = 20000.0,
            gpuCount = 4,
            utilizationRate = 0.75,
            allocationShare = 1.0
        )

        val result = hardware.allocatedCarbon(10.0)

        assertEquals(4.0, result, 0.0001)
    }

    @Test
    fun `four GPUs should allocate 100 liters of water`() {
        val hardware = HardwareModel(
            manufacturingCarbon = 2000.0,
            manufacturingWater = 50000.0,
            lifespanHours = 20000.0,
            gpuCount = 4,
            allocationShare = 1.0
        )

        val result = hardware.allocatedWater(10.0)

        assertEquals(100.0, result, 0.0001)
    }

    @Test
    fun `utilization should not change reserved hardware impact`() {
        val hardware = HardwareModel(
            manufacturingCarbon = 2000.0,
            manufacturingWater = 50000.0,
            lifespanHours = 20000.0,
            gpuCount = 4,
            utilizationRate = 0.25,
            allocationShare = 1.0
        )

        val result = hardware.allocatedCarbon(10.0)

        assertEquals(4.0, result, 0.0001)
    }

    @Test
    fun `zero lifespan should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            HardwareModel(
                manufacturingCarbon = 2000.0,
                manufacturingWater = 50000.0,
                lifespanHours = 0.0
            )
        }
    }
}
