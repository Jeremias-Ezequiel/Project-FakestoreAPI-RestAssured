# 🚀 Automation Framework - FakeStoreAPI

Automation framework for testing the [FakeStoreAPI](https://fakestoreapi.com/).  
Include full test coverage with schema validation and reporting.

[![RestAssured](https://img.shields.io/badge/Rest_Assured-4.5.1-FF5733?logo=restassured&logoColor=white)](https://rest-assured.io)
[![Postman](https://img.shields.io/badge/Postman-Smoke_Test-FF6C37?logo=postman&logoColor=white)](https://postman.com)
[![Java](https://img.shields.io/badge/Java_17☕-orange)](https://java.com)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-00AA00?logo=testng&logoColor=white)](https://testng.org)

## 📌 Key Features
- **Full Coverage**: Critical Endpoints
- **Strict Validation**: Schema validation
- **Reporting**: Allure Reports
- **Quick Smoke Test**: Ready to run Postman collection

## 🛠️ Technology Stack
| Technology          | Purpose                        |
|---------------------|--------------------------------|
| Java                | Core Language                  | 
| RestAssured         | HTTP Client + Validations      |
| TestNG              | Test Runner + Assertions       |
| Allure              | Report Generation              |
| Jackson             | Serialization/Deserialization  |
| Java Faker          | Test Data Generation           |

## 🗂️ Project Structure
```plaintext
src/
├── test/
    ├── java/
    |    ├── api/                # API Test Implementations
    |    ├── listeners           # Suite and Test listeners
    |    ├── models              # Request/Response DTOs
    |    └── requests            # Endpoint-Specific Request Builders
    |    
    └── resources
        ├── requestBody          # Sample Request Bodies
        ├── Postman              # Postman collection files
        └── Schemas              # JSON Schema Definitions
```

## Postman Collection

In this collection contains some tests that will be tested with Rest Assured

**Collection**: [Fakestore Collection](https://www.postman.com/jeremias03/workspace/project-fakestoreapi/collection/36953447-d2131652-4f80-450e-ae5c-a908586a9a47?action=share&creator=36953447)

**Validation Scope:**

✅ Critical Status Code

✅ Basic Response Structure Validation

✅ Average Response time 

## 🧪 **Test Automation with Rest Assured**  

## **Automation Strategy**

- **Covered Endpoints:**
    - ✅ Login: `GET /auth/login`
    - ✅ Products: `GET /products`, `GET /products/{id}`, `GET /products/categories`, `GET /products/category/{category}`, `POST /products`, `PUT /products/{id}`, `PATCH /products/{id}`, `DELETE /products/{id}`
    - ✅ Cart: `GET /carts`, `GET /carts/{id}`, `GET /carts/user/{id}`, `POST /carts`, `PUT /products/{id}`,
    `PATCH /products/{id}`, `DELETE /carts/{id}`
    - ✅ User: `GET /users`, `GET /users/{id}`, `POST /users`, `PUT /users/{id}`, `PATCH /users/{id}`, `DELETE /users/{id}`
---

- **Test Types:**
    - **Happy Path**: Valid request with positive scenarios. 
    - **Unhappy Path**: Error validation(400,401,403,404).
    - **Schema Validation**: JSON structure verification using JSON Schema.

## 🚀 Test Execution

### **Maven Commands**
```bash
# Run full test suite (Regression + Smoke)
./mvnw clean test

# Execute smoke tests only
./mvnw test -Dgroups="smoke"

# Execute regression tests
./mvnw test -Dgroups="regression"
```