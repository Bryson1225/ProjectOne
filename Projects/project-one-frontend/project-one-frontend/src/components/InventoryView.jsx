// InventoryView.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";

const InventoryView = ({ onInventoryAdded }) => {
  const [inventory, setInventory] = useState([]);

  useEffect(() => {
    fetchInventory();
  }, [onInventoryAdded]);

  const fetchInventory = async () => {
    try {
      const response = await axios.get("http://localhost:8080/inventory");
      setInventory(response.data);
    } catch (error) {
      console.error("Error fetching inventory:", error);
    }
  };

  return (
    <div className="warehouse-details">
      <h2>Inventory Table</h2>
      {inventory.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>[Brand]Tire Type</th>
              <th>Warehouse Location</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {inventory.map((item) => (
              <tr key={item.inventoryId}>
                <td>{"[" + item.tireType.tireBrand.brandName + "] " + item.tireType.tireTypeName}</td>
                <td>{item.warehouse.warehouseName}</td>
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

export default InventoryView;
