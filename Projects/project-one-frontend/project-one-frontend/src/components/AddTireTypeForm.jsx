import React, { useState, useEffect } from "react";
import axios from "axios";

const AddTireTypeForm = () => {
  const [brands, setBrands] = useState([]);
  const [selectedBrandId, setSelectedBrandId] = useState("");
  const [typeName, setTypeName] = useState("");
  const [description, setDescription] = useState("");

  useEffect(() => {
    fetchBrands();
  }, []);

  const fetchBrands = async () => {
    try {
      const response = await axios.get("http://localhost:8080/tire-brands");
      setBrands(response.data);
    } catch (error) {
      console.error("Error fetching brands:", error);
    }
  };

  const handleBrandChange = (event) => {
    setSelectedBrandId(event.target.value);
  };

  const handleTypeNameChange = (event) => {
    setTypeName(event.target.value);
  };

  const handleDescriptionChange = (event) => {
    setDescription(event.target.value);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();

    const newTireType = {
      tireTypeName: typeName,
      description: description,
      tireBrand: {
        brandId: selectedBrandId,
      },
    };

    try {
      const response = await axios.post("http://localhost:8080/tire-types", newTireType);

      // Clear form inputs
      setSelectedBrandId("");
      setTypeName("");
      setDescription("");
    } catch (error) {
      console.error("Error adding tire type:", error);
    }
  };

  return (
    <div className="add-tire-type-form">
      <h2>Add New Tire Type</h2>
      <form onSubmit={handleFormSubmit}>
        <div className="form-group">
          <label htmlFor="brandSelect">Tire Brand:</label>
          <select id="brandSelect" value={selectedBrandId} onChange={handleBrandChange} required>
            <option value="">Select Brand</option>
            {brands.map((brand) => (
              <option key={brand.brandId} value={brand.brandId}>
                {brand.brandName}
              </option>
            ))}
          </select>
        </div>
        <div className="form-group">
          <label htmlFor="typeNameInput">Type Name:</label>
          <input
            type="text"
            id="typeNameInput"
            value={typeName}
            onChange={handleTypeNameChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="descriptionInput">Description:</label>
          <input
            type="text"
            id="descriptionInput"
            value={description}
            onChange={handleDescriptionChange}
            required
          />
        </div>
        <button type="submit">Add Tire Type</button>
      </form>
    </div>
  );
};

export default AddTireTypeForm;
