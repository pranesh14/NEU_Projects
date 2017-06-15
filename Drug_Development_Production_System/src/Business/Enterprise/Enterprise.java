/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Drug.DrugHistory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author PRPC
 */
public class Enterprise extends Organization {

    private String headQuaters;
    private OrganizationDirectory organizationDirectory;
    private String function;
    private int iD;
    private static int count = 1;
    private DrugHistory drugList;

    public Enterprise() {
        super();
        organizationDirectory = new OrganizationDirectory();
        drugList = new DrugHistory();
        iD = count;
        count++;
    }

    public DrugHistory getDrugList() {
        return drugList;
    }

    public void setDrugList(DrugHistory drugList) {
        this.drugList = drugList;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public String getHeadQuaters() {
        return headQuaters;
    }

    public void setHeadQuaters(String headQuaters) {
        this.headQuaters = headQuaters;
    }

    @Override
    public String toString() {
        return getName();
    }

}
