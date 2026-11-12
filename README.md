
# Sustainable AI Systems

An open-source Kotlin framework for estimating and
eventually optimizing the environmental impacts of
artificial intelligence computing workloads.

## Overview

AI computing consumes electricity, generates
greenhouse gas emissions, and contributes to water
consumption throughout its lifecycle.

Sustainable AI Systems aims to provide a transparent,
reproducible framework for evaluating these impacts
and supporting more sustainable computing decisions.

The project combines software engineering,
environmental accounting, and industrial engineering
principles.

## Current Features

### Energy Modeling
- IT electricity consumption
- Facility electricity consumption using PUE
- Electricity cost estimation
- Operational carbon emissions

### Hardware Lifecycle Modeling
- Allocated GPU manufacturing carbon
- Allocated GPU manufacturing water
- Hardware lifespan assumptions
- GPU count and allocation share

### Water Modeling
- Direct data center cooling water consumption
- Indirect electricity-related water consumption
- Total operational water consumption

### Unified Environmental Reporting
- Combined energy, carbon, water, and cost estimates
- Operational and embodied impact breakdowns
- Input consistency validation

### Software Quality
- 16 automated Kotlin unit and integration tests
- GitHub Actions continuous integration
- Gradle build system
- Java 21

## Example Results

The following results use hypothetical inputs
for demonstration purposes.

| Metric | Result |
|---|---|
| IT Electricity | 50 kWh |
| Facility Electricity | 60 kWh |
| Electricity Cost | $7.20 |
| Operational Carbon | 24 kg CO2e |
| Embodied Carbon | 4 kg CO2e |
| Total Carbon | 28 kg CO2e |
| Direct Cooling Water | 25 L |
| Indirect Electricity Water | 60 L |
| Embodied Hardware Water | 100 L |
| Total Water | 185 L |

These values are illustrative and do not represent
verified measurements from a real AI workload.

## Project Structure

```text
sustainable-ai-systems/
├── .github/workflows/
├── core-engine/
│   ├── src/main/kotlin/
│   └── src/test/kotlin/
├── carbon-model/
├── docs/
├── experiments/
├── scheduler/
└── README.md
```

## Running the Project

Requirements:
- Java 21

From the repository root:

```bash
cd core-engine
```

On macOS or Linux:

```bash
./gradlew run
```

On Windows:

```powershell
.\gradlew.bat run
```

Note: The Gradle `run` task requires the
application plugin and main-class configuration.
Until that is configured, run `Main.kt` directly
through IntelliJ.

## Running Tests

From the `core-engine` directory:

On macOS or Linux:

```bash
./gradlew test
```

On Windows:

```powershell
.\gradlew.bat test
```

Tests also run automatically through GitHub Actions.

## Accounting Methodology

See [Accounting Methodology](docs/ACCOUNTING_METHODOLOGY.md)
for formulas, assumptions, system boundaries,
and current limitations.

## Development Roadmap

### Phase 1 — Environmental Modeling
- [x] Energy consumption model
- [x] Hardware manufacturing impact allocation
- [x] Operational water consumption model
- [x] Unified environmental report
- [x] Automated testing and CI
- [x] Initial accounting methodology

### Phase 2 — Data Integration
- [ ] Published electricity carbon intensity data
- [ ] Electricity-related water consumption factors
- [ ] Regional environmental datasets
- [ ] Input provenance and validation

### Phase 3 — Simulation and Optimization
- [ ] Compare hardware configurations
- [ ] Model regional environmental differences
- [ ] Evaluate workload scheduling scenarios
- [ ] Multi-objective optimization

### Phase 4 — Application Development
- [ ] User-configurable scenarios
- [ ] Interactive visualization
- [ ] API integration
- [ ] Exportable environmental reports

## Project Status

Early-stage research and software development.

Current models use illustrative parameters and
simplified accounting assumptions. They are not
intended for verified corporate environmental
reporting without further validation.

## License

See [LICENSE](LICENSE).
