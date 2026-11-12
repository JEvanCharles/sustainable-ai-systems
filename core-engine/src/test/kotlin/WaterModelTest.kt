
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WaterModelTest {

    @Test
    fun `direct water consumption should be calculated correctly`() {
        val model = WaterModel(
            itEnergyKWh = 50.0,
            waterUsageEffectiveness = 0.5,
            electricityWaterFactor = 1.0,
            powerUsageEffectiveness = 1.2
        )

        assertEquals(25.0, model.directWaterLiters(), 0.0001)
    }

    @Test
    fun `facility energy should include PUE`() {
        val model = WaterModel(
            itEnergyKWh = 50.0,
            waterUsageEffectiveness = 0.5,
            electricityWaterFactor = 1.0,
            powerUsageEffectiveness = 1.2
        )

        assertEquals(60.0, model.facilityEnergyKWh(), 0.0001)
    }

    @Test
    fun `indirect water consumption should be calculated correctly`() {
        val model = WaterModel(
            itEnergyKWh = 50.0,
            waterUsageEffectiveness = 0.5,
            electricityWaterFactor = 1.0,
            powerUsageEffectiveness = 1.2
        )

        assertEquals(60.0, model.indirectWaterLiters(), 0.0001)
    }

    @Test
    fun `total operational water should equal direct plus indirect`() {
        val model = WaterModel(
            itEnergyKWh = 50.0,
            waterUsageEffectiveness = 0.5,
            electricityWaterFactor = 1.0,
            powerUsageEffectiveness = 1.2
        )

        assertEquals(85.0, model.totalWaterLiters(), 0.0001)
    }

    @Test
    fun `negative energy should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            WaterModel(
                itEnergyKWh = -10.0,
                waterUsageEffectiveness = 0.5,
                electricityWaterFactor = 1.0
            )
        }
    }
}
