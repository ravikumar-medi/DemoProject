# My Spring Boot App

A world-class, secure Spring Boot application with comprehensive user management, authentication, and REST APIs.

## Features

### User Management
- **Complete User Profile**: Email, First Name, Last Name, Phone, Address, City, State, Country, Postal Code
- **Input Validation**: Comprehensive validation for all user fields
- **Audit Timestamps**: Auto-managed creation and update timestamps
- **Account Status**: Active/Inactive user status tracking

### Security
- Spring Security with BCrypt password encoding
- Form-based authentication with role support
- CSRF protection
- Secure password storage with encryption

### REST APIs
All APIs return standardized responses with proper HTTP status codes and error messages.

#### User Registration API
```
POST /api/users/register
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePassword123",
  "firstName": "John",
  "lastName": "Doe",
  "phone": "9876543210",
  "address": "123 Main St",
  "city": "New York",
  "state": "NY",
  "country": "USA",
  "postalCode": "10001"
}

Response (201 Created):
{
  "success": true,
  "message": "User registered successfully",
  "data": { user details },
  "timestamp": "2026-04-09T10:30:00"
}
```

#### User Login API
```
POST /api/users/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePassword123"
}

Response (200 OK):
{
  "success": true,
  "message": "Login successful",
  "data": { user details },
  "timestamp": "2026-04-09T10:30:00"
}
```

#### Get User API
```
GET /api/users/{userId}

Response (200 OK):
{
  "success": true,
  "message": "User retrieved successfully",
  "data": { user details },
  "timestamp": "2026-04-09T10:30:00"
}
```

### Web UI
- Login page
- Registration page with full form
- Secure home page for logged-in users

## Prerequisites

- Java 17
- Maven 3.8.9+
- MySQL server running locally

## Database Setup

Create a MySQL database:
```sql
CREATE DATABASE demoDB;
```

## Configuration

Database and Hibernate settings are configured in `src/main/resources/application.properties`.

**Default Demo User:**
- Email: ravikumar.medi@empover.com
- Password: Ravi@J

## Running the Application

1. Set JAVA_HOME to JDK 17:
   ```powershell
   $env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the app at: http://localhost:8080

## API Testing

Use Postman or curl to test the APIs:

```bash
# Register a new user
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "Password123",
    "firstName": "Test",
    "lastName": "User",
    "phone": "9876543210"
  }'

# Login user
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "Password123"
  }'

# Get user details
curl -X GET http://localhost:8080/api/users/1
```

## Project Structure

- `User.java` - User entity with comprehensive fields
- `UserRepository.java` - JPA repository for user operations
- `UserService.java` - Business logic for user management
- `UserController.java` - REST API endpoints with validation and error handling
- `AuthController.java` - Web pages for login and registration
- `SecurityConfig.java` - Spring Security configuration
- `ApiResponse.java` - Standardized API response wrapper
- `UserResponse.java` - User data transfer object for API responses

## Technology Stack

- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- MySQL 8.0
- Hibernate ORM
- Jakarta Validation
- Thymeleaf (for web UI)

## Best Practices Implemented

- ✓ Input validation with proper error messages
- ✓ Standardized API responses
- ✓ Proper HTTP status codes
- ✓ Password encryption with BCrypt
- ✓ Comprehensive user profile management
- ✓ Audit timestamps for data tracking
- ✓ Exception handling with meaningful error messages
- ✓ RESTful API design
- ✓ Separation of concerns (Service, Repository, Controller layers)
- ✓ Database schema with proper constraints
>>>>>>> e785925 (Initial Spring Boot project with user auth and GitHub-ready setup)
