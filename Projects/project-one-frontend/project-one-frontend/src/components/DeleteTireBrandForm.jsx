import React, { useState, useEffect } from "react";
import axios from "axios";

const DeleteTireBrandForm = () => {
  const [tireBrands, setTireBrands] = useState([]);
  const [selectedTireBrand, setSelectedTireBrand] = useState("");

  useEffect(() => {
    fetchTireBrands();
  }, []);

  const fetchTireBrands = async () => {
    try {
      const response = await axios.get("http://localhost:8080/tire-brands");
      setTireBrands(response.data);
    } catch (error) {
      console.error("Error fetching tire brands:", error);
    }
  };

  const handleTireBrandChange = (event) => {
    setSelectedTireBrand(event.target.value);
  };

  const handleDeleteTireBrand = async () => {
    try {
      await axios.delete(`http://localhost:8080/tire-brands/delete-tireBrand/${selectedTireBrand}`);
      // Handle successful deletion (e.g., show a success message, update the UI)
      console.log("Tire brand deleted successfully");
    } catch (error) {
        alert("STILL INVENTORY FOR THIS TIREBRAND - DELETE NOT COMPLETED")
      console.error("Error deleting tire brand:", error);
    }
  };

  return (
    <div>
      <h3>Delete Tire Brand</h3>
      <form>
        <div>
          <label htmlFor="tireBrandSelect">Select Tire Brand:</label>
          <select
            id="tireBrandSelect"
            value={selectedTireBrand}
            onChange={handleTireBrandChange}
          >
            <option value="">Select Tire Brand</option>
            {tireBrands.map((tireBrand) => (
              <option key={tireBrand.brandId} value={tireBrand.brandId}>
                {tireBrand.brandName}
              </option>
            ))}
          </select>
        </div>
        <button type="button" onClick={handleDeleteTireBrand}>
          Delete
        </button>
      </form>
    </div>
  );
};

export default DeleteTireBrandForm;
