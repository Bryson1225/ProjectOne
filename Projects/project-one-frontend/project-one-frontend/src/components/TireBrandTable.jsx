import React from "react";
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const TireBrandTable = ({ tireBrands }) => {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Brand ID</TableCell>
            <TableCell>Brand Name</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {tireBrands.map((brand) => (
            <TableRow key={brand.brandId}>
              <TableCell>{brand.brandId}</TableCell>
              <TableCell>{brand.brandName}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default TireBrandTable;

