# Insurance Policy Excel Exporter

This is a Spring Boot web application built using **Spring MVC**, **Hibernate**, and **Apache POI**.  
It allows users to **download matured insurance policy data into an Excel (.xlsx) file** from a simple **HTML interface**.

## 🛠️ Technologies Used

- Java 8+
- Spring Boot
- Spring MVC
- Hibernate / JPA
- Apache POI (for Excel export)
- HTML/CSS (Static frontend)
- Maven (for build)
- MySQL or H2 (for data storage)

## 🚀 Features

- Display matured insurance policies in a web interface
- Export policy data to Excel format with one click
- Clean and simple code structure using Spring patterns

## 📦 Project Structure

## 📦 Project Structure

src/
├── main/
│ ├── java/
│ │ └── insurance/
│ │ ├── Entity_Class.java
│ │ ├── ExcelGeneratorService.java
│ │ ├── InsuranceApplication.java
│ │ ├── PolicyController.java
│ │ ├── PolicyRepository.java
│ │ ├── PolicyService.java
│ │ └── PolicyServiceImpl.java
│ └── resources/
│ ├── application.properties
│ └── static/
│ └── index.html





---

## 🗄️ Database Setup (MySQL)

### 📌 Database Name: `insurance_db`  
### 📌 Table Name: `insurance`

### 🔧 SQL to Create Database and Table

1. Open MySQL and run:

```sql
CREATE DATABASE insurance_db;

USE insurance_db;

CREATE TABLE insurance (
    policy_id INT PRIMARY KEY AUTO_INCREMENT,
    policy_number VARCHAR(50),
    policy_holder VARCHAR(100),
    policy_amount DECIMAL(10,2),
    status VARCHAR(20)
);
