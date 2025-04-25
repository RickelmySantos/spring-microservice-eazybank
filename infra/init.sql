-- CREATE TABLE IF NOT EXISTS cards (
--   card_id int NOT NULL AUTO_INCREMENT,
--   mobile_number varchar(15) NOT NULL,
--   card_number varchar(100) NOT NULL,
--   card_type varchar(100) NOT NULL,
--   total_limit int NOT NULL,
--   amount_used int NOT NULL,
--   available_amount int NOT NULL,
--   created_at date NOT NULL,
--   created_by varchar(20) NOT NULL,
--   updated_at date DEFAULT NULL,
--   updated_by varchar(20) DEFAULT NULL,
--   PRIMARY KEY (card_id)
-- );

-- CREATE TABLE IF NOT EXISTS loans (
--   loan_id int NOT NULL AUTO_INCREMENT,
--   mobile_number varchar(15) NOT NULL,
--   loan_number varchar(100) NOT NULL,
--   loan_type varchar(100) NOT NULL,
--   total_loan int NOT NULL,
--   amount_paid int NOT NULL,
--   outstanding_amount int NOT NULL,
--   created_at date NOT NULL,
--   created_by varchar(20) NOT NULL,
--   updated_at date DEFAULT NULL,
--   updated_by varchar(20) DEFAULT NULL,
--   PRIMARY KEY (loan_id)
-- );

-- CREATE TABLE IF NOT EXISTS customer (
--   customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--   name VARCHAR(100) NOT NULL,
--   email VARCHAR(100) NOT NULL,
--   mobile_number VARCHAR(100) NOT NULL,
--   created_at date NOT NULL,
--   created_by VARCHAR(20) NOT NULL,
--   updated_at date DEFAULT NULL,
--   updated_by VARCHAR(20) DEFAULT NULL
-- );

-- CREATE TABLE IF NOT EXISTS accounts (
--   customer_id INT NOT NULL,
--   account_number INT AUTO_INCREMENT PRIMARY KEY,
--   account_type VARCHAR(100) NOT NULL,
--   branch_address VARCHAR(200) NOT NULL,
--   created_at date NOT NULL,
--   created_by VARCHAR(20) NOT NULL,
--   updated_at date DEFAULT NULL,
--   updated_by VARCHAR(20) DEFAULT NULL
-- );

CREATE DATABASE loans;
CREATE DATABASE customer;
CREATE DATABASE cards;
CREATE DATABASE accounts;
CREATE DATABASE accounts;

CREATE TABLE IF NOT EXISTS cards (
  card_id SERIAL PRIMARY KEY,
  mobile_number VARCHAR(15) NOT NULL,
  card_number VARCHAR(100) NOT NULL,
  card_type VARCHAR(100) NOT NULL,
  total_limit INT NOT NULL,
  amount_used INT NOT NULL,
  available_amount INT NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS loans (
  loan_id SERIAL PRIMARY KEY,
  mobile_number VARCHAR(15) NOT NULL,
  loan_number VARCHAR(100) NOT NULL,
  loan_type VARCHAR(100) NOT NULL,
  total_loan INT NOT NULL,
  amount_paid INT NOT NULL,
  outstanding_amount INT NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS customer (
  customer_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  mobile_number VARCHAR(100) NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
  customer_id INT NOT NULL,
  account_number SERIAL PRIMARY KEY,
  account_type VARCHAR(100) NOT NULL,
  branch_address VARCHAR(200) NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL
);