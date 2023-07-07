-- Populate the Warehouse table
INSERT INTO Warehouse (warehouse_id, warehouse_name, maximum_capacity)
VALUES
  (1, 'WarehouseA', 1000),
  (2, 'WarehouseB', 1500),
  (3, 'WarehouseC', 800);

-- Populate the TireBrand table
INSERT INTO TireBrand (brand_id, brand_name)
VALUES
  (1, 'Brand X'),
  (2, 'Brand Y'),
  (3, 'Brand Z');

-- Populate the TireType table
INSERT INTO TireType (tire_type_id, tire_type_name, description, price, brand_id)
VALUES
  (1, 'Tire Type 1', 'Description for Tire Type 1', 100.00, 1),
  (2, 'Tire Type 2', 'Description for Tire Type 2', 120.00, 1),
  (3, 'Tire Type 3', 'Description for Tire Type 3', 95.00, 2),
  (4, 'Tire Type 4', 'Description for Tire Type 4', 110.00, 3);

-- Populate the Inventory table
INSERT INTO Inventory (warehouse_id, tire_type_id, quantity)
VALUES
  (1, 1, 50),
  (1, 2, 75),
  (2, 3, 100),
  (3, 4, 60);
