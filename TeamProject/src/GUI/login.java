/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Staff;
import controller.controller;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sajawal
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        //this.setUndecorated(true); // removes the top bar
        initComponents();
//        Toolkit tk = Toolkit.getDefaultToolkit(); // make screen full size
//        int x = (int) tk.getScreenSize().getWidth();
//        int y = (int) tk.getScreenSize().getHeight();
//        this.setSize(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BAPERS = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BAPERS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BAPERS.setText("BAPERS");

        Login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Login.setText("Login");

        Welcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Welcome.setText("Welcome");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Forgot your Password?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(204, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        close.setBackground(new java.awt.Color(204, 255, 255));
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Welcome)
                                            .addComponent(Login)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1)
                                            .addComponent(usernameText)
                                            .addComponent(jLabel2)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BAPERS)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BAPERS)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Welcome)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(close)
                            .addComponent(login))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
 boolean outcome;
 boolean isEmpty = false;
 if(usernameText.getText().equals("") || passwordText.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Please can you enter username and password",  "WRONG ", JOptionPane.WARNING_MESSAGE);
        isEmpty = true;
}else {
    isEmpty = false;
}
outcome = controller.login(usernameText.getText(), passwordText.getText());
if (outcome == true ){
   this.dispose();
   Staff st = controller.getSt();
   if(st.getJobTitle().equals("Office Manager") ){
       controller.openOfficeMgrHome();//opens the home page for office manager
       controller.newJobAlert(); //this is display any new job alert
       controller.jobDeadlineAlert();//this is a deadline alert
       controller.taskpirporAlert();//this is a task piroirty changed alert
       controller.remindersDebtors(); //this sends the email to the customers who have missed the payment deadline   
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   } else if(st.getJobTitle().equals("Shift Manager")){
       controller.openShiftMgrHome();
       controller.newJobAlert(); //this will display any new job alert
       controller.jobDeadlineAlert();//this is a deadline alert
       controller.taskpirporAlert();//this is a task piroirty changed alert
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }else if(st.getJobTitle().equals("Development Technician")){ 
       controller.openTechnicianHome();
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }else if(st.getJobTitle().equals("CopyRoom Technician")){
       controller.openTechnicianHome();
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }else if(st.getJobTitle().equals("PackingRoom Technician")){
       controller.openTechnicianHome();
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }else if(st.getJobTitle().equals("FinishingRoom Technician")){
       controller.openTechnicianHome();
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }else if(st.getJobTitle().equals("Receptionist")){
       controller.openRepHome();
       controller.newJobAlert(); //this is display any new job alert
       
       
       
       try { //this does the automactic backup
           controller.BackupAutomatic();
       } catch (ParseException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
} else if ( isEmpty == false ){
    JOptionPane.showMessageDialog(null, "Try Again, Username or Password Incorrect",  "WRONG Login information", JOptionPane.WARNING_MESSAGE);
    usernameText.setText("");
    passwordText.setText("");
    
}   
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
    forgotPassword fp = new forgotPassword();
    fp.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
 System.exit(1);        // TODO add your handling code here:
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BAPERS;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Welcome;
    private javax.swing.JButton close;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
