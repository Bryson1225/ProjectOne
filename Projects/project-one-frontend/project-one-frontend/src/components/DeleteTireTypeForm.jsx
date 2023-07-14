import React, { useState, useEffect } from "react";
import axios from "axios";

const DeleteTireTypeForm = () => {
  const [tireTypes, setTireTypes] = useState([]);
  const [selectedTireType, setSelectedTireType] = useState("");

  useEffect(() => {
    fetchTireTypes();
  }, []);

  const fetchTireTypes = async () => {
    try {
      const response = await axios.get("http://localhost:8080/tire-types");
      console.log(response.data);
      setTireTypes(response.data);
    } catch (error) {
      console.error("Error fetching tire types:", error);
    }
  };

  const handleTireTypeChange = (event) => {
    setSelectedTireType(event.target.value);
  };

  const handleDeleteTireType = async () => {
    try {
      await axios.delete(`http://localhost:8080/tire-types/${selectedTireType}`);
      // Handle successful deletion (e.g., show a success message, update the UI)
      console.log("Tire type deleted successfully");
    } catch (error) {
        alert("TIRE TYPE CURRENTLY HAS INVENTORY - CANNOT DELETE")
      console.error("Error deleting tire type:", error);
    }
  };

  return (
    <div>
      <h3>Delete Tire Type</h3>
      <form>
        <div>
          <label htmlFor="tireTypeSelect">Select Tire Type:</label>
          <select
            id="tireTypeSelect"
            value={selectedTireType}
            onChange={handleTireTypeChange}
          >
            <option value="">Select Tire Type</option>
            {tireTypes.map((tireType) => (
              <option key={tireType.tireTypeId} value={tireType.tireTypeId}>
                {tireType.tireTypeName}
              </option>
            ))}
          </select>
        </div>
        <button type="button" onClick={handleDeleteTireType}>
          Delete
        </button>
      </form>
    </div>
  );
};

export default DeleteTireTypeForm;
