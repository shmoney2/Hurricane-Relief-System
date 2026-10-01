# 🌀 Lifeline Link — Hurricane Relief System
**Team: Quinn and Friends** · CSCE 247 Software Engineering · University of South Carolina

A Java application for coordinating disaster response during hurricane events. Victims submit relief requests describing what they need, which are automatically prioritized by urgency and claimed by volunteers or emergency professionals based on their skills. The system also tracks shelters with live occupancy and accessibility details, lets users mark themselves safe, and allows anyone to report hazards for administrator verification. Administrators oversee the response by approving requests, drawing evacuation zones, and broadcasting alerts.

Built around a facade entry point with singleton managers for each subsystem, backed by JSON persistence.

---

## 👥 Team
| Name | GitHub |
|------|--------|
| Quinn Murphy | [@QuinnMurphy-CSE](https://github.com/QuinnMurphy-CSE) |
| Abaan Jafri | [@ajafri928](https://github.com/ajafri928) |
| Sahil Agarwal | [@shmoney2](https://github.com/shmoney2) |
| Anish Verma | [@AnishV710](https://github.com/AnishV710) |

---

## 📦 Deliverables
| Deliverable | Link |
|-------------|------|
| Software Requirements Specification (SRS) | [requirements.pdf](docs/requirements.pdf) |
| UML Class Diagram | [docs folder](docs) |
| UML Sequence Diagrams | [docs folder](docs) |
| Use Case Diagram | [Lucidchart](PASTE_VIEW_ONLY_LINK) |
| Functional Requirements Spreadsheet | [Requirements Spreadsheet](PASTE_LINK) |
| Sample JSON Data | [jsonfiles](jsonfiles) |
| SCRUM Project Board | [Project Board](PASTE_PROJECT_BOARD_LINK) |

---

## 🚀 Getting Started

### Prerequisites
- JDK 17 or newer
- [Maven](https://maven.apache.org/) (Mac: `brew install maven`)
- VS Code with the **Extension Pack for Java**

### Run it
```bash
git clone https://github.com/shmoney2/Hurricane-Relief-System.git
cd Hurricane-Relief-System/Hurricane/hurricane_system
mvn clean javafx:run
```
A small JavaFX window should open.

> **Apple Silicon (M1/M2/M3) note:** the project uses JavaFX 21.0.5, which supports Apple chips. If you see an `incompatible architecture (have 'x86_64', need 'arm64')` error, run `rm -rf ~/.openjfx/cache` and try again.

---

## 🗂️ Repository Structure
```
Hurricane-Relief-System/
├── docs/                    # SRS, UML class + sequence diagrams
├── jsonfiles/               # JSON data (users, shelters, requests, hazards, events)
├── Hurricane/
│   └── hurricane_system/    # JavaFX Maven project
│       ├── pom.xml
│       └── src/main/
│           ├── java/        # Java source code
│           └── resources/   # FXML views
└── README.md
```

---

## 🏗️ Architecture
- **Facade:** `ReliefSystemFacade` — single entry point used by the UI and Driver
- **Managers (singletons):** `UserManagement`, `ShelterManagement`, `ReliefManagement`, `HazardReportManagement`, `HurricaneEventManagement`
- **Models:** `User`, `Admin`, `Helper`, `Requester`, `RegisteredVictim`, `GuestVictim`, `Shelter`, `ShelterResource`, `ReliefRequest`, `RequestComment`, `HazardReport`, `HurricaneEvent`, `GeographicRegion`, `Location`, `EmergencyContact`
- **Persistence:** `DataLoader`, `DataWriter`, `DataConstants` (JSON)

---

## 🛠️ Built With
- Java + JavaFX 21
- Maven
- JSON