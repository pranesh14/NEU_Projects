/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gene;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class GeneCatalog {

    private ArrayList<Gene> geneList;

    public GeneCatalog() {
        geneList = new ArrayList<>();
    }

    public Gene addGene() {
        Gene gene = new Gene();
        geneList.add(gene);
        return gene;
    }

    public ArrayList<Gene> getGeneList() {
        return geneList;
    }

}
