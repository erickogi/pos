/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteration_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kimani kogi
 */
public class changepassuser extends javax.swing.JFrame {

    /**
     * Creates new form changepass
     */
    public changepassuser() {
        initComponents();
    }
public Connection getConnection()

   {

       Connection con;

       try {

           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

           return con;

       } catch (Exception e) {

           e.printStackTrace();

           return null;

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        oldpassword = new javax.swing.JTextField();
        newpassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        confirmpassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 51, 255));

        jLabel1.setText("enter old password");

        jLabel2.setText("enter new password");

        jLabel3.setText("confirm password");

        jLabel4.setText("user name is user");

        change.setText("change");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        jLabel5.setText("change user password");

        jButton1.setText("change admin password");
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
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newpassword)
                            .addComponent(oldpassword)
                            .addComponent(confirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(change)
                        .addGap(55, 55, 55)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmpassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        String stru="";
        stru=oldpassword.getText();
        
        String strp="";
        strp=newpassword.getText();
        
         String strc="";
        strc=confirmpassword.getText();
        if (stru.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter Password");
         return;
        }
        
        if (strp.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter Password");
         return;
        }
        if (strc.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter Password");
         return;
        }
        try
        {
            //get database connection details
           
            
             //open connection
            Connection connection;
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");
            String str="";
            //String str1="";
            str="select * from lib_user where  user_password =?";
            //str1="select * from lib_user where  user_password =?";
           PreparedStatement pst=connection.prepareStatement(str);
           //PreparedStatement pst1=connection.prepareStatement(str1);
           pst.setString(1, stru);
           //pst1.setString(1, stru);
          // pst.setString(2, strp);
           ResultSet rs;
          // ResultSet rs1;
           rs=pst.executeQuery();
          // rs1=pst1.executeQuery();
           if (rs.next())
               
           {
               try
        {
        //Connection connection;
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");  

            String sql = "UPDATE lib_user SET user_password ='"+confirmpassword.getText()+"'WHERE user_name='user'  ";
            //String sql1 = "UPDATE lib_user SET user_password='"+confirmpassword.getText()+"'WHERE user_name='admin'  ";
            //PreparedStatement pst=connection.prepareStatement(sql);
            pst.executeUpdate(sql);
            //pst1.executeUpdate(sql1);
        }
            catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    
            
              // MainClass.StrUser=TxtUserName.getText();
               sellform m=new sellform();
               m.setVisible(true);
               this.setVisible(false);
               
           }
           else
           {
                JOptionPane.showMessageDialog(null,"User name or password are not correct.");
                return;
            }
           

        }
        catch (Exception e)
        {
            System.err.println(e);
            System.exit(1);
        }
        
        
                          
    }//GEN-LAST:event_changeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        changepass m=new changepass();
               m.setVisible(true);
               this.setVisible(false);
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
            java.util.logging.Logger.getLogger(changepassuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepassuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepassuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepassuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepassuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change;
    private javax.swing.JTextField confirmpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField newpassword;
    private javax.swing.JTextField oldpassword;
    // End of variables declaration//GEN-END:variables
}
