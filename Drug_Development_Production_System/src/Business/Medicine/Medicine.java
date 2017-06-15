/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import Business.Drug.Drug;
import java.util.Date;

/**
 *
 * @author PRPC
 */
public class Medicine {

    private String name;
    private Drug drug;
    private int quantity;
    private Form form;
    private Integer unitPrice;
    private Date discoveryDate;

    public Medicine() {
        drug = new Drug();
        discoveryDate = new Date();
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public enum Form {
        Capsule, Pill, Drops, Syrup
    };

    public String toString() {
        return this.name;
    }

}
