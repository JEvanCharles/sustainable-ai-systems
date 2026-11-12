
package org.example

enum class EnvironmentalFactorType(
    val expectedUnit: String
) {
    ELECTRICITY_CARBON_INTENSITY("kg CO2e/kWh"),
    ELECTRICITY_WATER_CONSUMPTION("L/kWh"),
    WATER_USAGE_EFFECTIVENESS("L/kWh")
}
