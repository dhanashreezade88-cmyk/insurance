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