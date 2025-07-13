-- DevPing Database Setup for XAMPP
-- Run this script in phpMyAdmin (http://localhost/phpmyadmin)

-- Create database
CREATE DATABASE IF NOT EXISTS devping_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Use the database
USE devping_db;

-- Note: Tables will be automatically created by Hibernate when you run the Spring Boot application
-- The following are the expected tables that will be created:

-- Tables that will be auto-created by Hibernate:
-- 1. users
-- 2. projects  
-- 3. tasks
-- 4. project_contributors

-- You can verify the tables are created by:
-- 1. Starting your Spring Boot application in IntelliJ
-- 2. Refreshing this database in phpMyAdmin
-- 3. You should see the tables appear automatically

-- Optional: Create a test user (you can do this after running the app)
-- INSERT INTO users (username, email, password, first_name, last_name, role, created_at, updated_at) 
-- VALUES ('admin', 'admin@devping.com', '$2a$10$encrypted_password_here', 'Admin', 'User', 'ADMIN', NOW(), NOW());

SELECT 'DevPing database setup complete! Start your Spring Boot application to create tables.' as message;
