/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseAdmin;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Medicine.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClinicWorkRequest;
import Business.WorkQueue.DrugWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequest.Status;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph antony
 */
public class ClinicalEnterpriseAdminWorkQueueJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public Enterprise enterprise;
    public Ecosystem system;
    public UserAccount userAccount;

    /**
     * Creates new form ScientistWorkArea
     */
    public ClinicalEnterpriseAdminWorkQueueJPanel(JPanel userProcessContainer, Enterprise enterprise, Network network, Ecosystem system, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.userAccount = account;
        for (WorkRequest request : enterprise.getWorkQueue().getWorkQueue()) {
            if (request.getStatus() == Status.ENTERPRISE1ADMINAPPROVED) {
                request.setReceiver(account);
            } else if (request.getStatus() == Status.ORGANIZATION3ADMINAPPROVED) {
                request.setStatus(Status.ENTERPRISE2ADMINAPPROVED);
            }
        }
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblWorkQueue = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnMessageToAdmin = new javax.swing.JButton();
        txtMessageField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFinalApproval = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 153));

        tblWorkQueue.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tblWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Sender", "Receiver", "Status", "Message"
            }
        ));
        jScrollPane2.setViewportView(tblWorkQueue);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Clinical Enterprise Admin Work Queue");

        btnMessageToAdmin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMessageToAdmin.setText("Message To Admin");
        btnMessageToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageToAdminActionPerformed(evt);
            }
        });

        txtMessageField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Message :");

        btnFinalApproval.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFinalApproval.setText("Final Approval");
        btnFinalApproval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalApprovalActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Drug Details: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel2)
                        .addGap(65, 65, 65)
                        .addComponent(txtMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMessageToAdmin))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinalApproval, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(660, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessageToAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFinalApproval, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMessageToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageToAdminActionPerformed
        int selectedRow = tblWorkQueue.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to process", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtMessageField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a message to the admin of the Organization", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClinicWorkRequest request = (ClinicWorkRequest) tblWorkQueue.getValueAt(selectedRow, 4);
        if(request.getStatus() == Status.ENTERPRISE1ADMINAPPROVED)
        {
            request.setSender(userAccount);        
            request.setMessage(txtMessageField.getText());
            request.setReceiver(null);
            request.setStatus(Status.TOTESTCENTER);
            for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                org.getWorkQueue().getWorkQueue().add(request);
            }
            JOptionPane.showMessageDialog(null, "The selected drug has been sent for trials", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The selected drug cannot be sebt for trials", "Error", JOptionPane.ERROR_MESSAGE);
        }
        populateTable();
        txtMessageField.setText("");
    }//GEN-LAST:event_btnMessageToAdminActionPerformed

    private void btnFinalApprovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalApprovalActionPerformed
        Random ran = new Random();

        int selectedRow = tblWorkQueue.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to approve", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblWorkQueue.getValueAt(selectedRow, 4);
        if (request.getStatus() == Status.TESTFAILED) {
            JOptionPane.showMessageDialog(null, "The selected drug cannot be manufactured", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (request.getStatus() == Status.ENTERPRISE2ADMINAPPROVED) {
            request.setSender(userAccount);
            request.setReceiver(null);
            JOptionPane.showMessageDialog(null, "The selected drug is in mass production", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

        Medicine medicine = system.getMedicineCatalog().createMedicine();
        medicine.setName(((ClinicWorkRequest) request).getDrug().getName());
        medicine.setDrug(((ClinicWorkRequest) request).getDrug());
        medicine.setQuantity(ran.nextInt(1000));
        medicine.setForm(Medicine.Form.values()[ran.nextInt(4)]);
        medicine.setUnitPrice(ran.nextInt(1000));

        populateTable();
    }//GEN-LAST:event_btnFinalApprovalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinalApproval;
    private javax.swing.JButton btnMessageToAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblWorkQueue;
    private javax.swing.JTextField txtMessageField;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkQueue.getModel();

        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkQueue()) {
            Object[] row = new Object[5];
            if (request instanceof DrugWorkRequest) {
                row[0] = ((DrugWorkRequest) request).getDrug();
            } else if (request instanceof ClinicWorkRequest)
            row[0] = ((ClinicWorkRequest) request).getDrug();
            row[1] = request.getSender() == null ? null : request.getSender();
            row[2] = request.getReceiver() == null ? null : request.getReceiver();
            row[3] = request.getStatus();
            row[4] = request;

            model.addRow(row);
        }
    }
}