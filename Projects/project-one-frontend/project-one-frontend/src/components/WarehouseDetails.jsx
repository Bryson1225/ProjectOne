// WarehouseDetails.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";

/**
 * Class: WarehouseDetails.jsx
 *  -> Function: When you expand a warehouse card, this is the file that gets the extra
 *      details. That warehouses inventory, and quantity.
 */

const WarehouseDetails = ({ warehouse }) => {
  const [inventory, setInventory] = useState([]);
  const [inventoryCount, setInventoryCount] = useState(0);

  useEffect(() => {
    fetchInventory();
    fetchInventoryCount();
  }, [warehouse]); // Fetch inventory when the warehouse prop changes

  // Get that warehouses inventory
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

  // Get the current fill level of that warehouse
  const fetchInventoryCount = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/warehouses/${warehouse.warehouseId}/inventory-count`
      );
      const count = response.data;
      setInventoryCount(count);
    } catch (error) {
      console.error("Error fetching inventory count:", error);
    }
  };

  return (
    <div className="warehouse-details">
      <h2>{warehouse.warehouseName} Inventory</h2>
      <p>Inventory Count: {inventoryCount}</p>
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
