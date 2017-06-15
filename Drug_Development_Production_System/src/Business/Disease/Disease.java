/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Disease;
import Business.Gene.Gene;
import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class Disease {
    
    private String name;
    private String symptoms;
    private String causingAgent;
    private ArrayList<Gene> affectedGenes;
    
    public Disease(){
        affectedGenes = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getCausingAgent() {
        return causingAgent;
    }

    public void setCausingAgent(String causingAgent) {
        this.causingAgent = causingAgent;
    }
    
    public void addAffectedGene(Gene gene){
        affectedGenes.add(gene);
    }

    public ArrayList<Gene> getAffectedGenes() {
        return affectedGenes;
    }

    @Override
    public String toString(){
        return name;
    }
}
