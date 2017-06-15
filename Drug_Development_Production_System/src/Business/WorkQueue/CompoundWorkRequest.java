/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Compound.Compound;

/**
 *
 * @author PRPC
 */
public class CompoundWorkRequest extends WorkRequest {

    private Compound compound;

    public Compound getCompound() {
        return compound;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }

}
