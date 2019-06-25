/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author root
 */
public class AdminDTO {
    private String unm,upass,umob,uotp;

    public AdminDTO() {
    }

    public AdminDTO(String unm, String upass, String umob,String uotp) {
        this.unm = unm;
        this.upass = upass;
        this.umob = umob;
        this.uotp= uotp;
    }

   

    public void setUnm(String unm) {
        this.unm = unm;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public void setUmob(String umob) {
        this.umob = umob;
    }
    public void setUotp(String uotp)
    {
      this.uotp=uotp;
    }

    public String getUnm() {
        return unm;
    }

    public String getUpass() {
        return upass;
    }

    public String getUmob() {
        return umob;
    }
    public String getUotp()
    {
      return uotp;
    }
    
}
