
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EnvironmentalFactorTest {

    @Test
    fun `valid environmental factor should store its data`() {
        val factor = EnvironmentalFactor(
            name = "Electricity Carbon Intensity",
            value = 0.4,
            unit = "kg CO2e/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025
        )

        assertEquals("Electricity Carbon Intensity", factor.name)
        assertEquals(0.4, factor.value, 0.0001)
        assertEquals("kg CO2e/kWh", factor.unit)
        assertEquals("Illustrative Example", factor.source)
        assertEquals("Example Region", factor.region)
        assertEquals(2025, factor.referenceYear)
    }

    @Test
    fun `negative environmental factor should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactor(
                name = "Electricity Carbon Intensity",
                value = -0.4,
                unit = "kg CO2e/kWh",
                source = "Illustrative Example",
                region = "Example Region",
                referenceYear = 2025
            )
        }
    }

    @Test
    fun `missing source should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactor(
                name = "Electricity Carbon Intensity",
                value = 0.4,
                unit = "kg CO2e/kWh",
                source = "",
                region = "Example Region",
                referenceYear = 2025
            )
        }
    }

    @Test
    fun `non finite value should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactor(
                name = "Electricity Carbon Intensity",
                value = Double.NaN,
                unit = "kg CO2e/kWh",
                source = "Illustrative Example",
                region = "Example Region",
                referenceYear = 2025
            )
        }
    }

    @Test
    fun `invalid reference year should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactor(
                name = "Electricity Carbon Intensity",
                value = 0.4,
                unit = "kg CO2e/kWh",
                source = "Illustrative Example",
                region = "Example Region",
                referenceYear = 1800
            )
        }
    }
    @Test
    fun `correct carbon intensity unit should be accepted`() {
        val factor = EnvironmentalFactor(
            name = "Electricity Carbon Intensity",
            value = 0.4,
            unit = "kg CO2e/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025,
            type = EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
        )

        assertEquals("kg CO2e/kWh", factor.unit)
    }

    @Test
    fun `incorrect carbon intensity unit should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactor(
                name = "Electricity Carbon Intensity",
                value = 400.0,
                unit = "g CO2e/kWh",
                source = "Illustrative Example",
                region = "Example Region",
                referenceYear = 2025,
                type = EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
            )
        }
    }

    @Test
    fun `electricity water factor should accept liters per kilowatt hour`() {
        val factor = EnvironmentalFactor(
            name = "Electricity Water Consumption",
            value = 1.0,
            unit = "L/kWh",
            source = "Illustrative Example",
            region = "Example Region",
            referenceYear = 2025,
            type = EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION
        )

        assertEquals("L/kWh", factor.unit)
    }
}
