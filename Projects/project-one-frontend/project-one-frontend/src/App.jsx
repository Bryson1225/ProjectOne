import React, { useEffect, useState } from "react";
import axios from "axios";
import WarehouseTable from "./components/WarehouseTable";
import TireBrandTable from "./components/TireBrandTable";
import TireTypeTable from "./components/TireTypeTable";
import InventoryTable from "./components/InventoryTable";

const App = () => {
  const [warehouses, setWarehouses] = useState([]);
  const [tireBrands, setTireBrands] = useState([]);
  const [tireTypes, setTireTypes] = useState([]);
  const [inventory, setInventory] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const warehouseResponse = await axios.get("http://localhost:5500/warehouses");
      setWarehouses(warehouseResponse.data);

      const tireBrandResponse = await axios.get("http://localhost:5500/tire-brands");
      setTireBrands(tireBrandResponse.data);

      const tireTypeResponse = await axios.get("http://localhost:5500/tire-types");
      setTireTypes(tireTypeResponse.data);

      const inventoryResponse = await axios.get("http://localhost:5500/inventory");
      setInventory(inventoryResponse.data);

    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <div>
      <WarehouseTable warehouses={warehouses} />
      <TireBrandTable tireBrands={tireBrands} />
      <TireTypeTable tireTypes={tireTypes} />
      <InventoryTable inventory={inventory} />
    </div>
  );
};

export default App;

