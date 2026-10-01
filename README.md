# 🌀 Lifeline Link — Hurricane Relief System
**Team: Quinn and Friends** · CSCE 247 Software Engineering · University of South Carolina

A Java application for coordinating disaster response during hurricane events. Victims submit relief requests describing what they need, which are automatically prioritized by urgency and claimed by volunteers or emergency professionals based on their skills. The system also tracks shelters with live occupancy and accessibility details, lets users mark themselves safe, and allows anyone to report hazards for administrator verification. Administrators oversee the response by approving requests, drawing evacuation zones, and broadcasting alerts.

Built around a facade entry point with singleton managers for each subsystem, backed by JSON persistence.

---

## Team
| Name | GitHub |
|------|--------|
| Quinn Murphy | [@QuinnMurphy-CSE](https://github.com/QuinnMurphy-CSE) |
| Abaan Jafri | [@ajafri928](https://github.com/ajafri928) |
| Sahil Agarwal | [@shmoney2](https://github.com/shmoney2) |
| Anish Verma | [@AnishV710](https://github.com/AnishV710) |

---

## Deliverables
| Deliverable | Link |
|-------------|------|
| Software Requirements Specification (SRS) | [requirements.pdf](docs/requirements.pdf) |
| UML Class Diagram | [uml-class-diagram.pdf](docs/uml-class-diagram.pdf) |
| UML Sequence Diagrams | [docs folder](docs) |
| Use Case Diagram | [Lucidchart](https://lucid.app/lucidchart/d0686cc7-17bb-437d-8419-874bf28d4732/edit?viewport_loc=-3623%2C-2867%2C10147%2C6444%2C0_0&invitationId=inv_e1131cec-8aa1-41bc-b340-5b284f1b46ed) |
| Functional Requirements Spreadsheet | [Requirements Spreadsheet](https://emailsc-my.sharepoint.com/:x:/g/personal/qrmurphy_email_sc_edu/IQDfv9UA8K3ITZQTtXJ2nSvXAbbut9_ley5XSkfzBaxgKuw?e=J2nEKe) |
| Sample JSON Data | [jsonfiles](jsonfiles) |
| SCRUM Project Board | [Project Board](https://github.com/users/shmoney2/projects/1) |

---

## Prototype Section
- coming soon

---

## Presentation Section
- coming soon

---

## Getting Started


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

---

## Repository Structure
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

## Built With
- Java + JavaFX 21
- Maven
- JSON