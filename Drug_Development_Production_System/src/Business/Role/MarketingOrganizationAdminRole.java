/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Organization.MedicineRequestAdminWorkQueueJPanel;
import javax.swing.JPanel;

/**
 *
 * @author PRPC
 */
public class MarketingOrganizationAdminRole extends Role {

    private String name = "MarketingOrganizationAdminRole";

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new MedicineRequestAdminWorkQueueJPanel(userProcessContainer, organization, enterprise, account, business);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
