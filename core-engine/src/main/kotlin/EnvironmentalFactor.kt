package org.example

data class EnvironmentalFactor(
    val name: String,
    val value: Double,
    val unit: String,
    val source: String,
    val region: String,
    val referenceYear: Int,
    val type: EnvironmentalFactorType =
        EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
) {
    init {
        require(name.isNotBlank()) {
            "Factor name cannot be empty."
        }

        require(value.isFinite() && value >= 0.0) {
            "Factor value must be finite and non-negative."
        }

        require(unit.isNotBlank()) {
            "Factor unit cannot be empty."
        }

        require(unit == type.expectedUnit) {
            "Incorrect unit for $type. Expected ${type.expectedUnit}, got $unit."
        }

        require(source.isNotBlank()) {
            "Data source cannot be empty."
        }

        require(region.isNotBlank()) {
            "Region cannot be empty."
        }

        require(referenceYear in 1900..2100) {
            "Reference year must be between 1900 and 2100."
        }
    }
}


