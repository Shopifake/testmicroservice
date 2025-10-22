-- Flyway migration: Initial schema
-- Version: V1__Initial_schema.sql

-- Example table - remove or modify as needed
CREATE TABLE example_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
