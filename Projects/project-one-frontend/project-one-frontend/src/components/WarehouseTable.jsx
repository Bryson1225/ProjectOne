import React from "react";
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const WarehouseTable = ({ warehouses }) => {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Warehouse ID</TableCell>
            <TableCell>Warehouse Name</TableCell>
            <TableCell>Maximum Capacity</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {warehouses.map((warehouse) => (
            <TableRow key={warehouse.warehouseId}>
              <TableCell>{warehouse.warehouseId}</TableCell>
              <TableCell>{warehouse.warehouseName}</TableCell>
              <TableCell>{warehouse.maximumCapacity}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default WarehouseTable;
