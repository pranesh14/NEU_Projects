/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Compound.Compound;
import Business.Drug.Drug;

/**
 *
 * @author PRPC
 */
public class DrugWorkRequest extends WorkRequest {

    private Compound compound;
    private Drug drug;

    public Compound getCompound() {
        return compound;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

}
