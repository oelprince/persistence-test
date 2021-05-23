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
@Table(name = "SSN_TYP")
public class SsnTyp implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSN_TYP_CD")
    private char SsnTypCd;

    @OneToMany(mappedBy = "ssnTypCd")
    private List<LbtHdr> lbtHdrList;

    public char getSsnTypCd() {
        return SsnTypCd;
    }

    public void setSsnTypCd(char ssnTypCd) {
        SsnTypCd = ssnTypCd;
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
        result = prime * result + SsnTypCd;
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
        SsnTyp other = (SsnTyp) obj;
        if (SsnTypCd != other.SsnTypCd)
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
        return "SsnTyp [SsnTypCd=" + SsnTypCd + ", lbtHdrList=" + lbtHdrList + "]";
    } 
    
}
