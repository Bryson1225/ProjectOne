package com.projectone.projectone.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @EmbeddedId
    private InventoryId id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "fk_inventory_warehouse"))
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "tire_type_id", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "fk_inventory_tire_type"))
    private TireType tireType;

    public Inventory() {
    }

    public Inventory(InventoryId id, Integer quantity, Warehouse warehouse, TireType tireType) {
        this.id = id;
        this.quantity = quantity;
        this.warehouse = warehouse;
        this.tireType = tireType;
    }

    public InventoryId getId() {
        return id;
    }

    public void setId(InventoryId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public TireType getTireType() {
        return tireType;
    }

    public void setTireType(TireType tireType) {
        this.tireType = tireType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
        result = prime * result + ((tireType == null) ? 0 : tireType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inventory other = (Inventory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (warehouse == null) {
            if (other.warehouse != null)
                return false;
        } else if (!warehouse.equals(other.warehouse))
            return false;
        if (tireType == null) {
            if (other.tireType != null)
                return false;
        } else if (!tireType.equals(other.tireType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Inventory [id=" + id + ", quantity=" + quantity + ", warehouse=" + warehouse + ", tireType=" + tireType
                + "]";
    }

    /*
     * BEGINNING OF INNER CLASS - USING THIS FOR THE COMPOSITE KEY
     */
    @Embeddable
    public static class InventoryId implements Serializable {

        @Column(name = "warehouse_id")
        private Long warehouseId;

        @Column(name = "tire_type_id")
        private Long tireTypeId;

        public InventoryId() {
        }

        public InventoryId(Long warehouseId, Long tireTypeId) {
            this.warehouseId = warehouseId;
            this.tireTypeId = tireTypeId;
        }

        public Long getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(Long warehouseId) {
            this.warehouseId = warehouseId;
        }

        public Long getTireTypeId() {
            return tireTypeId;
        }

        public void setTireTypeId(Long tireTypeId) {
            this.tireTypeId = tireTypeId;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((warehouseId == null) ? 0 : warehouseId.hashCode());
            result = prime * result + ((tireTypeId == null) ? 0 : tireTypeId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            InventoryId other = (InventoryId) obj;
            if (warehouseId == null) {
                if (other.warehouseId != null)
                    return false;
            } else if (!warehouseId.equals(other.warehouseId))
                return false;
            if (tireTypeId == null) {
                if (other.tireTypeId != null)
                    return false;
            } else if (!tireTypeId.equals(other.tireTypeId))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "InventoryId [warehouseId=" + warehouseId + ", tireTypeId=" + tireTypeId + "]";
        }
    }

}
