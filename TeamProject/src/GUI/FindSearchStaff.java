/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.controller;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sajawal
 */
public class FindSearchStaff extends javax.swing.JFrame {

    /**
     * Creates new form FindSearchStaff
     */
    public FindSearchStaff() {
        initComponents();
    } //displaySomeStaff(String jobTitle)
    public void fetchAllStaff() {
        staffTable.setModel(DbUtils.resultSetToTableModel(controller.displayAllStaff())); // this line displays the mysql database into a GUI
    }
    public void fetchSomeStaff() {
    String jobRole = "";
         if (om.isSelected()){
            jobRole = "Office Manager";
        }else if (sm.isSelected()){
            jobRole = "Shift Manager";
        }else if (t.isSelected()){
            jobRole = "Technician";
        }else if (r.isSelected()){
            jobRole = "Receptionist";
        }
        staffTable.setModel(DbUtils.resultSetToTableModel(controller.displaySomeStaff(jobRole))); // this line displays the mysql database into a GUI
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JobsLabel = new javax.swing.JLabel();
        BAPERS = new javax.swing.JLabel();
        FindJobLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        ViewJobButton = new javax.swing.JButton();
        FindJobLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        om = new javax.swing.JRadioButton();
        sm = new javax.swing.JRadioButton();
        r = new javax.swing.JRadioButton();
        t = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JobsLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        JobsLabel.setText("Staffs");

        BAPERS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BAPERS.setText("BAPERS");

        FindJobLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        FindJobLabel.setText("Find and search Staff accounts");

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID  ", "First Name", "Surname", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(staffTable);

        ViewJobButton.setBackground(new java.awt.Color(204, 255, 255));
        ViewJobButton.setText("View All Staff Accounts ");
        ViewJobButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewJobButtonActionPerformed(evt);
            }
        });

        FindJobLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FindJobLabel1.setText("Display All:");

        searchButton.setBackground(new java.awt.Color(204, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(om);
        om.setText("Office Managers");

        buttonGroup1.add(sm);
        sm.setSelected(true);
        sm.setText("Shift Managers");

        buttonGroup1.add(r);
        r.setText("Receptionists");

        buttonGroup1.add(t);
        t.setText("Technicians");

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(FindJobLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(om)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(r)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BAPERS)
                        .addGap(20, 20, 20)
                        .addComponent(JobsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FindJobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewJobButton)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAPERS)
                    .addComponent(JobsLabel)
                    .addComponent(FindJobLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FindJobLabel1)
                    .addComponent(searchButton)
                    .addComponent(om)
                    .addComponent(sm)
                    .addComponent(r)
                    .addComponent(t))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewJobButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewJobButtonActionPerformed
        // TODO add your handling code here:
        fetchAllStaff();
      
    }//GEN-LAST:event_ViewJobButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        fetchSomeStaff();
       
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        StaffAccountNavGUI v = new StaffAccountNavGUI();
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FindSearchStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindSearchStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindSearchStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindSearchStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindSearchStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BAPERS;
    private javax.swing.JLabel FindJobLabel;
    private javax.swing.JLabel FindJobLabel1;
    private javax.swing.JLabel JobsLabel;
    private javax.swing.JButton ViewJobButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton om;
    private javax.swing.JRadioButton r;
    private javax.swing.JButton searchButton;
    private javax.swing.JRadioButton sm;
    private javax.swing.JTable staffTable;
    private javax.swing.JRadioButton t;
    // End of variables declaration//GEN-END:variables
}