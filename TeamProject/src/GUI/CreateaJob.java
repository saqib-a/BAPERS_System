/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Staff;
import controller.controller;
import javax.swing.JOptionPane;
import java.text.*; //this is used to convert string into date
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sajawal
 */
public class CreateaJob extends javax.swing.JFrame {

    /**
     * Creates new form CreateaJob
     */
    public CreateaJob() {
        initComponents();
    }
    public void fetchAllTasks() {
        taskTable.setModel(DbUtils.resultSetToTableModel(controller.displayAllTask())); // this line displays the mysql database into a GUI
    }
    public void fetchAllTasksForJob() {
        jobHasTask.setModel(DbUtils.resultSetToTableModel(controller.displayAllTasksForJob(jobID.getText()))); // this line displays the mysql database into a GUI
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
        BAPERS = new javax.swing.JLabel();
        JobsLabel = new javax.swing.JLabel();
        CreateaJobLabel = new javax.swing.JLabel();
        DetailsLABEL1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CustAcctNo = new javax.swing.JTextField();
        jobID = new javax.swing.JTextField();
        datetxt = new javax.swing.JTextField();
        paymentDue = new javax.swing.JTextField();
        urgyes = new javax.swing.JRadioButton();
        urgno = new javax.swing.JRadioButton();
        specialInst = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jobHasTask = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        AddTaskButton = new javax.swing.JButton();
        RemoveTaskButton = new javax.swing.JButton();
        Task1Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        taskID = new javax.swing.JTextField();
        updateJob = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        StaffID = new javax.swing.JTextField();
        fullName = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        vu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BAPERS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BAPERS.setText("BAPERS");

        JobsLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        JobsLabel.setText("Jobs");

        CreateaJobLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        CreateaJobLabel.setText("Create a Job");

        DetailsLABEL1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DetailsLABEL1.setText("Special Instructions");

        jLabel1.setText("Customer Account No");

        jLabel2.setText("JobID ");

        jLabel3.setText("Payment Due");

        jLabel4.setText("Date");

        jLabel5.setText("Urgent Job");

        CustAcctNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustAcctNoActionPerformed(evt);
            }
        });

        jobID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobIDActionPerformed(evt);
            }
        });

        buttonGroup1.add(urgyes);
        urgyes.setText("YES");

        buttonGroup1.add(urgno);
        urgno.setSelected(true);
        urgno.setText("NO");
        urgno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urgnoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Create Job");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setText("Update Job");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jobHasTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jobHasTask);

        jLabel6.setText("Job information");

        AddTaskButton.setBackground(new java.awt.Color(204, 255, 255));
        AddTaskButton.setText("Add Task");
        AddTaskButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddTaskButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AddTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTaskButtonActionPerformed(evt);
            }
        });

        RemoveTaskButton.setBackground(new java.awt.Color(204, 255, 255));
        RemoveTaskButton.setText("Remove");
        RemoveTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTaskButtonActionPerformed(evt);
            }
        });

        Task1Label.setText("Enter the Task ID for the task you would like to add");

        jLabel7.setText("All Tasks");

        updateJob.setBackground(new java.awt.Color(204, 255, 255));
        updateJob.setText("Update Job Table");
        updateJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJobActionPerformed(evt);
            }
        });

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "taskId ", "location  ", "shelfslot ", "price ", "duration ", "taskDescription ", "StartTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(taskTable);

        jLabel8.setText("Staff Id of the employee dealing with this task");

        jLabel9.setText("Employees Full name");

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setText("Set Task Priority");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(vu);
        vu.setText("Super Urgent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(DetailsLABEL1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(CustAcctNo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(49, 49, 49))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(14, 14, 14))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(urgyes)
                                            .addGap(18, 18, 18)
                                            .addComponent(urgno))
                                        .addComponent(vu))
                                    .addComponent(paymentDue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addComponent(specialInst, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BAPERS)
                        .addGap(682, 682, 682)
                        .addComponent(JobsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateaJobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(197, 197, 197))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateJob)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Task1Label)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(StaffID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taskID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoveTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAPERS)
                    .addComponent(JobsLabel)
                    .addComponent(CreateaJobLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CustAcctNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jobID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(paymentDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(urgyes)
                                    .addComponent(urgno)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DetailsLABEL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specialInst, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(59, 59, 59)
                                .addComponent(jButton1)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Task1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RemoveTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateJob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobIDActionPerformed

    private void urgnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urgnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urgnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String urgentJob = "";
        if (urgyes.isSelected()) {
            urgentJob = "YES";
        } else if (urgno.isSelected()) {
            urgentJob = "NO";
        }else if (vu.isSelected()) {
            urgentJob = "VU"; //this means very urgent
        }
        
        if (jobID.getText().equals("") || CustAcctNo.getText().equals("") || specialInst.getText().equals("") || datetxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please input some values", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else { 
            
        float amount_due = Float.parseFloat(paymentDue.getText());

        boolean outcome = controller.addJob(jobID.getText(), amount_due, urgentJob, CustAcctNo.getText(), specialInst.getText(), datetxt.getText());
        
            if (outcome == true) {
            JOptionPane.showMessageDialog(null, "New Job Added ", "Job Added", JOptionPane.INFORMATION_MESSAGE);

        } 
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Jobs v = new Jobs();
        v.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String urgentJob = "";
        if (urgyes.isSelected()) {
            urgentJob = "YES";
        } else if (urgno.isSelected()) {
            urgentJob = "NO";
        }
        
        if (jobID.getText().equals("") || CustAcctNo.getText().equals("") || specialInst.getText().equals("") || datetxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please input some values", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else { 
            float amount_due = Float.parseFloat(paymentDue.getText());
            boolean outcome = controller.updateJob(jobID.getText(), amount_due, urgentJob, CustAcctNo.getText(), specialInst.getText(), datetxt.getText());
            
            if(outcome == true) {
            JOptionPane.showMessageDialog(null, "Job information updated ", "Job Updated", JOptionPane.INFORMATION_MESSAGE);
        } 
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CustAcctNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustAcctNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustAcctNoActionPerformed

    private void updateJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJobActionPerformed
        // TODO add your handling code here:
        if(jobID.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Please input some values", "Empty!!!", JOptionPane.WARNING_MESSAGE);
        }else{
        fetchAllTasksForJob();
        }
        
    }//GEN-LAST:event_updateJobActionPerformed

    private void AddTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTaskButtonActionPerformed
        // TODO add your handling code here:
        //addTAsking
         boolean outcome = controller.addTAsking(jobID.getText(), taskID.getText(), fullName.getText(), StaffID.getText());

        if (outcome == true) {
            JOptionPane.showMessageDialog(null, "Task Added to the job", "Updated", JOptionPane.INFORMATION_MESSAGE);
            fetchAllTasksForJob();

        } else {
            JOptionPane.showMessageDialog(null, "Problems adding task to job", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
       
    }//GEN-LAST:event_AddTaskButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TaskPriority v = new TaskPriority();
        v.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void RemoveTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTaskButtonActionPerformed
        // TODO add your handling code here:
        boolean outcome = controller.removeTasking(jobID.getText(), taskID.getText());

        if (outcome == true) {
            JOptionPane.showMessageDialog(null, "Task Removed From the job", "Updated", JOptionPane.INFORMATION_MESSAGE);
            fetchAllTasksForJob();

        } else {
            JOptionPane.showMessageDialog(null, "Problems adding task to job", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_RemoveTaskButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreateaJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateaJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateaJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateaJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateaJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTaskButton;
    private javax.swing.JLabel BAPERS;
    private javax.swing.JLabel CreateaJobLabel;
    private javax.swing.JTextField CustAcctNo;
    private javax.swing.JLabel DetailsLABEL1;
    private javax.swing.JLabel JobsLabel;
    private javax.swing.JButton RemoveTaskButton;
    private javax.swing.JTextField StaffID;
    private javax.swing.JLabel Task1Label;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField datetxt;
    private javax.swing.JTextField fullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jobHasTask;
    private javax.swing.JTextField jobID;
    private javax.swing.JTextField paymentDue;
    private javax.swing.JTextField specialInst;
    private javax.swing.JTextField taskID;
    private javax.swing.JTable taskTable;
    private javax.swing.JButton updateJob;
    private javax.swing.JRadioButton urgno;
    private javax.swing.JRadioButton urgyes;
    private javax.swing.JRadioButton vu;
    // End of variables declaration//GEN-END:variables
}
