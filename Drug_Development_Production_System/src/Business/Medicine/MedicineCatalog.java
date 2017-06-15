/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class MedicineCatalog {

    private ArrayList<Medicine> medicineList;

    public MedicineCatalog() {
        medicineList = new ArrayList<>();
    }

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public Medicine createMedicine() {
        Medicine med = new Medicine();
        medicineList.add(med);
        return med;
    }

}
