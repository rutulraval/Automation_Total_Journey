<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,12,18&height=200&section=header&text=Automation%20Total%20Journey&fontSize=38&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=Complete%20SDET%20Learning%20Path%20%7C%20Selenium%20%7C%20REST%20Assured%20%7C%20BDD%20%7C%20Java&descAlignY=62&descSize=15" width="100%"/>

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white"/>
  <img src="https://img.shields.io/badge/REST_Assured-4CAF50?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
  <img src="https://img.shields.io/badge/Lombok-pink?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/25%2B_Modules-Covered-0e75b6?style=for-the-badge"/>
</p>

</div>

---

## 📋 Repository Overview

**Automation Total Journey** is a comprehensive, structured SDET knowledge repository documenting an end-to-end progression through software test automation — from foundational Java programming concepts through to advanced framework design, API testing, and BDD implementation. Each numbered module folder contains working Java/Maven projects, annotated screenshots, and detailed notes capturing the conceptual rationale behind each technique.

This repository functions simultaneously as a **practical coding portfolio** and a **knowledge base**, demonstrating hands-on implementation of industry-standard automation tools and patterns used in professional SDET roles.

---

## 🗂️ Module Catalogue

The repository is organised into **25+ progressive modules**, each building upon the last:

| # | Module | Key Concepts Covered |
|:---|:---|:---|
| 1 | Java Core Foundations | OOP, classes, control flow, data types |
| 2 | JUnit & Maven Intro | Test lifecycle, dependency management, build automation |
| 3a | Selenium WebDriver Introduction | Browser setup, driver instantiation, basic navigation |
| 4 | Automation with Selenium WebDriver | `get()`, `findElement()`, `sendKeys()`, `click()`, `quit()` |
| 5a | Add to Basket — E2E Scenario | End-to-end UI flow automation |
| 6 | Lombok Integration | `@Data`, `@Builder`, `@Getter`/`@Setter` — boilerplate elimination |
| 7a | Properties Files & HashMap | Externalised config, key-value data structures in automation |
| 7b | Generic Framework Design | Reusable base classes, driver factory, configuration abstraction |
| 8 | XPath & WebElement Intro | Absolute vs relative XPath, element targeting strategies |
| 9 | Debugging & Locators | DevTools inspection, By strategies: ID, Name, CSS, XPath |
| 10 | Locators Continued + API Status Codes | Advanced locators, HTTP status code reference for API testing |
| 11 | Intro to REST API & XPath | REST principles, GET/POST/PUT/DELETE, XPath in API responses |
| 12 | XPath Special Functions | `contains()`, `starts-with()`, `text()`, `normalize-space()` |
| 13 | XPath Axes Locators | `parent::`, `child::`, `following-sibling::`, `preceding::` |
| 14 | WebDriver Commands | `navigate()`, `manage()`, window handles, cookies, timeouts |
| 15a | Shadow DOM | `JavascriptExecutor` for accessing shadow root elements |
| 15b | HTML & CSS Fundamentals | DOM structure, CSS selectors for test-aware UI understanding |
| 16 | iFrames | `switchTo().frame()`, nested frames, returning to default content |
| 17 | Alert Popups | `switchTo().alert()`, `accept()`, `dismiss()`, `sendKeys()` to alerts |
| 18 | JavaScript Executor | `executeScript()` for scroll, click, visibility, DOM manipulation |
| 19 | Checkboxes, Radio Buttons & Dropdowns | `Select` class, `isSelected()`, multi-option handling |
| 20b | Dynamic Dropdowns & Sorting | Live list handling, `WebDriverWait` + `ExpectedConditions` |
| 21 | Waits & Date Picker | Implicit/Explicit/Fluent waits, calendar widget automation |
| 22 | Actions — Mouse & Keyboard Events | `Actions` API: `moveToElement()`, `dragAndDrop()`, `keyDown()` |
| 23 | Tooltip & MouseHover | `moveToElement()` + tooltip text extraction |
| 24 | Test Driven Development (TDD) | Red–Green–Refactor cycle, unit test design |
| 25 | Intro to BDD, Jira & Agile | Feature files, Gherkin syntax, Agile ceremonies, Jira workflows |

