// WarehouseDetails.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";

const WarehouseDetails = ({ warehouse }) => {
  const [inventory, setInventory] = useState([]);

  useEffect(() => {
    fetchInventory();
  }, [warehouse]); // Fetch inventory when the warehouse prop changes

  const fetchInventory = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/inventory/warehouse/${warehouse.warehouseId}`
      );
      setInventory(response.data);
    } catch (error) {
      console.error("Error fetching inventory:", error);
    }
  };

  return (
    <div className="warehouse-details">
      <h2>{warehouse.warehouseName} Inventory</h2>
      {inventory.length > 0 ? (
        <table>
        <thead>
          <tr>
            <th>Tire Brand</th>
            <th>Tire Type</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          {inventory.map((item) => (
            <tr key={item.tireType.tireTypeId}>
              <td>{item.tireType.tireBrand.brandName}</td>
              <td>{item.tireType.tireTypeName}</td>
              <td>{item.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
    ) : (
      <p>No inventory available.</p>
      )}
    </div>
  );
};

export default WarehouseDetails;
