# 📋 Quick Form Fill Backend

Quick Form Fill Backend is a simple API developed using Spring Boot, designed to manage CRUD (Create, Read, Update, Delete) operations for products. This backend service provides an easy way to handle product data, facilitating integration with front-end applications.

## 📑 Table of Contents
- [Key Features](#-key-features)
- [Technical Details](#%EF%B8%8F-technical-details)
- [Prerequisites](#-prerequisites)
- [Installation Instructions](#-installation-instructions)
  - [Clone the Repository](#1-clone-the-repository)
  - [Navigate to the Project Directory](#2-navigate-to-the-project-directory)
  - [Run the Application](#3-run-the-application)
    - [For Windows](#for-windows)
    - [For Linux and macOS](#for-windows)
- [Usage Examples](#-usage-examples)
  - [Create a Product](#-create-a-product)
  - [Retrieve a Product by ID](#-retrieve-a-product-by-id)

## 🚀 Key Features
- 🆕 **Create Products:** Add new products with information such as name, price, and description.
- 🔍 **Read Products:** Retrieve a list of all products or get details of a specific product by its ID.
- ✏️ **Update Products:** Modify existing product information to keep your data up-to-date.
- 🗑️ **Delete Products:** Remove products that are no longer needed.

## ⚙️ Technical Details
- 🧑‍💻 **Technology:** Built with Spring Boot, taking advantage of its features for quick and efficient development.
- 🌐 **Architecture:** REST API, ensuring straightforward handling of HTTP requests and responses.

## 🔧 Prerequisites
- Ensure Java 17 or higher is installed
  
  ```bash
  java --version
  ```
## 📝 Installation Instructions
### 1. Clone the Repository
```bash
git clone https://github.com/esperanca-leonardo/quick-form-fill-backend.git
```

### 2. Navigate to the Project Directory
```bash
cd quick-form-fill-backend
```

### 3. Run the Application
Depending on your operating system, follow the commands below to start the application.

- #### For Windows
  
  ```bash
  .\mvnw.cmd spring-boot:run
  ```

- #### For Linux and macOS
  First, give execute permission to the script

  ```bash
  chmod u+x mvnw
  ```

  Then, run the command to start the application

  ```bash
  ./mvnw spring-boot:run
  ```

## 📚 Usage Examples
Below are examples of how to use the Quick Form Fill Backend API endpoints in different scenarios. These examples can help you understand how to interact with the API effectively.

- ### 🆕 Create a Product
  - To create a new product, send a `POST` request to the `/products` endpoint with the product details in the request body. The request body should be in JSON format as shown below
    ```json
      {
        "name": "Wireless Mouse",
        "description": "A high-precision wireless mouse",
        "category": "Electronics",
        "price": 29.99,
        "amount": 150,
        "supplier": "TechSupplier Co.",
        "brand": "TechBrand"
      }
      ```

  - If the product is created successfully, the API will respond with a status code `201 Created` and the details of the newly created product in the response body
      ```json
      {
        "id": 1,
        "name": "Wireless Mouse",
        "description": "A high-precision wireless mouse",
        "category": "Electronics",
        "price": 29.99,
        "amount": 150,
        "supplier": "TechSupplier Co.",
        "brand": "TechBrand"
      }
      ```

- ### 🔍 Retrieve a Product by ID
  - To retrieve details of a specific product by its ID, send a `GET` request to the `/products/{id}` endpoint, replacing `{id}` with the actual product ID.
    If the product with the specified ID exists, the API will respond with a status code `200 OK` and the details of the product in the response body

    ```json
    {
      "id": 1,
      "name": "Wireless Mouse",
      "description": "A high-precision wireless mouse",
      "category": "Electronics",
      "price": 29.99,
      "amount": 150,
      "supplier": "TechSupplier Co.",
      "brand": "TechBrand"
    }
    ```

  - If the product with the specified ID, in this case `2`, is not found, the API will respond with a status code `404 Not Found` and an error message in the response body

    ```json
    {
      "status": 404,
      "timestamp": "2024-05-17T23:00:03-03:00",
      "type": "https://hopefood.com.br/product-not-found",
      "title": "Product not found",
      "detail": "Product not found with ID: 2"
    }
    ```
- ### 📄 Retrieve All Products
  - To retrieve a list of all products, send a `GET` request to the `/products` endpoint.
  If the request is successful, the API will respond with a status code `200 OK` and an array of product details in the response body. For example

    ```json
    [
      {
        "id": 1,
        "name": "Wireless Mouse",
        "description": "A high-precision wireless mouse",
        "category": "Electronics",
        "price": 29.99,
        "amount": 150,
        "supplier": "TechSupplier Co.",
        "brand": "TechBrand"
      }
    ]
    ```
      
