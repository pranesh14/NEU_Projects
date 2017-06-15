/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Disease.Disease;
import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class Patient {

    private String name;
    private int age;
    private String gender;
    private Disease disease;
    private ArrayList<Findings> findingsList;

    public Patient() {
        findingsList = new ArrayList<>();
    }

    public ArrayList<Findings> getFindingsList() {
        return findingsList;
    }

    public void setFindingsList(ArrayList<Findings> findingsList) {
        this.findingsList = findingsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Findings addFinding() {
        Findings finding = new Findings();
        findingsList.add(finding);
        return finding;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
