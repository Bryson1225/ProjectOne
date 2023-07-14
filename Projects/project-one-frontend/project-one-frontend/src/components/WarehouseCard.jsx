// WarehouseCard.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Card, CardContent, Typography, Button } from "@mui/material";

const WarehouseCard = ({ warehouse, expanded, onExpand }) => {

  const handleExpand = () => {
    onExpand(warehouse); // Pass the warehouse object directly
  };

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/warehouses/warehouse/${warehouse.warehouseId}`);
      onDelete(warehouse.warehouseId);
    } catch (error) {
      console.error("Error deleting warehouse:", error);
      alert("THIS WAREHOUSE IS NOT EMPTY");
    }
  };

  return (
    <Card variant="outlined">
      <CardContent>
        <Typography variant="h4" component="div">
          Warehouse ID: {warehouse.warehouseId}
        </Typography>
        <Typography variant="body1">Name: {warehouse.warehouseName}</Typography>
        <Typography variant="body1">Capacity: {warehouse.maximumCapacity}</Typography>
        <Button onClick={handleExpand}>{expanded ? "Collapse" : "Expand"}</Button> {/* Use expanded prop to change button text */}
        <Button onClick={handleDelete}>Delete</Button>
      </CardContent>
    </Card>
  );
};

export default WarehouseCard;
