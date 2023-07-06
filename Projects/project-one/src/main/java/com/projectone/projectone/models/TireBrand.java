package com.projectone.projectone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIREBRAND")
public class TireBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    private String brandName;

    public TireBrand() {
    }

    public TireBrand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
        result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
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
        TireBrand other = (TireBrand) obj;
        if (brandId == null) {
            if (other.brandId != null)
                return false;
        } else if (!brandId.equals(other.brandId))
            return false;
        if (brandName == null) {
            if (other.brandName != null)
                return false;
        } else if (!brandName.equals(other.brandName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TireBrand [brandId=" + brandId + ", brandName=" + brandName + "]";
    }

}

