/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createEnterprise() {
        Enterprise enterprise = new Enterprise();
        enterpriseList.add(enterprise);
        return enterprise;
    }

    private void removeEnterprise(Enterprise enterprise) {
        enterpriseList.remove(enterprise);
    }

}
