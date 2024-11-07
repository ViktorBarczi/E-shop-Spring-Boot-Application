
# E-shop Application

A Spring Boot-based backend application for managing an online shopping platform, providing functionalities for product management, shopping carts, and email notifications.

## Features

- **Product Management**: Create, update, and manage products in the store.
- **Shopping Cart**: Manage shopping carts for users, including adding or removing items.
- **Email Service**: Send notifications and confirmations via email.
- **Authentication**: Secure user authentication using JWT tokens.
- **Exception Handling**: Custom exception handling for better API response management.

## Project Structure

- **src/main/java/application**: Main application source code.
  - `product/`: Handles product-related operations, including service and controller logic.
  - `cart/`: Manages shopping cart operations like adding or removing items.
  - `email/`: Provides functionality to send and manage emails.
  - `security/`: Contains configurations for JWT-based authentication and security.
  - `exceptions/`: Custom exception classes for handling specific API error cases.
  - `utils/`: Utility classes for handling various request and response formats.

- **src/main/resources/application.properties**: Configuration file for setting up application properties like database connection and security.

- **pom.xml**: Maven build configuration file.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6+
- Spring Boot

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/E-shop.git
   cd E-shop
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

### Running Tests

Run tests using Maven:
```bash
mvn test
```

## API Endpoints

1. **Product Endpoints**:
   - `POST /products`: Create a new product.
   - `GET /products/{id}`: Retrieve product details by ID.

2. **Shopping Cart Endpoints**:
   - `POST /cart`: Add items to the shopping cart.
   - `DELETE /cart/{id}`: Remove items from the shopping cart.

3. **Email Endpoints**:
   - `POST /email/send`: Send an email to a specified recipient.

4. **Authentication**:
   - `POST /auth/login`: Authenticate users and retrieve a JWT token.

## Configuration

Customize the `application.properties` file to configure the database, email server, security settings, and more.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
