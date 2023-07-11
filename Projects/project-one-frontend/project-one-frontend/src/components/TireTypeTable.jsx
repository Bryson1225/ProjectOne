import React from "react";
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const TireTypeTable = ({ tireTypes }) => {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Tire Type ID</TableCell>
            <TableCell>Tire Type Name</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Price</TableCell>
            <TableCell>Brand ID</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {tireTypes.map((type) => (
            <TableRow key={type.tireTypeId}>
              <TableCell>{type.tireTypeId}</TableCell>
              <TableCell>{type.tireTypeName}</TableCell>
              <TableCell>{type.description}</TableCell>
              <TableCell>{type.price}</TableCell>
              <TableCell>{type.brandId}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default TireTypeTable;
