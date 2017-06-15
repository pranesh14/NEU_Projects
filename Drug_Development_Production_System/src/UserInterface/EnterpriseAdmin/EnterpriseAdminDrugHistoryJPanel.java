/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseAdmin;

import Business.Compound.Compound;
import Business.Drug.Drug;
import Business.Drug.DrugHistory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph antony
 */
public class EnterpriseAdminDrugHistoryJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public DrugHistory drugHistory;

    /**
     * Creates new form EnterpriseAdminStudyResults
     */
    public EnterpriseAdminDrugHistoryJPanel(JPanel userProcessContainer, DrugHistory drugHistory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.drugHistory = drugHistory;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrugHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDrugComponents = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 153));

        tblDrugHistory.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tblDrugHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Description", "Molecular Formula", "Disease"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDrugHistory);
        if (tblDrugHistory.getColumnModel().getColumnCount() > 0) {
            tblDrugHistory.getColumnModel().getColumn(0).setResizable(false);
            tblDrugHistory.getColumnModel().getColumn(1).setResizable(false);
            tblDrugHistory.getColumnModel().getColumn(2).setResizable(false);
            tblDrugHistory.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Drug History");

        btnDrugComponents.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDrugComponents.setText("Drug Components");
        btnDrugComponents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrugComponentsActionPerformed(evt);
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
                .addGap(301, 301, 301)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDrugComponents)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(93, 93, 93)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btnDrugComponents, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDrugComponentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrugComponentsActionPerformed
        int selectedRow = tblDrugHistory.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a drug to view the compounds in it", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Drug drug = (Drug) tblDrugHistory.getValueAt(selectedRow, 0);
        EnterpriseAdminCompoundDetailsJPanel enterpriseAdminCompoundDetailsJPanel = new EnterpriseAdminCompoundDetailsJPanel(userProcessContainer, drug);
        userProcessContainer.add("enterpriseAdminCompoundDetailsJPanel", enterpriseAdminCompoundDetailsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDrugComponentsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDrugComponents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDrugHistory;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblDrugHistory.getModel();
        model.setRowCount(0);
        for (Drug drug : drugHistory.getDrugHistory()) {
            Object[] row = new Object[4];
            row[0] = drug;
            row[1] = drug.getDescription();
            row[2] = drug.getMolecularFormula();
            for (Compound compound : drug.getCompoundList()) {
                if (compound.isLeadComponent()) {
                    row[3] = compound.getDisease();
                }
            }
            model.addRow(row);
        }
    }
}