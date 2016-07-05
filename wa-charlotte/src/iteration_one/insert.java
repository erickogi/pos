/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteration_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kimani kogi
 */
public class insert extends javax.swing.JFrame {

    /**
     * Creates new form insert
     */
    public insert() {
        initComponents();
        Show_Users_In_JTable();
    }

    /**
     *
     */
   public Connection getConnection()

   {

       Connection con;

       try {

           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","");

           return con;

       } catch (Exception e) {

           e.printStackTrace();

           return null;

       }

   }
    public ArrayList<User_1> getUsersList()

   {

       ArrayList<User_1> usersList = new ArrayList<User_1>();

       Connection connection = getConnection();

       

       String query = "SELECT * FROM  `users` ";

       Statement st;

       ResultSet rs;

       

       try {

           st = connection.createStatement();

           rs = st.executeQuery(query);

           User_1 user;

           while(rs.next())

           {

               user = new User_1(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getInt("age"));

               usersList.add(user);

           }

       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList;

   }
public void Show_Users_In_JTable()

   {

       ArrayList<User_1> list = getUsersList();

       DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list.size(); i++)

       {

           row[0] = list.get(i).getId();

           row[1] = list.get(i).getFname();

           row[2] = list.get(i).getLname();

           row[3] = list.get(i).getAge();

           

           model.addRow(row);

       }

    }
 public void executeSQlQuery(String query, String message)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(query)) == 1)

           {

               // refresh jtable data

               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();

               model.setRowCount(0);

               Show_Users_In_JTable();

               

               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");

           }else{

               JOptionPane.showMessageDialog(null, "Data Not "+message);

           }

       }catch(Exception ex){

           ex.printStackTrace();

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jLabelid = new javax.swing.JLabel();
        jLabelname = new javax.swing.JLabel();
        jLabelquantity = new javax.swing.JLabel();
        jLabelprice = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_name = new javax.swing.JTextField();
        jTextField_quantity = new javax.swing.JTextField();
        jTextField_price = new javax.swing.JTextField();
        jButton_Insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 153));

        jTable_Display_Users.setAutoCreateRowSorter(true);
        jTable_Display_Users.setBackground(new java.awt.Color(51, 153, 255));
        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Display_Users.setIntercellSpacing(new java.awt.Dimension(4, 4));
        jTable_Display_Users.setRowHeight(40);
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

        jLabelid.setText("product id");

        jLabelname.setText("product name");

        jLabelquantity.setText("product quantity");

        jLabelprice.setText("price");

        jTextField_Id.setEditable(false);
        jTextField_Id.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jTextField_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdActionPerformed(evt);
            }
        });

        jTextField_name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jTextField_quantity.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jTextField_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_quantityActionPerformed(evt);
            }
        });

        jTextField_price.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_priceActionPerformed(evt);
            }
        });

        jButton_Insert.setText("INSERT");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setText("DELETE");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("PRODUCT LIST");

        jLabel2.setText("WARCHALLOTE HARDWARE RETAIL SYSTEM");

        back.setText("BACK TO SELL");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(386, 386, 386))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelquantity, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabelprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_quantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jTextField_price, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_name)
                            .addComponent(jTextField_Id)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton_update, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelname, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelprice, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jTextField_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_quantityActionPerformed

    private void jTextField_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_priceActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        // TODO add your handling code here:
          String query = "DELETE FROM `users` WHERE id = "+jTextField_Id.getText();

         executeSQlQuery(query, "Deleted");
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE `users` SET `fname`='"+jTextField_name.getText()+"',`lname`='"+jTextField_quantity.getText()+"',`age`="+jTextField_price.getText()+" WHERE `id` = "+jTextField_Id.getText();

       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        // TODO add your handling code here:
          String query = "INSERT INTO `users`(`fname`, `lname`, `age`) VALUES ('"+jTextField_name.getText()+"','"+jTextField_quantity.getText()+"',"+jTextField_price.getText()+")";

        

        executeSQlQuery(query, "Inserted");
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        // TODO add your handling code here:
          int i = jTable_Display_Users.getSelectedRow();




        TableModel model = jTable_Display_Users.getModel();

        

         // Display Slected Row In JTexteFields

        jTextField_Id.setText(model.getValueAt(i,0).toString());




        jTextField_name.setText(model.getValueAt(i,1).toString());




        jTextField_quantity.setText(model.getValueAt(i,2).toString());




        jTextField_price.setText(model.getValueAt(i,3).toString());

                                                     



    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        sellform m=new sellform();
               m.setVisible(true);
               this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelid;
    private javax.swing.JLabel jLabelname;
    private javax.swing.JLabel jLabelprice;
    private javax.swing.JLabel jLabelquantity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_price;
    private javax.swing.JTextField jTextField_quantity;
    // End of variables declaration//GEN-END:variables
}