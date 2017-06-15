/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class Doctor extends Employee {

    private ArrayList<Patient> patientList;
    private String sex;

    public Doctor() {
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

}
