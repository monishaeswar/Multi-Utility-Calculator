-- Multi-Utility Calculator Database Schema
CREATE DATABASE IF NOT EXISTS calculator_db;
USE calculator_db;

DROP TABLE IF EXISTS calculation_history;

CREATE TABLE calculation_history (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    calculator_type VARCHAR(50)   NOT NULL,       -- BASIC, BMI, AGE, EMI, GST, PERCENTAGE, DISCOUNT
    input_data      VARCHAR(500)  NOT NULL,       -- JSON string of the inputs
    result_data     VARCHAR(500)  NOT NULL,       -- JSON string of the outputs
    created_at      TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_calculator_type (calculator_type),
    INDEX idx_created_at (created_at)
);
