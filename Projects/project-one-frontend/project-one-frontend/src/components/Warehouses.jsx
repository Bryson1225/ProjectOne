// Warehouses.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";
import WarehouseCard from "./WarehouseCard";
import WarehouseDetails from "./WarehouseDetails";
import TopBar from "./TopBar";
import InventoryView from "./InventoryView";
import AddInventoryForm from "./AddInventoryForm";
import AddWarehouseForm from "./AddWarehouseForm";
import AddTireTypeForm from "./AddTireTypeForm";
import AddTireBrandForm from "./AddTireBrandForm";
import ModifyInventoryForm from "./ModifyInventoryForm";
import "../App.css";

const Warehouses = () => {
  const [warehouses, setWarehouses] = useState([]);
  const [expandedWarehouse, setExpandedWarehouse] = useState(null);
  const [showInventoryTable, setShowInventoryTable] = useState(true);
  const [showAddItemsForm, setShowAddItemsForm] = useState(false);
  const [showAddWarehouseForm, setShowAddWarehouseForm] = useState(false);
  const [showAddTireTypeForm, setShowAddTireTypeForm] = useState(false);
  const [showAddTireBrandForm, setShowAddTireBrandForm] = useState(false);
  const [showModifyInventoryForm, setModifyInventoryForm] = useState(false);


  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/warehouses");
      setWarehouses(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleExpandWarehouse = (warehouse) => {
    if (expandedWarehouse && expandedWarehouse.warehouseId === warehouse.warehouseId) {
      setExpandedWarehouse(null);
    } else {
      setExpandedWarehouse(warehouse);
      setShowInventoryTable(false);
      setShowAddItemsForm(false);
      setShowAddWarehouseForm(false);
      setShowAddTireTypeForm(false);
      setShowAddTireBrandForm(false);
      setModifyInventoryForm(false);
    }
  };

  const handleInventoryButtonClick = () =>{
    setShowInventoryTable(!showInventoryTable);
    setExpandedWarehouse(null);
    setShowAddItemsForm(false);
    setShowAddTireTypeForm(false);
    setShowAddWarehouseForm(false);
    setShowAddTireBrandForm(false);
    setModifyInventoryForm(false);
  }

  const handleAddItemsButtonClick = () => {
    setShowAddWarehouseForm(false);
    setExpandedWarehouse(null);
    setShowInventoryTable(true);
    setShowAddTireTypeForm(false);
    setShowAddTireBrandForm(false);
    setModifyInventoryForm(false);
    setShowAddItemsForm(!showAddItemsForm);
  }

  const handleAddWarehouseButtonClick = () => {
    setExpandedWarehouse(null);
    setShowInventoryTable(false);
    setShowAddItemsForm(false);
    setShowAddTireTypeForm(false);
    setShowAddTireBrandForm(false);
    setModifyInventoryForm(false);
    setShowAddWarehouseForm(!showAddWarehouseForm);
  }

  const handleAddTireTypeButtonClick = () => {
    setExpandedWarehouse(null);
    setShowInventoryTable(false);
    setShowAddItemsForm(false);
    setShowAddWarehouseForm(false);
    setShowAddTireBrandForm(false);
    setModifyInventoryForm(false);
    setShowAddTireTypeForm(!showAddTireTypeForm);
  };

  const handleAddTireBrandButtonClick = () => {
    setExpandedWarehouse(null);
    setShowInventoryTable(false);
    setShowAddItemsForm(false);
    setShowAddWarehouseForm(false);
    setShowAddTireTypeForm(false);
    setModifyInventoryForm(false);
    setShowAddTireBrandForm(!showAddTireBrandForm);
  };

  const handleModifyInventoryButtonClick = () => {
    setExpandedWarehouse(null);
    setShowInventoryTable(true);
    setShowAddItemsForm(false);
    setShowAddWarehouseForm(false);
    setShowAddTireTypeForm(false);
    setShowAddTireBrandForm(false);
    setModifyInventoryForm(!showModifyInventoryForm);
  };

  const handleTireTypeAdded = async () => {
    await fetchData(); // Refresh data after tire type addition
  };

  const handleInventoryModified = async () => {
    await fetchData(); // Refresh data after inventory modification
  };

  const handleWarehouseAdded = async () => {
    await fetchData(); // Refresh data after warehouse addition
  };
  const handleInventoryAdded = async () => {
    await fetchData() // Refresh data after warehouse addition
  };
  const handleTireBrandAdded = async () => {
    await fetchData(); // Refresh data after tire brand addition
  };

  const handleWarehouseDelete = async (deletedWarehouseId) => {
    try {
      await axios.delete(`http://localhost:8080/warehouses/warehouse/${deletedWarehouseId}`);
      setWarehouses(warehouses.filter((warehouse) => warehouse.warehouseId !== deletedWarehouseId));
    } catch (error) {
      console.error("Error deleting warehouse:", error);
    }
  };

  return (
    <div>
        <div>
            <TopBar
                onInventoryButtonClick={handleInventoryButtonClick}
                onAddItemsButtonClick={handleAddItemsButtonClick}
                onAddWarehouseButtonClick={handleAddWarehouseButtonClick}
                onAddTireTypeButtonClick={handleAddTireTypeButtonClick}
                onAddTireBrandButtonClick={handleAddTireBrandButtonClick}
                onModifyInventoryButtonClick={handleModifyInventoryButtonClick}
            />
        </div>

        <div className="app-container">
            <div className="warehouse-container">
                <div className="warehouse-cards">
                    {warehouses.map((warehouse) => (
                    <WarehouseCard
                        key={warehouse.warehouseId}
                        warehouse={warehouse}
                        expanded={expandedWarehouse && expandedWarehouse.warehouseId === warehouse.warehouseId}
                        onExpand={handleExpandWarehouse}
                        onDelete={handleWarehouseDelete}
                    />
                    ))}
                </div>
            </div>
        </div>
        <div className="table-container">
              {showInventoryTable && <InventoryView onInventoryAdded={handleInventoryAdded}/>}
              {showAddItemsForm && <AddInventoryForm onInventoryAdded={handleInventoryAdded}/>}
              {showAddWarehouseForm && <AddWarehouseForm onWarehouseAdded={handleWarehouseAdded}/>}
              {showAddTireTypeForm && <AddTireTypeForm onTireTypeAdded={handleTireTypeAdded} />}
              {showAddTireBrandForm && <AddTireBrandForm onTireBrandAdded={handleTireBrandAdded} />}
              {showModifyInventoryForm && <ModifyInventoryForm onInventoryModified={handleInventoryModified} />}
              {expandedWarehouse && (
                  <div className="warehouse-details">
                  <WarehouseDetails warehouse={expandedWarehouse} />
                  </div>
              )}
            </div>
    </div>
  );
};

export default Warehouses;

