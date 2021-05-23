package com.example;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "LBT_HDR")
public class LbtHdr implements Serializable {
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NTRNL_LBT_HDR")
    private Long ntrnlLbtHdr;

    @JoinColumn(name = "LBT_TYP_CD", referencedColumnName = "LBT_TYP_CD")
    @ManyToOne
    private LbtTyp lbtTypCd;

    @JoinColumn(name = "SSN_TYP_CD", referencedColumnName = "SSN_TYP_CD")
    @ManyToOne
    private SsnTyp ssnTypCd;
    

    public Long getNtrnlLbtHdr() {
        return ntrnlLbtHdr;
    }

    public void setNtrnlLbtHdr(Long ntrnlLbtHdr) {
        this.ntrnlLbtHdr = ntrnlLbtHdr;
    }

    public LbtTyp getLbtTypCd() {
        return lbtTypCd;
    }

    public void setLbtTypCd(LbtTyp lbtTypCd) {
        this.lbtTypCd = lbtTypCd;
    }


    public SsnTyp getSsnTypCd() {
        return ssnTypCd;
    }

    public void setSsnTypCd(SsnTyp ssnTypCd) {
        this.ssnTypCd = ssnTypCd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lbtTypCd == null) ? 0 : lbtTypCd.hashCode());
        result = prime * result + ((ntrnlLbtHdr == null) ? 0 : ntrnlLbtHdr.hashCode());
        result = prime * result + ((ssnTypCd == null) ? 0 : ssnTypCd.hashCode());
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
        LbtHdr other = (LbtHdr) obj;
        if (lbtTypCd == null) {
            if (other.lbtTypCd != null)
                return false;
        } else if (!lbtTypCd.equals(other.lbtTypCd))
            return false;
        if (ntrnlLbtHdr == null) {
            if (other.ntrnlLbtHdr != null)
                return false;
        } else if (!ntrnlLbtHdr.equals(other.ntrnlLbtHdr))
            return false;
        if (ssnTypCd == null) {
            if (other.ssnTypCd != null)
                return false;
        } else if (!ssnTypCd.equals(other.ssnTypCd))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LbtHdr [lbtTypCd=" + lbtTypCd + ", ntrnlLbtHdr=" + ntrnlLbtHdr + ", ssnTypCd=" + ssnTypCd + "]";
    }

    

    
    
    
}
