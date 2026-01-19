-- Пример скрипта создания таблиц для базы данных wam

-- Таблица пользователей
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица вендинговых аппаратов
CREATE TABLE IF NOT EXISTS vending_machines (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(255),
    status VARCHAR(20) DEFAULT 'ACTIVE',
    owner_id INTEGER REFERENCES users(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица товаров
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица продаж
CREATE TABLE IF NOT EXISTS sales (
    id SERIAL PRIMARY KEY,
    vending_machine_id INTEGER REFERENCES vending_machines(id),
    product_id INTEGER REFERENCES products(id),
    quantity INTEGER NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    sale_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица обслуживания
CREATE TABLE IF NOT EXISTS maintenance_logs (
    id SERIAL PRIMARY KEY,
    vending_machine_id INTEGER REFERENCES vending_machines(id),
    engineer_id INTEGER REFERENCES users(id),
    issue_description TEXT,
    resolution_notes TEXT,
    scheduled_date TIMESTAMP,
    completed_date TIMESTAMP,
    status VARCHAR(20) DEFAULT 'PENDING'
);