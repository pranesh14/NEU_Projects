/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.Patient.Findings;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClinicWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class DoctorsFindingsJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public UserAccount account;
    public Patient patient;
    public ClinicWorkRequest request;

    /**
     * Creates new form DoctorsFindings
     */
    public DoctorsFindingsJPanel(ClinicWorkRequest request, UserAccount account, JPanel userProcessContainer, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.patient = patient;
        this.request = (ClinicWorkRequest) request;
        populateData();
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
        cmbPhase1 = new javax.swing.JComboBox<>();
        cmbPhase2 = new javax.swing.JComboBox<>();
        cmbPhase3 = new javax.swing.JComboBox<>();
        cmbPhase4 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReportToRep = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPhase2 = new javax.swing.JTextField();
        txtPhase1 = new javax.swing.JTextField();
        txtPhase3 = new javax.swing.JTextField();
        txtPhase4 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Study  Records");

        cmbPhase1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cmbPhase1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Success", "Failure" }));

        cmbPhase2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cmbPhase2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Success", "Failure" }));

        cmbPhase3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cmbPhase3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Success", "Failure" }));

        cmbPhase4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cmbPhase4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Success", "Failure" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Phase 1:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Phase 2:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Phase 3:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Phase 4:");

        btnReportToRep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnReportToRep.setText("Report To Rep");
        btnReportToRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportToRepActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtPhase2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        txtPhase1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        txtPhase3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        txtPhase4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cmbPhase1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPhase1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbPhase2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPhase2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbPhase3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPhase3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbPhase4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(txtPhase4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(125, 125, 125)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReportToRep)))))
                .addContainerGap(576, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPhase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPhase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPhase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbPhase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave)
                    .addComponent(btnReportToRep))
                .addContainerGap(311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        patient.getFindingsList().get(0).setMessage(txtPhase1.getText());
        if (cmbPhase1.getSelectedItem().equals("Success")) {
            patient.getFindingsList().get(0).setStatus(Findings.Status.Success);
        } else if (cmbPhase1.getSelectedItem().equals("Failure")) {
            patient.getFindingsList().get(0).setStatus(Findings.Status.Failure);
        } else if (cmbPhase1.getSelectedItem().equals("Not Started")) {
            patient.getFindingsList().get(0).setStatus(Findings.Status.NotStarted);
        }

        patient.getFindingsList().get(1).setMessage(txtPhase2.getText());
        if (cmbPhase2.getSelectedItem().equals("Success")) {
            patient.getFindingsList().get(1).setStatus(Findings.Status.Success);
        } else if (cmbPhase2.getSelectedItem().equals("Failure")) {
            patient.getFindingsList().get(1).setStatus(Findings.Status.Failure);
        } else if (cmbPhase2.getSelectedItem().equals("Not Started")) {
            patient.getFindingsList().get(1).setStatus(Findings.Status.NotStarted);
        }

        patient.getFindingsList().get(2).setMessage(txtPhase3.getText());
        if (cmbPhase3.getSelectedItem().equals("Success")) {
            patient.getFindingsList().get(2).setStatus(Findings.Status.Success);
        } else if (cmbPhase3.getSelectedItem().equals("Failure")) {
            patient.getFindingsList().get(2).setStatus(Findings.Status.Failure);
        } else if (cmbPhase3.getSelectedItem().equals("Not Started")) {
            patient.getFindingsList().get(2).setStatus(Findings.Status.NotStarted);
        }

        patient.getFindingsList().get(3).setMessage(txtPhase4.getText());
        if (cmbPhase4.getSelectedItem().equals("Success")) {
            patient.getFindingsList().get(3).setStatus(Findings.Status.Success);
        } else if (cmbPhase4.getSelectedItem().equals("Failure")) {
            patient.getFindingsList().get(3).setStatus(Findings.Status.Failure);
        } else if (cmbPhase4.getSelectedItem().equals("Not Started")) {
            patient.getFindingsList().get(3).setStatus(Findings.Status.NotStarted);
        }
        JOptionPane.showMessageDialog(null, "The data has been saved", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReportToRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportToRepActionPerformed
        if(cmbPhase1.getSelectedItem().equals("Success") && cmbPhase2.getSelectedItem().equals("Success") && cmbPhase3.getSelectedItem().equals("Success") && cmbPhase4.getSelectedItem().equals("Success"))
            request.setStatus(WorkRequest.Status.TRIALOVERSUCCESS);
        else
            request.setStatus(WorkRequest.Status.TRIALOVERFAILURE);
        
        JOptionPane.showMessageDialog(null, "The trial has been completed", "Information", JOptionPane.INFORMATION_MESSAGE);
        txtPhase2.setText("");
        txtPhase1.setText("");
        txtPhase3.setText("");
        txtPhase4.setText("");
    }//GEN-LAST:event_btnReportToRepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReportToRep;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbPhase1;
    private javax.swing.JComboBox<String> cmbPhase2;
    private javax.swing.JComboBox<String> cmbPhase3;
    private javax.swing.JComboBox<String> cmbPhase4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtPhase1;
    private javax.swing.JTextField txtPhase2;
    private javax.swing.JTextField txtPhase3;
    private javax.swing.JTextField txtPhase4;
    // End of variables declaration//GEN-END:variables

    private void populateData() {
        for(int i =0; i<4;i++){
        if((patient.getFindingsList().get(i).getStatus() == Findings.Status.Failure) || (patient.getFindingsList().get(i).getStatus() == Findings.Status.NotStarted) || (patient.getFindingsList().get(i).getStatus() == Findings.Status.Success))
            if(i==0){
                txtPhase1.setText(patient.getFindingsList().get(i).getMessage());
                if(null != patient.getFindingsList().get(i).getStatus())
                    switch (patient.getFindingsList().get(i).getStatus()) {
                        case NotStarted:
                            cmbPhase2.setSelectedItem("Not Started");
                            break;
                        case Success:
                            cmbPhase2.setSelectedItem("Success");
                            break;
                        case Failure:
                            cmbPhase2.setSelectedItem("Failure");
                            break;
                        default:
                            break;
                    }
            }
            if(i==1){
                txtPhase2.setText(patient.getFindingsList().get(i).getMessage());
                if(null != patient.getFindingsList().get(i).getStatus())
                    switch (patient.getFindingsList().get(i).getStatus()) {
                        case NotStarted:
                            cmbPhase2.setSelectedItem("Not Started");
                            break;
                        case Success:
                            cmbPhase2.setSelectedItem("Success");
                            break;
                        case Failure:
                            cmbPhase2.setSelectedItem("Failure");
                            break;
                        default:
                            break;
                    }
            }
            if(i==2){
                txtPhase3.setText(patient.getFindingsList().get(i).getMessage());
                if(null != patient.getFindingsList().get(i).getStatus())
                    switch (patient.getFindingsList().get(i).getStatus()) {
                        case NotStarted:
                            cmbPhase3.setSelectedItem("Not Started");
                            break;
                        case Success:
                            cmbPhase3.setSelectedItem("Success");
                            break;
                        case Failure:
                            cmbPhase3.setSelectedItem("Failure");
                            break;
                        default:
                            break;
                    }
            }
            if(i==3){
                txtPhase4.setText(patient.getFindingsList().get(i).getMessage());
                if(null != patient.getFindingsList().get(i).getStatus())
                    switch (patient.getFindingsList().get(i).getStatus()) {
                        case NotStarted:
                            cmbPhase4.setSelectedItem("Not Started");
                            break;
                        case Success:
                            cmbPhase4.setSelectedItem("Success");
                            break;
                        case Failure:
                            cmbPhase4.setSelectedItem("Failure");
                            break;
                        default:
                            break;
                    }
            }
        }
    }
}