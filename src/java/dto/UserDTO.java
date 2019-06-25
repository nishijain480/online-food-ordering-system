/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class UserDTO {
    private int uid;
    private String mobileno,email,upass,otp,fullname,regdate;
    private int status;
    private ArrayList<DeliveryAddressDTO> addlist;
    
    
    public UserDTO() {
    }

    public UserDTO(int uid, String mobileno, String email, String upass, String otp, String fullname, String regdate, int status, ArrayList<DeliveryAddressDTO> addlist) {
        this.uid = uid;
        this.mobileno = mobileno;
        this.email = email;
        this.upass = upass;
        this.otp = otp;
        this.fullname = fullname;
        this.regdate = regdate;
        this.status = status;
        this.addlist = addlist;
    }
    

    public ArrayList<DeliveryAddressDTO> getAddlist() {
        return addlist;
    }

    public void setAddlist(ArrayList<DeliveryAddressDTO> addlist) {
        this.addlist = addlist;
    }


    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getOtp() {
        return otp;
    }

    public String getRegdate() {
        return regdate;
    }

    public int getStatus() {
        return status;
    }

    public int getUid() {
        return uid;
    }

    public String getUpass() {
        return upass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    
}
