/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Compound;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class CompoundHistory {

    private ArrayList<Compound> compoundHistory;

    public CompoundHistory() {
        compoundHistory = new ArrayList<>();
    }

    public ArrayList<Compound> getCompoundHistory() {
        return compoundHistory;
    }

    public Compound createCompound() {
        Compound compound = new Compound();
        compoundHistory.add(compound);
        return compound;
    }

}
