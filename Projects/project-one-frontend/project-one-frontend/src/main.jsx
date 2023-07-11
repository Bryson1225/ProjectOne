import React from 'react'
import ReactDOM from 'react-dom';
import App from './App.jsx'
import WarehouseTable from './components/WarehouseTable';
import TireBrandTable from "./components/TireBrandTable";
import TireTypeTable from "./components/TireTypeTable";
import InventoryTable from "./components/InventoryTable";
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
