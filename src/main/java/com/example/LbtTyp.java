package com.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "LBT_TYP")
public class LbtTyp implements Serializable {
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LBT_TYP_CD")
    private Integer LbtTypCd;
   
    @OneToMany(mappedBy = "lbtTypCd")
    private List<LbtHdr> lbtHdrList;

    public Integer getLbtTypCd() {
        return LbtTypCd;
    }

    public void setLbtTypCd(Integer lbtTypCd) {
        LbtTypCd = lbtTypCd;
    }

    public List<LbtHdr> getLbtHdrList() {
        return lbtHdrList;
    }

    public void setLbtHdrList(List<LbtHdr> lbtHdrList) {
        this.lbtHdrList = lbtHdrList;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((LbtTypCd == null) ? 0 : LbtTypCd.hashCode());
        result = prime * result + ((lbtHdrList == null) ? 0 : lbtHdrList.hashCode());
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
        LbtTyp other = (LbtTyp) obj;
        if (LbtTypCd == null) {
            if (other.LbtTypCd != null)
                return false;
        } else if (!LbtTypCd.equals(other.LbtTypCd))
            return false;
        if (lbtHdrList == null) {
            if (other.lbtHdrList != null)
                return false;
        } else if (!lbtHdrList.equals(other.lbtHdrList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LbtTyp [LbtTypCd=" + LbtTypCd + ", lbtHdrList=" + lbtHdrList + "]";
    }
  
    
}
