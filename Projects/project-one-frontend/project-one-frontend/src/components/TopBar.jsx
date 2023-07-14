import React from "react";
import { AppBar, Toolbar, Typography, Button } from "@mui/material";

/**
 * 
 * Class: TopBar.jsx
 *  -> Function: Top navigation bar, holds the buttons to manage the database
 */

const TopBar = ({ onInventoryButtonClick, onAddItemsButtonClick, onAddWarehouseButtonClick, onAddTireTypeButtonClick, onAddTireBrandButtonClick, onModifyInventoryButtonClick, onDeleteTireTypeButtonClick, onDeleteTireBrandButtonClick }) => {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Warehouse Management System
        </Typography>
        <Button color="inherit" onClick={onInventoryButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Inventory
        </Button>
        <Button color="inherit" onClick={onAddItemsButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Add Item(s)
        </Button>
        <Button color="inherit" onClick={onAddWarehouseButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Create Warehouse
        </Button>
        <Button color="inherit" onClick={onAddTireTypeButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Create TireType
        </Button>
        <Button color="inherit" onClick={onAddTireBrandButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Create TireBrand
        </Button>
        <Button color="inherit" onClick={onModifyInventoryButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Delete Inventory
        </Button>
        <Button color="inherit" onClick={onDeleteTireTypeButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Delete Tire Type
        </Button>
        <Button color="inherit" onClick={onDeleteTireBrandButtonClick} style={{ margin: '0.5rem', outline: '1px solid black' }}>
          Delete Tire Brand
        </Button>
      </Toolbar>
    </AppBar>
  );
};

export default TopBar;

