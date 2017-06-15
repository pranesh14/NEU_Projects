/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Organization;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClinicWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph antony
 */
public class ClinicalOrgAdminWorkQueueJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Organization organization;
    Enterprise enterprise;
    UserAccount userAccount;
    Ecosystem business;

    /**
     * Creates new form ScientistWorkArea
     */
    public ClinicalOrgAdminWorkQueueJPanel(JPanel userProcessContainer, Organization organization, Enterprise enterprise, UserAccount userAccount, Ecosystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        for (WorkRequest request : organization.getWorkQueue().getWorkQueue()) {
            if (request.getStatus() == WorkRequest.Status.TOTESTCENTER) {
                request.setReceiver(userAccount);
            }
        }
        for (WorkRequest request : organization.getWorkQueue().getWorkQueue()) {
            if (request.getStatus() == WorkRequest.Status.APPROVED) {
                request.setReceiver(userAccount);
            }
        }
        populateWorkQueueTable();
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkQueue.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkQueue()) {
            Object[] row = new Object[5];
            row[0] = ((ClinicWorkRequest) request).getDrug();
            row[1] = request.getSender() == null ? null : request.getSender().getEmployee();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee();
            row[3] = request.getStatus();
            row[4] = request;
            model.addRow(row);
        }
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
        btnMessageToRep = new javax.swing.JButton();
        txtMessageField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnMessageToAdmin = new javax.swing.JButton();
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblWorkQueue);
        if (tblWorkQueue.getColumnModel().getColumnCount() > 0) {
            tblWorkQueue.getColumnModel().getColumn(0).setResizable(false);
            tblWorkQueue.getColumnModel().getColumn(1).setResizable(false);
            tblWorkQueue.getColumnModel().getColumn(2).setResizable(false);
            tblWorkQueue.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Clinical Organization Admin Work Queue");

        btnMessageToRep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMessageToRep.setText("Message To Rep");
        btnMessageToRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageToRepActionPerformed(evt);
            }
        });

        txtMessageField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Message :");

        btnMessageToAdmin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMessageToAdmin.setText("Message To Admin");
        btnMessageToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageToAdminActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMessageToAdmin)
                                        .addComponent(jLabel2))
                                    .addGap(107, 107, 107)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMessageField)
                                        .addComponent(btnMessageToRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(559, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(109, 109, 109)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMessageToRep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessageToAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(267, 267, 267))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMessageToRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageToRepActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblWorkQueue.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        if (txtMessageField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Message required!!");
            return;
        }
        WorkRequest request = (WorkRequest) tblWorkQueue.getValueAt(selectedRow, 4);
        if (request.getStatus() == WorkRequest.Status.TOTESTCENTER) {
            request.setSender(userAccount);
            request.setReceiver(null);
            request.setStatus(WorkRequest.Status.INPROCESS);
            request.setMessage(txtMessageField.getText());
            populateWorkQueueTable();
            JOptionPane.showMessageDialog(null, "Request sent to Representative");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid selection");
        }
        txtMessageField.setText("");


    }//GEN-LAST:event_btnMessageToRepActionPerformed

    private void btnMessageToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageToAdminActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblWorkQueue.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        if (txtMessageField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Message required!!");
            return;
        }

        WorkRequest request = (WorkRequest) tblWorkQueue.getValueAt(selectedRow, 4);
        if (request.getStatus() == WorkRequest.Status.APPROVED) {
            request.setSender(userAccount);
            request.setReceiver(null);
            request.setStatus(WorkRequest.Status.ORGANIZATION3ADMINAPPROVED);
            request.setMessage(txtMessageField.getText());

            populateWorkQueueTable();
            JOptionPane.showMessageDialog(null, "Request sent to Clinical Enterprise Admin");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid selection");
        }

    }//GEN-LAST:event_btnMessageToAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMessageToAdmin;
    private javax.swing.JButton btnMessageToRep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblWorkQueue;
    private javax.swing.JTextField txtMessageField;
    // End of variables declaration//GEN-END:variables
}
