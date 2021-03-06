/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Rep;

import Business.Ecosystem;
import Business.Employee.Doctor;
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
public class FindDoctorsJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public UserAccount account;
    public Ecosystem system;
    public ClinicWorkRequest request;

    /**
     * Creates new form LabAssistantWorkArea
     */
    public FindDoctorsJPanel(WorkRequest request, UserAccount account, JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        this.request = (ClinicWorkRequest) request;
        populateDoctors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        btnRequestTest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMessageField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 153));

        tblDoctor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor", "Age", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoctor);
        if (tblDoctor.getColumnModel().getColumnCount() > 0) {
            tblDoctor.getColumnModel().getColumn(0).setResizable(false);
            tblDoctor.getColumnModel().getColumn(2).setResizable(false);
        }

        btnRequestTest.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRequestTest.setText("Request Test");
        btnRequestTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTestActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Find Doctors");

        txtMessageField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Doctor Details :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(btnRequestTest, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1)))
                .addContainerGap(513, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(103, 103, 103)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMessageField)
                    .addComponent(btnRequestTest, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTestActionPerformed
        int selectedRow = tblDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a doctor to send request", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtMessageField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a message to the doctor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserAccount doctor = (UserAccount) tblDoctor.getValueAt(selectedRow, 0);

        request.setMessage(txtMessageField.getText());
        request.setSender(account);
        request.setStatus(WorkRequest.Status.TOTRIALS);
        request.setReceiver(null);

        doctor.getWorkQueue().getWorkQueue().add(request);

        JOptionPane.showMessageDialog(null, "The request has been sent to the doctor", "Information", JOptionPane.INFORMATION_MESSAGE);

        txtMessageField.setText("");
    }//GEN-LAST:event_btnRequestTestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int total = userProcessContainer.getComponentCount();
        RepWorkAreaJPanel manageProductCatalog = (RepWorkAreaJPanel) userProcessContainer.getComponent(total - 2);
        manageProductCatalog.populateWorkQueue();

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JTextField txtMessageField;
    // End of variables declaration//GEN-END:variables

    private void populateDoctors() {
        DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();

        model.setRowCount(0);
        for (UserAccount doctor : system.getDoctorOrganization().getUserAccountDirectory().getUserAccountDirectory()) {
            Object[] row = new Object[3];
            row[0] = doctor;
            row[1] = doctor.getEmployee().getAge();
            Doctor d = (Doctor) doctor.getEmployee();
            row[2] = d.getSex();

            model.addRow(row);

        }
    }

}
