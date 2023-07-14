import React, { useState } from "react";
import axios from "axios";

const AddWarehouseForm = ({ onWarehouseAdded }) => {
  const [warehouseName, setWarehouseName] = useState("");
  const [maximumCapacity, setMaximumCapacity] = useState("");

  const handleFormSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/warehouses/create-warehouse", {
        warehouseName,
        maximumCapacity: parseInt(maximumCapacity),
      });

      // Clear the form
      setWarehouseName("");
      setMaximumCapacity("");

    } catch (error) {
      console.error("Error adding warehouse:", error);
    }
    if (onWarehouseAdded) {
        onWarehouseAdded();
    }

  };

  return (
    <div className="add-warehouse-form">
      <h2>Add New Warehouse</h2>
      <form onSubmit={handleFormSubmit}>
        <div className="form-group">
          <label htmlFor="warehouseName">Warehouse Name:</label>
          <input
            type="text"
            id="warehouseName"
            value={warehouseName}
            onChange={(e) => setWarehouseName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="maximumCapacity">Maximum Capacity:</label>
          <input
            type="number"
            id="maximumCapacity"
            value={maximumCapacity}
            onChange={(e) => setMaximumCapacity(e.target.value)}
            required
          />
        </div>
        <button type="submit">Add Warehouse</button>
      </form>
    </div>
  );
};

export default AddWarehouseForm;
