/*

    used by the h2 database duing application startup
    
    creates our in-memory database tables

*/


/* If the users table already exists, drop it so it can be remade */

drop table if exists Warehouse;
drop table if exists TireType;
drop table if exists TireBrand;
drop table if exists Inventory;

-- Create the Warehouse table
CREATE TABLE WAREHOUSE (
  warehouse_id SERIAL PRIMARY KEY,
  warehouse_name VARCHAR(255),
  maximum_capacity INT
);

-- Create the TireBrand table
CREATE TABLE TIREBRAND (
  brand_id SERIAL PRIMARY KEY,
  brand_name VARCHAR(255)
);

-- Create the TireType table
CREATE TABLE TIRETYPE (
  tire_type_id SERIAL PRIMARY KEY,
  tire_type_name VARCHAR(255),
  description VARCHAR(255),
  price DECIMAL(10, 2),
  brand_id INT REFERENCES TireBrand (brand_id)
);

-- Create the Inventory table
CREATE TABLE INVENTORY (
  warehouse_id INT REFERENCES Warehouse (warehouse_id),
  tire_type_id INT REFERENCES TireType (tire_type_id),
  quantity INT,
  PRIMARY KEY (warehouse_id, tire_type_id)
);