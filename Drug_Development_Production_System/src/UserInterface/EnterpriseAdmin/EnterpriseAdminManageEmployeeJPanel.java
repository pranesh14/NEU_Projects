/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseAdmin;

import Business.Employee.Employee;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author joseph antony
 */
public class EnterpriseAdminManageEmployeeJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public Organization organization;

    /**
     * Creates new form EnterpriseAdminManageEmployee
     */
    public EnterpriseAdminManageEmployeeJPanel(JPanel userProcessContainer, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpName = new javax.swing.JTextField();
        txtEmpAge = new javax.swing.JTextField();
        txtEmpDesignation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Manage Employee");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Name");

        txtEmpName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        txtEmpAge.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        txtEmpDesignation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Designation");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Age");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(347, 347, 347)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmpDesignation, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmpAge, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmpName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(558, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(104, 104, 104)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtEmpAge.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Age", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (txtEmpDesignation.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Designation", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (txtEmpName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Name", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Employee emp = organization.getEmployeeDirectory().createEmployee();
        emp.setAge(Integer.parseInt(txtEmpAge.getText()));
        emp.setDesignation(txtEmpDesignation.getText());
        emp.setName(txtEmpName.getText());

        JOptionPane.showMessageDialog(null, "Organization Administrator has been employed", "Information", JOptionPane.INFORMATION_MESSAGE);

        EnterpriseAdminManageUserAccountJPanel EnterpriseAdminManageUserAccountJPanel = new EnterpriseAdminManageUserAccountJPanel(userProcessContainer, organization, emp);
        userProcessContainer.add("EnterpriseAdminManageUserAccountJPanel", EnterpriseAdminManageUserAccountJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEmpAge;
    private javax.swing.JTextField txtEmpDesignation;
    private javax.swing.JTextField txtEmpName;
    // End of variables declaration//GEN-END:variables
}
