
package org.example

data class EnvironmentalFactorSet(
    val carbonIntensity: EnvironmentalFactor,
    val electricityWater: EnvironmentalFactor,
    val coolingWater: EnvironmentalFactor
) {
    init {
        require(
            carbonIntensity.type ==
                    EnvironmentalFactorType.ELECTRICITY_CARBON_INTENSITY
        ) {
            "Carbon intensity factor has the wrong type."
        }

        require(
            electricityWater.type ==
                    EnvironmentalFactorType.ELECTRICITY_WATER_CONSUMPTION
        ) {
            "Electricity water factor has the wrong type."
        }

        require(
            coolingWater.type ==
                    EnvironmentalFactorType.WATER_USAGE_EFFECTIVENESS
        ) {
            "Cooling water factor has the wrong type."
        }

        require(
            carbonIntensity.region == electricityWater.region &&
                    electricityWater.region == coolingWater.region
        ) {
            "Environmental factors must use the same region."
        }

        require(
            carbonIntensity.referenceYear == electricityWater.referenceYear &&
                    electricityWater.referenceYear == coolingWater.referenceYear
        ) {
            "Environmental factors must use the same reference year."
        }
    }
}
