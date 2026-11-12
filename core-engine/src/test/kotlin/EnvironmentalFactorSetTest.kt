
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EnvironmentalFactorSetTest {

    private fun createFactor(
        type: EnvironmentalFactorType,
        region: String = "Example Region",
        year: Int = 2025
    ) = EnvironmentalFactor(
        name = type.name,
        value = 0.5,
        unit = type.expectedUnit,
        source = "Illustrative Example",
        region = region,
        referenceYear = year,
        type = type
    )

    @Test
    fun `matching environmental factors should be accepted`() {
        val factors = EnvironmentalFactorSet(
            carbonIntensity = createFactor(
                EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
            ),
            electricityWater = createFactor(
                EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION
            ),
            coolingWater = createFactor(
                EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS
            )
        )

        assertEquals("Example Region", factors.carbonIntensity.region)
        assertEquals(2025, factors.electricityWater.referenceYear)
    }

    @Test
    fun `different regions should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactorSet(
                carbonIntensity = createFactor(
                    EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY,
                    region = "Texas"
                ),
                electricityWater = createFactor(
                    EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION,
                    region = "Virginia"
                ),
                coolingWater = createFactor(
                    EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS,
                    region = "Texas"
                )
            )
        }
    }

    @Test
    fun `different reference years should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactorSet(
                carbonIntensity = createFactor(
                    EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY,
                    year = 2025
                ),
                electricityWater = createFactor(
                    EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION,
                    year = 2024
                ),
                coolingWater = createFactor(
                    EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS,
                    year = 2025
                )
            )
        }
    }

    @Test
    fun `incorrect factor type should be rejected`() {
        assertFailsWith<IllegalArgumentException> {
            EnvironmentalFactorSet(
                carbonIntensity = createFactor(
                    EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS
                ),
                electricityWater = createFactor(
                    EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION
                ),
                coolingWater = createFactor(
                    EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS
                )
            )
        }
    }
}
