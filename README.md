# 🚀 Automation Framework - FakeStoreAPI

Framework de automatización para pruebas de la API [FakeStoreAPI](https://fakestoreapi.com/).  
Incluye test completo, schema validation y reporting.

![RestAssured](https://img.shields.io/badge/RestAssured-4.5.1-green)
![Postman](https://img.shields.io/badge/Postman-Smoke_Test-orange)
![GitHub Actions](https://img.shields.io/github/actions/workflow/status/tu-usuario/repo/main.yml?label=CI/CD)

## 📌 Características Clave
- **Cobertura Completa**: Endpoints principales + edge cases
- **Validación Estricta**: Schema validation
- **Reporting**: Allure Reports
- **Smoke Test Rápido**: Colección Postman lista para ejecución

## 🛠️ Stack Tecnológico
| Tecnología          | Uso                            |
|---------------------|--------------------------------|
| Java                | Lenguaje base                  | 
| RestAssured         | Cliente HTTP + Validaciones    |
| TestNG              | Test Runner + Assertions       |
| Allure              | Report Generation              |
| Jackson             | Serialización/Deserialización  |
| Java Faker          | Datos Aleatorios               |

## 🗂️ Estructura del Proyecto
```plaintext
src/
├── test/
    ├── java/
    |    ├── api/                # API Tests
    |    ├── listeners           # Suite and Test listeners
    |    ├── models              # DTOs para requests/responses
    |    └── requests            # Request especificas de cada endpoint
    |    
    └── resources
        ├── requestBody
        └── Schemas
```

## Smoke Test con Postman

Coleccion: [Fakestore Collection](src/test/resources/postman/FakestoreAPI.postman_collection.json)

**Qué valida:**

✅ Status Codes criticos

✅ Respuestas básicas

✅ Tiempos de respuesta promedio

**Cómo ejecutar:**

*Por terminal:* 

1. Instalar Newman
``` bash
npm install -g newman
```

2. Copiar el path del archivo

3. Ejecutar el siguiente comando
```bash
newman run path/del/archivo.json
```

*Por Shell Script:*

1. Darle permisos
```bash
chmod +x smokePostman.sh
```

2. Ejecutar el archivo Shell Script
```bash
./smokePostman.sh
```

## 🧪 **Test Automation con RestAssured**  

## **Estrategia de Automatización**

- **Cobertura de Endpoints:**
    - ✅ Login: `GET /auth/login`
    - ✅ Products: `GET /products`, `GET /products/{id}`, `GET /products/categories`, `GET /products/category/{category}`, `POST /products`, `PUT /products/{id}`, `PATCH /products/{id}`, `DELETE /products/{id}`
    - ✅ Cart: `GET /carts`, `GET /carts/{id}`, `GET /carts/user/{id}`, `POST /carts`, `PUT /products/{id}`,
    `PATCH /products/{id}`, `DELETE /carts/{id}`
    - ✅ User: `GET /users`, `GET /users/{id}`, `POST /users`, `PUT /users/{id}`, `PATCH /users/{id}`, `DELETE /users/{id}`
---

- **Tipos de pruebas:**
    - **Happy Path**: Flujos exitosos con datos válidos. 
    - **Unhappy Path**: Validacion de errores (400,401,403,404).
    - **Schema Validation**: Verificacion de estructuras JSON con JSON Schema.

## 🚀 Ejecución de Pruebas

### **Comandos Maven**
```bash
# Ejecutar suite completa (Regression + Smoke)
./mvnw clean test

# Ejecutar test smoke
./mvnw test -Dgroups="smoke"

# Ejecutar test regression
./mvnw test -Dgroups="regression"
```