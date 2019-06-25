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
public class ItemDTO {
    private int itemid;
    private String itemnm,itemdesc,itempic;
    private int itemprice;
    private CategoryDTO cat;
    private int status;
    
    public ItemDTO() {
    }

    public ItemDTO(int itemid, String itemnm, String itemdesc, String itempic, int itemprice, CategoryDTO cat, int status) {
        this.itemid = itemid;
        this.itemnm = itemnm;
        this.itemdesc = itemdesc;
        this.itempic = itempic;
        this.itemprice = itemprice;
        this.cat = cat;
        this.status = status;
    }



    public CategoryDTO getCat() {
        return cat;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public int getItemid() {
        return itemid;
    }

    public String getItemnm() {
        return itemnm;
    }

    public String getItempic() {
        return itempic;
    }

    public int getItemprice() {
        return itemprice;
    }


    public int getStatus() {
        return status;
    }

    public void setCat(CategoryDTO cat) {
        this.cat = cat;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public void setItemnm(String itemnm) {
        this.itemnm = itemnm;
    }

    public void setItempic(String itempic) {
        this.itempic = itempic;
    }

    public void setItemprice(int itemprice) {
        this.itemprice = itemprice;
    }


    public void setStatus(int status) {
        this.status = status;
    }
    
}
