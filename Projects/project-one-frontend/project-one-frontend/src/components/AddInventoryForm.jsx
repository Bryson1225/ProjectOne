import React, { useEffect, useState } from "react";
import axios from "axios";

const AddInventoryForm = ({ onInventoryAdded }) => {
    const [warehouses, setWarehouses] = useState([]);
    const [brands, setBrands] = useState([]);
    const [types, setTypes] = useState([]);
    const [selectedWarehouseId, setSelectedWarehouseId] = useState("");
    const [selectedBrandId, setSelectedBrandId] = useState("");
    const [selectedTypeId, setSelectedTypeId] = useState("");
    const [selectedQuantity, setQuantity] = useState(0);

  useEffect(() => {
    fetchWarehouses();
  }, []);

  const fetchWarehouses = async() => {
    try {
      const response = await axios.get("http://localhost:8080/warehouses");
      setWarehouses(response.data);
    } catch (error) {
      console.error("Error fetching warehouses:", error);
    }
  };

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

  const handleWarehouseChange = (event) => {
    const selectedWarehouseId = event.target.value;
    setSelectedWarehouseId(selectedWarehouseId);
    setSelectedBrandId("");
    setSelectedTypeId("");
    setBrands([]);
    setTypes([]);
    fetchBrands(selectedWarehouseId);
  };

  const handleBrandChange = (event) => {
    const selectedBrandId = event.target.value;
    setSelectedBrandId(selectedBrandId);
    setSelectedTypeId("");
    setTypes([]);
    fetchTypesByBrand(selectedBrandId);
  };

  const handleTypeChange = (event) => {
    setSelectedTypeId(event.target.value);
  };

  const handleQuantityChange = (event) => {
    setQuantity(event.target.value);
  };

  const handleAddItemFormSubmit = async (event) => {
    event.preventDefault();

    // Retrieve the selected warehouse, tire brand, tire type, and quantity from the form state

    // Create an object with the selected values
    const newItem = {
        quantity: selectedQuantity,
    };

    try {
      const newItem =  {
        id: {
          "warehouseId": selectedWarehouseId,
          "tireTypeId": selectedTypeId
        },
        "quantity": selectedQuantity
      };
        await axios.post(
            `http://localhost:8080/inventory/create-inventory/${selectedWarehouseId}/${selectedTypeId}`, newItem
          );
    
        // Clear the form state or perform any other necessary actions
        setSelectedWarehouseId("");
        setSelectedBrandId("");
        setSelectedTypeId("");
        setQuantity(0);
        if (onInventoryAdded) {
          onInventoryAdded();
        }
      } catch (error) {
        console.error("Error adding item to inventory:", error);
      }
  };

  return (
    <div>
      <h3>Add Inventory</h3>
      <form onSubmit={handleAddItemFormSubmit}>
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
        <button type="submit">Add Inventory</button>
      </form>
    </div>
  );
};

export default AddInventoryForm;