/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import Business.Compound.Compound;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PRPC
 */
public class Drug {

    private String name;
    private String description;
    private String molecularFormula;
    private Double molecularWeight;
    private Date discoveryDate;
    private ArrayList<Compound> compoundList;
    private String status;

    public Drug() {
        discoveryDate = new Date();
        compoundList = new ArrayList<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addCompound(Compound compound) {
        compoundList.add(compound);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public Double getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(Double molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public ArrayList<Compound> getCompoundList() {
        return compoundList;
    }

    public void setCompoundList(ArrayList<Compound> compoundList) {
        this.compoundList = compoundList;
    }

    @Override
    public String toString() {
        return name;
    }

}
