package com.projectone.projectone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIRETYPE")
public class TireType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tire_type_id")
    private Integer tireTypeId;

    @Column(name = "tire_type_name")
    private String tireTypeName;

    @Column
    private String description;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private TireBrand tireBrand;

    public TireType() {
    }

    public TireType(String tireTypeName, String description, Double price, TireBrand tireBrand) {
        this.tireTypeName = tireTypeName;
        this.description = description;
        this.price = price;
        this.tireBrand = tireBrand;
    }

    public Integer getTireTypeId() {
        return tireTypeId;
    }

    public void setTireTypeId(Integer tireTypeId) {
        this.tireTypeId = tireTypeId;
    }

    public String getTireTypeName() {
        return tireTypeName;
    }

    public void setTireTypeName(String tireTypeName) {
        this.tireTypeName = tireTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TireBrand getTireBrand() {
        return tireBrand;
    }

    public void setTireBrand(TireBrand tireBrand) {
        this.tireBrand = tireBrand;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tireTypeId == null) ? 0 : tireTypeId.hashCode());
        result = prime * result + ((tireTypeName == null) ? 0 : tireTypeName.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((tireBrand == null) ? 0 : tireBrand.hashCode());
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
        TireType other = (TireType) obj;
        if (tireTypeId == null) {
            if (other.tireTypeId != null)
                return false;
        } else if (!tireTypeId.equals(other.tireTypeId))
            return false;
        if (tireTypeName == null) {
            if (other.tireTypeName != null)
                return false;
        } else if (!tireTypeName.equals(other.tireTypeName))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (tireBrand == null) {
            if (other.tireBrand != null)
                return false;
        } else if (!tireBrand.equals(other.tireBrand))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TireType [tireTypeId=" + tireTypeId + ", tireTypeName=" + tireTypeName + ", description=" + description
                + ", price=" + price + ", tireBrand=" + tireBrand + "]";
    }

}

