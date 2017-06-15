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
import javax.swing.JPanel;

/**
 *
 * @author PRPC
 */
public abstract class Role {

    public enum Type {
        Admin, Scientist, LabAssistant, SystemAdmin, NetworkAdmin, RandDEnterpriseAdmin, ClinicalEnterpriseAdmin, MarketEnterpriseAdmin, CompoundRandDOrganizationAdmin, DrugRandDOrganizationAdmin
    };

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            Ecosystem business,
            Network network);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
