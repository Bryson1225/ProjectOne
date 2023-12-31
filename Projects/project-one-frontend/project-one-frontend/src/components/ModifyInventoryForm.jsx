import React, { useState, useEffect } from "react";
import axios from "axios";

/**
 * 
 * Class: ModifyInventoryForm.jsx
 *  -> Function: Used to change the current inventory in the database. This is where
 *      the user will basically remove items or quantities.
 */

const ModifyInventoryForm = ({ onInventoryModified }) => {
  const [warehouses, setWarehouses] = useState([]);
  const [brands, setBrands] = useState([]);
  const [types, setTypes] = useState([]);
  const [selectedWarehouseId, setSelectedWarehouseId] = useState("");
  const [selectedBrandId, setSelectedBrandId] = useState("");
  const [selectedTypeId, setSelectedTypeId] = useState("");
  const [selectedQuantity, setSelectedQuantity] = useState(0);

  useEffect(() => {
    fetchWarehouses();
  }, []);

  // Get the warehouse options
  const fetchWarehouses = async () => {
    try {
      const response = await axios.get("http://localhost:8080/warehouses");
      setWarehouses(response.data);
    } catch (error) {
      console.error("Error fetching warehouses:", error);
    }
  };

  // Get the tire brand options
  const fetchBrands = async (warehouseId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/tire-brands`
      );
      setBrands(response.data);
    } catch (error) {
      console.error("Error fetching brands:", error);
    }
  };

  // Get the associated types for the brand
  const fetchTypesByBrand = async (brandId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/tire-types/tire-brand/${brandId}`
      );
      setTypes(response.data);
    } catch (error) {
      console.error("Error fetching types:", error);
    }
  };

  // Changing warehouse means we need a new selection of options
  const handleWarehouseChange = (event) => {
    const selectedWarehouseId = event.target.value;
    setSelectedWarehouseId(selectedWarehouseId);
    setSelectedBrandId("");
    setSelectedTypeId("");
    setBrands([]);
    setTypes([]);
    fetchBrands(selectedWarehouseId);
  };

  // New brand, new options
  const handleBrandChange = (event) => {
    const selectedBrandId = event.target.value;
    setSelectedBrandId(selectedBrandId);
    setSelectedTypeId("");
    setTypes([]);
    fetchTypesByBrand(selectedBrandId);
  };

  // New type change
  const handleTypeChange = (event) => {
    setSelectedTypeId(event.target.value);
  };

  // Setting the quantity
  const handleQuantityChange = (event) => {
    setSelectedQuantity(event.target.value);
  };

  // Submitting the form
  const handleDeleteItemFormSubmit = async (event) => {
    event.preventDefault();

    try {
      await axios.put(
        `http://localhost:8080/inventory/${selectedWarehouseId}/${selectedTypeId}?quantity=${selectedQuantity}`
      );

      setSelectedWarehouseId("");
      setSelectedBrandId("");
      setSelectedTypeId("");
      setSelectedQuantity(0);

      if (onInventoryModified) {
        onInventoryModified();
      }
    } catch (error) {
      console.error("Error deleting item from inventory:", error);
    }
  };

  return (
    <div>
      <h3>Delete Inventory</h3>
      <form onSubmit={handleDeleteItemFormSubmit}>
        <div>
          <label htmlFor="warehouseSelect">Warehouse:</label>
          <select
            id="warehouseSelect"
            value={selectedWarehouseId}
            onChange={handleWarehouseChange}
          >
            <option value="">Select Warehouse</option>
            {warehouses.map((warehouse) => (
              <option key={warehouse.warehouseId} value={warehouse.warehouseId}>
                {warehouse.warehouseName}
              </option>
            ))}
          </select>
        </div>
        {selectedWarehouseId && (
          <div>
            <label htmlFor="brandSelect">Brand:</label>
            <select
              id="brandSelect"
              value={selectedBrandId}
              onChange={handleBrandChange}
            >
              <option value="">Select Brand</option>
              {brands.map((brand) => (
                <option key={brand.brandId} value={brand.brandId}>
                  {brand.brandName}
                </option>
              ))}
            </select>
          </div>
        )}
        {selectedBrandId && (
          <div>
            <label htmlFor="typeSelect">Type:</label>
            <select
              id="typeSelect"
              value={selectedTypeId}
              onChange={handleTypeChange}
            >
              <option value="">Select Type</option>
              {types.map((type) => (
                <option key={type.tireTypeId} value={type.tireTypeId}>
                  {type.tireTypeName}
                </option>
              ))}
            </select>
          </div>
        )}
        {selectedTypeId && (
          <div>
            <label htmlFor="quantityInput">Quantity:</label>
            <input
              id="quantityInput"
              type="number"
              value={selectedQuantity}
              onChange={handleQuantityChange}
            />
          </div>
        )}
        <button type="submit">Delete Inventory</button>
      </form>
    </div>
  );
};

export default ModifyInventoryForm;
