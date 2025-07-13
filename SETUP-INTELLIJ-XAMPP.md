# DevPing Setup Guide - IntelliJ IDEA Ultimate + XAMPP

This guide will help you set up the DevPing project using IntelliJ IDEA Ultimate and XAMPP.

## Prerequisites

- ✅ IntelliJ IDEA Ultimate (already installed)
- ✅ XAMPP (already installed)
- ☑️ Java 17 or higher
- ☑️ Node.js 16.x or higher (for frontend)

## Step 1: Start XAMPP Services

1. **Open XAMPP Control Panel**
2. **Start Apache** (for phpMyAdmin)
3. **Start MySQL** (for database)

## Step 2: Create Database in XAMPP

1. **Open phpMyAdmin** in your browser: `http://localhost/phpmyadmin`
2. **Create a new database** called `devping_db`
3. **Import the database schema** using our SQL file

### Quick Database Setup:

```sql
-- Run this in phpMyAdmin SQL tab
CREATE DATABASE IF NOT EXISTS devping_db;
USE devping_db;

-- Tables will be auto-created by Hibernate when you run the app
```

## Step 3: Configure Database Connection for XAMPP

The application is already configured for XAMPP's default MySQL settings:

- **Host**: localhost
- **Port**: 3306
- **Database**: devping_db
- **Username**: root
- **Password**: (empty by default in XAMPP)

## Step 4: Open Project in IntelliJ IDEA Ultimate

### Method 1: Import Existing Project
1. **Open IntelliJ IDEA Ultimate**
2. **File → Open** or **Open Project**
3. **Navigate to**: `C:\Users\User\DevPing`
4. **Select the folder** and click **OK**
5. **IntelliJ will detect** it as a Maven project automatically

### Method 2: Import from Version Control (if using Git)
1. **File → New → Project from Version Control**
2. **Enter your repository URL**
3. **Clone and import**

## Step 5: IntelliJ Configuration

### 5.1 Project SDK Configuration
1. **File → Project Structure** (Ctrl+Alt+Shift+S)
2. **Project Settings → Project**
3. **Set Project SDK** to Java 17 (or your installed version)
4. **Set Project Language Level** to 17

### 5.2 Maven Configuration
1. **File → Settings** (Ctrl+Alt+S)
2. **Build, Execution, Deployment → Build Tools → Maven**
3. **Maven home directory**: IntelliJ's bundled Maven (recommended)
4. **User settings file**: Use default
5. **Local repository**: Use default

### 5.3 Database Configuration in IntelliJ
1. **View → Tool Windows → Database**
2. **Click + → Data Source → MySQL**
3. **Configure connection**:
   - **Host**: localhost
   - **Port**: 3306
   - **Database**: devping_db
   - **User**: root
   - **Password**: (leave empty)
4. **Test Connection** and **Apply**

## Step 6: Update Application Properties for XAMPP

The project is already configured for XAMPP, but let's verify:

```properties
# Database Configuration (already set for XAMPP)
spring.datasource.url=jdbc:mysql://localhost:3306/devping_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Step 7: Run the Application

### Using IntelliJ Run Configuration:

1. **Right-click** on `DevPingApplication.java`
2. **Run 'DevPingApplication'**
3. **Or create a run configuration**:
   - **Run → Edit Configurations**
   - **+ → Application**
   - **Name**: DevPing Application
   - **Main class**: `com.devping.DevPingApplication`
   - **Module**: DevPing

### Using IntelliJ Maven Tool:

1. **View → Tool Windows → Maven**
2. **DevPing → Lifecycle → spring-boot:run**
3. **Double-click** to run

## Step 8: Verify Setup

1. **Check console output** for successful startup
2. **Open browser** to `http://localhost:8080`
3. **Check database** - tables should be auto-created
4. **Test API endpoints** using Postman

## Step 9: Frontend Setup (Optional)

If you want to run the frontend as well:

1. **Open new terminal** in IntelliJ (Alt+F12)
2. **Navigate to frontend**:
   ```bash
   cd ..\devping-frontend
   npm install
   npm start
   ```
3. **Frontend will run** on `http://localhost:3000`

## IntelliJ IDEA Ultimate Features to Use

### 1. Database Tools
- **Built-in database client** for MySQL
- **Query console** for running SQL
- **Database schema visualization**

### 2. Spring Boot Support
- **Spring Boot run configurations**
- **Application properties autocomplete**
- **Bean dependency visualization**

### 3. Maven Integration
- **Maven tool window** for lifecycle management
- **Dependency management**
- **Automatic dependency download**

### 4. Code Features
- **Spring framework support**
- **JPA/Hibernate integration**
- **REST API development tools**
- **Code completion and refactoring**

## Troubleshooting

### Common Issues:

1. **MySQL Connection Failed**
   - ✅ Check XAMPP MySQL service is running
   - ✅ Verify database name: `devping_db`
   - ✅ Ensure port 3306 is not blocked

2. **Maven Dependencies Not Downloading**
   - ✅ Check internet connection
   - ✅ File → Invalidate Caches and Restart
   - ✅ Reload Maven project (Maven tool window → Reload)

3. **Application Won't Start**
   - ✅ Check Java version (should be 17+)
   - ✅ Verify application.properties
   - ✅ Check console for specific error messages

4. **Port Already in Use**
   - ✅ Stop any other applications using port 8080
   - ✅ Or change port in application.properties: `server.port=8081`

## Development Workflow

1. **Start XAMPP** (Apache + MySQL)
2. **Open IntelliJ IDEA Ultimate**
3. **Open DevPing project**
4. **Run the application**
5. **Use Postman** to test APIs
6. **Check phpMyAdmin** for database changes
7. **Use IntelliJ's built-in tools** for debugging

## Next Steps

1. **Import Postman collection** from `DevPing.postman_collection.json`
2. **Test user registration** and login
3. **Create sample projects** and tasks
4. **Explore IntelliJ's Spring Boot features**

## Useful IntelliJ Shortcuts

- **Ctrl+Shift+F10**: Run current file
- **Ctrl+F9**: Build project
- **Ctrl+Shift+F9**: Compile current file
- **Alt+F12**: Open terminal
- **Ctrl+Alt+S**: Settings
- **Ctrl+Alt+Shift+S**: Project Structure

## Resources

- **IntelliJ IDEA Ultimate**: [Spring Boot Guide](https://www.jetbrains.com/help/idea/spring-boot.html)
- **XAMPP**: [Official Documentation](https://www.apachefriends.org/docs/)
- **Spring Boot**: [Official Documentation](https://spring.io/projects/spring-boot)
