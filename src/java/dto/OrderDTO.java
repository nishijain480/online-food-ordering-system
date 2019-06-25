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
public class OrderDTO {

    private int orderid;
    private String orderdate;
    private UserDTO user;
    private int orderqty, orderamt;
    private String deliverto, addline1, addline2, city, state, postalcode, statusupdatedt;
    private int status;
    private ArrayList<OrderDetailDTO> odlist;

    public OrderDTO() {
    }

    public OrderDTO(int orderid, String orderdate, UserDTO user, int orderqty, int orderamt, String deliverto, String addline1, String addline2, String city, String state, String postalcode, String statusupdatedt, int status, ArrayList<OrderDetailDTO> odlist) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.user = user;
        this.orderqty = orderqty;
        this.orderamt = orderamt;
        this.deliverto = deliverto;
        this.addline1 = addline1;
        this.addline2 = addline2;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.statusupdatedt = statusupdatedt;
        this.status = status;
        this.odlist = odlist;
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

    public int getOrderamt() {
        return orderamt;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getState() {
        return state;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusupdatedt() {
        return statusupdatedt;
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

    public void setOrderamt(int orderamt) {
        this.orderamt = orderamt;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setStatusupdatedt(String statusupdatedt) {
        this.statusupdatedt = statusupdatedt;
    }

    public ArrayList<OrderDetailDTO> getOdlist() {
        return odlist;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
