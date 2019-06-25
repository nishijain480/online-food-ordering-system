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
public class DeliveryAddressDTO {

    private int did;
    private UserDTO user;
    private String deliverto, addline1, addline2, city, state, postalcode;

    public DeliveryAddressDTO() {
    }

    public DeliveryAddressDTO(int did, UserDTO user, String deliverto, String addline1, String addline2, String city, String state, String postalcode) {
        this.did = did;
        this.user = user;
        this.deliverto = deliverto;
        this.addline1 = addline1;
        this.addline2 = addline2;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
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

    public String getDeliverto() {
        return deliverto;
    }

    public int getDid() {
        return did;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getState() {
        return state;
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

    public void setDeliverto(String deliverto) {
        this.deliverto = deliverto;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


}
