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
public class RestaurantDTO {

    private String resnm, addline1, addline2, city, state, contact, fromtime, totime;

    public RestaurantDTO() {
    }

    public RestaurantDTO(String resnm, String addline1, String addline2, String city, String state, String contact, String fromtime, String totime) {
        this.resnm = resnm;
        this.addline1 = addline1;
        this.addline2 = addline2;
        this.city = city;
        this.state = state;
        this.contact = contact;
        this.fromtime = fromtime;
        this.totime = totime;
    }

    public String getAddline1() {
        return addline1;
    }

    public String getAddline2() {
        return addline2;
    }

    public String getCity() {
        return city;
    }

    public String getContact() {
        return contact;
    }

    public String getFromtime() {
        return fromtime;
    }

    public String getResnm() {
        return resnm;
    }

    public String getState() {
        return state;
    }

    public String getTotime() {
        return totime;
    }

    public void setAddline1(String addline1) {
        this.addline1 = addline1;
    }

    public void setAddline2(String addline2) {
        this.addline2 = addline2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFromtime(String fromtime) {
        this.fromtime = fromtime;
    }

    public void setResnm(String resnm) {
        this.resnm = resnm;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTotime(String totime) {
        this.totime = totime;
    }

}
