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
import UserInterface.LabAssistant.CompoundLabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author PRPC
 */
public class CompoundLabAssistant extends Role {

    private String name = "CompoundLabAssistant";

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new CompoundLabAssistantWorkAreaJPanel(userProcessContainer, organization, account);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
