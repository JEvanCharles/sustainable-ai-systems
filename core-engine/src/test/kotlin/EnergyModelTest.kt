
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class EnergyModelTest {

    @Test
    fun `energy consumption should equal hours times energy rate`() {
        val model = EnergyModel(
            trainingHours = 10.0,
            energyPerHourKWh = 5.0,
            costPerKWh = 0.12,
            carbonPerKWh = 0.4
        )

        assertEquals(50.0, model.totalEnergyUsed(), 0.0001)
    }

    @Test
    fun `electricity cost should be calculated correctly`() {
        val model = EnergyModel(
            trainingHours = 10.0,
            energyPerHourKWh = 5.0,
            costPerKWh = 0.12,
            carbonPerKWh = 0.4
        )

        assertEquals(6.0, model.totalCost(), 0.0001)
    }

    @Test
    fun `carbon emissions should be calculated correctly`() {
        val model = EnergyModel(
            trainingHours = 10.0,
            energyPerHourKWh = 5.0,
            costPerKWh = 0.12,
            carbonPerKWh = 0.4
        )

        assertEquals(20.0, model.totalEmissions(), 0.0001)
    }
}
