/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Compound.CompoundHistory;
import Business.Disease.DiseaseCatalog;
import Business.Drug.DrugHistory;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Medicine.MedicineCatalog;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author PRPC
 */
public class Network {

    public String location;
    public EmployeeDirectory employeeDirectory;
    public UserAccountDirectory userAccountDirectory;
    private EnterpriseDirectory enterpriseDirectory;
    private String headQuarters;
    private int iD;
    private static int count = 1;
    private CompoundHistory compoundList;
    private DrugHistory drugList;
    private MedicineCatalog medicineCatalog;
    private DiseaseCatalog diseaseList;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        iD = count;
        count++;
        compoundList = new CompoundHistory();
        drugList = new DrugHistory();
        medicineCatalog = new MedicineCatalog();
        diseaseList = new DiseaseCatalog();
    }

    public DiseaseCatalog getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(DiseaseCatalog diseaseList) {
        this.diseaseList = diseaseList;
    }

    public DrugHistory getDrugList() {
        return drugList;
    }

    public void setDrugList(DrugHistory drugList) {
        this.drugList = drugList;
    }

    public MedicineCatalog getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(MedicineCatalog medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
    }

    public CompoundHistory getCompoundList() {
        return compoundList;
    }

    public void setCompoundList(CompoundHistory compoundList) {
        this.compoundList = compoundList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

}
