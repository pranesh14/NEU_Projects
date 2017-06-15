/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class DrugHistory {

    private ArrayList<Drug> drugHistory;

    public DrugHistory() {
        drugHistory = new ArrayList<>();
    }

    public ArrayList<Drug> getDrugHistory() {
        return drugHistory;
    }

    public Drug createDrug() {
        Drug compound = new Drug();
        drugHistory.add(compound);
        return compound;
    }

}
