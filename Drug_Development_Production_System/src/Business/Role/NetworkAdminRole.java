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
import UserInterface.NetworkAdmin.NetworkAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author PRPC
 */
public class NetworkAdminRole extends Role {

    private String name = "NetworkAdminRole";

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new NetworkAdminWorkAreaJPanel(userProcessContainer, network);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
