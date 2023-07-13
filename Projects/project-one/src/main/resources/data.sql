-- Populate the Warehouse table
INSERT INTO Warehouse (warehouse_id, warehouse_name, maximum_capacity)
VALUES
  (100, 'WarehouseA', 1000),
  (200, 'WarehouseB', 1500),
  (300, 'WarehouseC', 800);

-- Populate the TireBrand table
INSERT INTO TireBrand (brand_id, brand_name)
VALUES
  (100, 'Brand X'),
  (200, 'Brand Y'),
  (300, 'Brand Z');

-- Populate the TireType table
INSERT INTO TireType (tire_type_id, tire_type_name, description, price, brand_id)
VALUES
  (100, 'Tire Type 1', 'Description for Tire Type 1', 100.00, 100),
  (200, 'Tire Type 2', 'Description for Tire Type 2', 120.00, 100),
  (300, 'Tire Type 3', 'Description for Tire Type 3', 95.00, 200),
  (400, 'Tire Type 4', 'Description for Tire Type 4', 110.00, 300);

-- Populate the Inventory table
INSERT INTO Inventory (warehouse_id, tire_type_id, quantity)
VALUES
  (100, 100, 50),
  (100, 200, 75),
  (200, 300, 100),
  (300, 400, 60);
