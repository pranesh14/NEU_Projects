/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Compound.CompoundHistory;
import Business.Disease.DiseaseCatalog;
import Business.Gene.GeneCatalog;
import Business.Drug.DrugHistory;
import Business.Medicine.MedicineCatalog;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.PatientDirectory;
import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class Ecosystem extends Organization {

    private static Ecosystem Ecosystem;
    private ArrayList<Network> networkList;
    private Organization doctorOrganization;
    private MedicineCatalog medicineCatalog;
    private PatientDirectory patientList;
    private CompoundHistory compoundList;
    private DrugHistory drugList;
    private DiseaseCatalog diseaseList;
    private GeneCatalog geneList;

    public static Ecosystem getInstance() {
        if (Ecosystem == null) {
            Ecosystem = new Ecosystem();
        }

        return Ecosystem;
    }

    private Ecosystem() {
        super();
        networkList = new ArrayList<>();
        medicineCatalog = new MedicineCatalog();
        patientList = new PatientDirectory();
        compoundList = new CompoundHistory();
        drugList = new DrugHistory();
        diseaseList = new DiseaseCatalog();
        geneList = new GeneCatalog();
    }

    public GeneCatalog getGeneList() {
        return geneList;
    }

    public DiseaseCatalog getDiseaseList() {
        return diseaseList;
    }

    public CompoundHistory getCompoundList() {
        return compoundList;
    }

    public void setCompoundList(CompoundHistory compoundList) {
        this.compoundList = compoundList;
    }

    public DrugHistory getDrugList() {
        return drugList;
    }

    public void setDrugList(DrugHistory drugList) {
        this.drugList = drugList;
    }

    public Organization getDoctorOrganization() {
        return doctorOrganization;
    }

    public void setDoctorOrganization(Organization doctorOrganization) {
        this.doctorOrganization = doctorOrganization;
    }

    public MedicineCatalog getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(MedicineCatalog medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
    }

    public PatientDirectory getPatientList() {
        return patientList;
    }

    public void setPatientList(PatientDirectory patientList) {
        this.patientList = patientList;
    }

    public Network addNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        return this.getUserAccountDirectory().checkIfUsernameIsUnique(username);
    }

}
