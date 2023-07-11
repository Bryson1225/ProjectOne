import React from "react";
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const InventoryTable = ({ inventory }) => {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Warehouse ID</TableCell>
            <TableCell>Tire Type ID</TableCell>
            <TableCell>Quantity</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {inventory.map((item) => (
            <TableRow key={`${item.warehouseId}-${item.tireTypeId}`}>
              <TableCell>{item.warehouse.warehouseId}</TableCell>
              <TableCell>{item.tireType.tireTypeId}</TableCell>
              <TableCell>{item.quantity}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default InventoryTable;
