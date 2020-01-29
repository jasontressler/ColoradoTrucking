/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseproject;

/**
 *
 * @author jardo
 */
public class TruckData {
    
    String USDOT;
    String legalName;
    String Address;
    String OOSReason;
    String OOSDate;
    String status;

    public String getUSDOT() {
        return USDOT;
    }

    public String getLegalName() {
        return legalName;
    }

    public String getAddress() {
        return Address;
    }

    public String getOOSReason() {
        return OOSReason;
    }

    public String getOOSDate() {
        return OOSDate;
    }

    public String getStatus() {
        return status;
    }

    public void setUSDOT(String USDOT) {
        this.USDOT = USDOT;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setOOSReason(String OOSReason) {
        this.OOSReason = OOSReason;
    }

    public void setOOSDate(String OOSDate) {
        this.OOSDate = OOSDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TruckData(String USDOT, String legalName, String Address, String OOSReason, String OOSDate, String status) {
        this.USDOT = USDOT;
        this.legalName = legalName;
        this.Address = Address;
        this.OOSReason = OOSReason;
        this.OOSDate = OOSDate;
        this.status = status;
    }

    public TruckData() {
    }
    
    
}
