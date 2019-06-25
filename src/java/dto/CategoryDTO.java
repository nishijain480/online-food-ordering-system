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
public class CategoryDTO {

    private int catid;
    private String catnm;
    private ArrayList<ItemDTO> itemlist;

    public CategoryDTO() {
    }

    public CategoryDTO(int catid, String catnm, ArrayList<ItemDTO> itemlist) {
        this.catid = catid;
        this.catnm = catnm;
        this.itemlist = itemlist;
    }

    public void setItemlist(ArrayList<ItemDTO> itemlist) {
        this.itemlist = itemlist;
    }

    public ArrayList<ItemDTO> getItemlist() {
        return itemlist;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public void setCatnm(String catnm) {
        this.catnm = catnm;
    }

    public int getCatid() {
        return catid;
    }

    public String getCatnm() {
        return catnm;
    }

}
