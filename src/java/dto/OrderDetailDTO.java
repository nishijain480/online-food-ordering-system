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
public class OrderDetailDTO {

    private int orderdetailid;
    private OrderDTO order;
    private UserDTO user;
    private ItemDTO item;
    private int qty, price, amount;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderdetailid, OrderDTO order, UserDTO user, ItemDTO item, int qty, int price, int amount) {
        this.orderdetailid = orderdetailid;
        this.order = order;
        this.user = user;
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public ItemDTO getItem() {
        return item;
    }


    public int getOrderdetailid() {
        return orderdetailid;
    }

    public OrderDTO getOrder() {
        return order;
    }


    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }


    public void setOrderdetailid(int orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
