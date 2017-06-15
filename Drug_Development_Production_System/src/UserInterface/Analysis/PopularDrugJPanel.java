/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Analysis;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.WorkQueue.PurchaseOrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author joseph antony
 */
public class PopularDrugJPanel extends javax.swing.JPanel {

    public JPanel userProcessContainer;
    public Ecosystem system;
    public Network network;
    public Enterprise enterprise;
    /**
     * Creates new form PopularDrug
     */

    public PopularDrugJPanel(JPanel userProcessContainer, Ecosystem system, Network network, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.network = network;
        this.enterprise = enterprise;
        createChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(503, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void createChart() {
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        if(system == null && enterprise == null){
            for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
                if(ent.getFunction().equals("Production"))
                    for(WorkRequest request: ent.getWorkQueue().getWorkQueue()){
                        barchartdata.setValue(((PurchaseOrderWorkRequest)request).getMedicineCount(), "Quantity ordered", ((PurchaseOrderWorkRequest)request).getMedicine().getName());
                    }
            }
        }
        else if(network == null && enterprise == null){
            for(Network net: system.getNetworkList()){
                for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
                    if(ent.getFunction().equals("Production"))
                        for(WorkRequest request: ent.getWorkQueue().getWorkQueue()){
                            barchartdata.setValue(((PurchaseOrderWorkRequest)request).getMedicineCount(), "Quantity ordered", ((PurchaseOrderWorkRequest)request).getMedicine().getName());
                        }
                }
            }
        }
        else{
            for(WorkRequest request: enterprise.getWorkQueue().getWorkQueue()){
                barchartdata.setValue(((PurchaseOrderWorkRequest)request).getMedicineCount(), "Quantity ordered", ((PurchaseOrderWorkRequest)request).getMedicine().getName());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("Popular Drugs","Medicine","Quantity ordered",barchartdata);
        ChartPanel barPanel = new ChartPanel(barChart);
        
        dashboardPanel.removeAll();
        dashboardPanel.setLayout(new java.awt.BorderLayout());
        dashboardPanel.add(barPanel, BorderLayout.CENTER);
        dashboardPanel.validate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel dashboardPanel;
    // End of variables declaration//GEN-END:variables
}
