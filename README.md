# 🌐 DevPing - Developer Connect Platform (IN PROGRESS)

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-18.2.0-blue.svg)](https://reactjs.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-orange.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A modern full-stack platform that connects developers for project collaboration, task management, and professional networking. Built with Spring Boot backend and React frontend.

## Features

- 🔐 **Secure Authentication**: JWT-based authentication with Spring Security
- 👥 **User Management**: Complete user profiles with skills and social links
- 📊 **Project Management**: Create, manage, and collaborate on projects
- ✅ **Task Management**: Assign and track tasks with different priorities
- 🛡️ **Role-based Access Control**: Differentiate between contributors and project owners
- 🔍 **RESTful APIs**: Well-structured REST endpoints for all operations

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.1.5
- **Security**: Spring Security + JWT
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Documentation**: Postman (for API testing)

## Project Structure

```
src/
├── main/
│   ├── java/com/devping/
│   │   ├── config/          # Security and application configuration
│   │   ├── controller/      # REST API controllers
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── model/          # JPA entities
│   │   ├── repository/     # Data access layer
│   │   ├── security/       # JWT and security components
│   │   └── service/        # Business logic layer
│   └── resources/
│       └── application.properties
└── test/
```

## Database Schema

### Users Table
- User profiles with authentication
- Skills and social media links
- Role-based access (USER, ADMIN)

### Projects Table
- Project information and repository links
- Owner and contributor relationships
- Project status tracking

### Tasks Table
- Task assignment and tracking
- Priority levels and due dates
- Status management (TODO, IN_PROGRESS, DONE)

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

### Database Setup
1. Create a MySQL database:
```sql
CREATE DATABASE devping_db;
```

2. Update database credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/devping_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Install dependencies:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/signup` - User registration
- `POST /api/auth/signin` - User login

### Users
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user profile
- `DELETE /api/users/{id}` - Delete user

### Projects
- `GET /api/projects` - Get all projects
- `POST /api/projects` - Create new project
- `GET /api/projects/{id}` - Get project by ID
- `PUT /api/projects/{id}` - Update project
- `DELETE /api/projects/{id}` - Delete project
- `POST /api/projects/{id}/join` - Join project as contributor

### Tasks
- `GET /api/tasks` - Get all tasks
- `POST /api/tasks` - Create new task
- `GET /api/tasks/{id}` - Get task by ID
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task
- `GET /api/projects/{projectId}/tasks` - Get tasks for project

## Security

The application uses JWT (JSON Web Tokens) for authentication:
- Tokens expire after 24 hours
- Role-based access control with USER and ADMIN roles
- Password encryption using BCrypt
- CORS configured for frontend integration

## Testing with Postman

1. **Register a new user**:
   - POST `http://localhost:8080/api/auth/signup`
   - Body: JSON with username, email, password, etc.

2. **Login**:
   - POST `http://localhost:8080/api/auth/signin`
   - Body: JSON with username and password
   - Copy the JWT token from response

3. **Access protected endpoints**:
   - Add Authorization header: `Bearer <your-jwt-token>`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License.
