import React, { useState } from "react";
import axios from "axios";

/**
 * 
 * Class: AddTireBrandForm.jsx
 *  -> Function: This is for adding a new tire Brand to the database
 */

const AddTireBrandForm = ({ onTireBrandAdded }) => {
  const [brandName, setBrandName] = useState("");

  // Just for the changing text box
  const handleBrandNameChange = (event) => {
    setBrandName(event.target.value);
  };

  // On submit we go to the right and point
  const handleFormSubmit = async (event) => {
    event.preventDefault();

    const newTireBrand = {
      brandName: brandName,
    };

    try {
      const response = await axios.post("http://localhost:8080/tire-brands/create-tireBrand", newTireBrand);

      // Clear form input
      setBrandName("");

      // Notify parent component that a new tire brand has been added
      if (onTireBrandAdded) {
        onTireBrandAdded();
      }
    } catch (error) {
      console.error("Error adding tire brand:", error);
    }
  };

  return (
    <div className="add-tire-brand-form">
      <h2>Add New Tire Brand</h2>
      <form onSubmit={handleFormSubmit}>
        <div className="form-group">
          <label htmlFor="brandNameInput">Brand Name:</label>
          <input
            type="text"
            id="brandNameInput"
            value={brandName}
            onChange={handleBrandNameChange}
            required
          />
        </div>
        <button type="submit">Add Tire Brand</button>
      </form>
    </div>
  );
};

export default AddTireBrandForm;