### Specialised Sub-Projects

| Sub-Project | Description |
|:---|:---|
| `CucumberBDD/` | Full BDD suite with Feature files, Step Definitions, and TestRunner |
| `SeleniumPOM/` | Page Object Model framework with base page, page classes, and test layer |
| `RestAssuredAutomation/` | API test suite using REST Assured: CRUD operations, JSON extraction, assertions |
| `Manual Testing Notes/` | Comprehensive manual QA notes: SDLC, STLC, defect lifecycle, test types |

---

## 🛠️ Technology Stack

| Technology | Role |
|:---|:---|
| **Java** | Primary automation language across all modules |
| **Selenium WebDriver 4.x** | UI browser automation |
| **Maven** | Build system, dependency management, plugin configuration |
| **REST Assured** | API test automation (CRUD: GET, POST, PUT, DELETE) |
| **Cucumber / Gherkin** | BDD framework for feature-level specifications |
| **JUnit** | Test runner and assertion library |
| **Lombok** | Annotation-based boilerplate reduction |
| **WebDriverManager** | Automatic driver binary resolution |
| **JavaScript Executor** | DOM manipulation in advanced Selenium scenarios |
| **IntelliJ IDEA** | IDE with Maven integration |

**Repository composition:**

```
Java source code (modules + sub-projects)   ████████████░░░░░░░░  ~55%
Notes & documentation (txt, docx)           ████████░░░░░░░░░░░░  ~30%
Screenshots & visual evidence (png, jpg)    ████░░░░░░░░░░░░░░░░  ~12%
Config & XML                                █░░░░░░░░░░░░░░░░░░░   ~3%
```

---

## 🔑 Key Design Patterns & Principles

- **Page Object Model (POM)** — implemented in `SeleniumPOM/`: each page has a dedicated class encapsulating its locators and interaction methods, decoupling test logic from UI structure
- **Factory Pattern** — `DriverFactory` centralises WebDriver instantiation and teardown, enabling thread-safe browser management
- **Data Externalisation** — `config.properties` and `HashMap`-based data stores eliminate hardcoded values from test code
- **BDD Specification by Example** — Gherkin feature files in `CucumberBDD/` express behaviour in plain English, enabling non-technical stakeholder review
- **Explicit Waits over Implicit** — `WebDriverWait` with `ExpectedConditions` is used throughout to avoid race conditions and brittle timing

---

## 📈 Coverage Quantification

| Domain | Modules / Files | Techniques Practised |
|:---|:---:|:---|
| UI Automation (Selenium) | 20+ | Locators, waits, actions, frames, alerts, JS, dropdowns |
| API Testing (REST Assured) | 1 sub-project | GET · POST · PUT · DELETE · JSON path extraction |
| BDD (Cucumber) | 1 sub-project | Feature files, step defs, data tables, scenario outlines |
| Framework Design | 2 sub-projects | POM, DriverFactory, generic base classes |
| Manual QA Knowledge | 1 module | SDLC, STLC, defect lifecycle, test types, Agile, Jira |

---

## 🚀 Getting Started

### Prerequisites

- Java 11+ (Java 21 recommended)
- Apache Maven 3.8+
- IntelliJ IDEA or Eclipse

### Run any module

```bash
# Navigate to a module with a pom.xml
cd SeleniumPOM
mvn clean test

# Or run the BDD suite
cd CucumberBDD
mvn clean test

# Or the REST Assured API tests
cd RestAssuredAutomation
mvn clean test
```

---

<div align="center">

**👤 Author: [Rutul Raval](https://github.com/rutulraval)** · SDET | ISTQB Certified | Peterborough, UK

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,12,18&height=100&section=footer" width="100%"/>

</div>
