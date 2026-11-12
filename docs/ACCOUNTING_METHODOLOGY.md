
# Environmental Accounting Methodology

## Project Overview

Sustainable AI Systems is an open-source framework
for estimating the environmental impacts of AI
computing workloads.

The current implementation estimates:

- IT electricity consumption
- Facility electricity consumption
- Electricity cost
- Operational carbon emissions
- Allocated hardware manufacturing carbon
- Direct cooling water consumption
- Indirect electricity-related water consumption
- Allocated hardware manufacturing water

## 1. Energy Accounting

IT Energy (kWh) =
Training Hours × IT Energy Rate (kWh/hour)

Facility Energy (kWh) =
IT Energy × Power Usage Effectiveness (PUE)

PUE accounts for additional facility electricity
beyond the IT equipment itself.

## 2. Carbon Accounting

Operational Carbon (kg CO2e) =
Facility Energy × Electricity Carbon Factor

Allocated Embodied Carbon (kg CO2e) =
(Manufacturing Carbon / Hardware Lifespan Hours)
× GPU Count × Allocation Share × Job Hours

Total Carbon =
Operational Carbon + Allocated Embodied Carbon

The current model assumes the carbon factor
applies to facility electricity.

## 3. Water Accounting

Direct Water Consumption (L) =
IT Energy × Water Usage Effectiveness (L/kWh)

Indirect Water Consumption (L) =
Facility Energy × Electricity Water Factor (L/kWh)

Allocated Embodied Water (L) =
(Manufacturing Water / Hardware Lifespan Hours)
× GPU Count × Allocation Share × Job Hours

Total Water =
Direct Water + Indirect Water + Allocated Embodied Water

Water consumption is distinct from water withdrawal.
Inputs must use compatible consumption definitions
and accounting boundaries.

## 4. Hardware Allocation

Hardware manufacturing impacts are allocated
linearly across an assumed useful lifespan.

GPU utilization and allocation share are separate
parameters.

In the current implementation, utilization does not
directly change embodied impact allocation.

Allocation share determines the portion of hardware
manufacturing impacts assigned to a workload.

## 5. Current Assumptions

- Input factors are user-provided.
- Demonstration values are hypothetical.
- Electricity carbon intensity is constant during a job.
- Electricity water intensity is constant during a job.
- PUE and WUE are constant during a job.
- Hardware manufacturing impacts are allocated linearly.
- Manufacturing impacts are assumed to be per GPU.
- No geographic water-stress weighting is applied.
- All combined totals require compatible boundaries.

## 6. Current Limitations

The framework does not yet model:

- Time-varying electricity grid conditions
- Regional water scarcity
- Workload-dependent GPU power consumption
- Hardware recycling or end-of-life impacts
- Data center construction impacts
- Uncertainty in environmental input factors
- Detailed hardware utilization-based allocation
- Multi-region scheduling optimization

The current estimates should not be interpreted
as independently verified environmental measurements.

## 7. Planned Improvements

Future versions will introduce:

1. Published environmental datasets
2. Regional electricity and water factors
3. Water-stress-adjusted impact indicators
4. Workload and hardware configuration comparisons
5. Multi-objective optimization
6. Uncertainty and sensitivity analysis
7. Reproducible environmental impact reports
