package iteration_one;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Transupdate extends javax.swing.JFrame {
   DefaultTableModel model = new DefaultTableModel();
   
    public Transupdate() {

       this.table = new JTable(model);
        this.jtFilter= new JTextField();
         final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
       table.setRowSorter(rowSorter);
          jtFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
           @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
            initComponents();
//             quantity.addActionListener(new ActionListener() {
//
//           @Override
//           public void actionPerformed(ActionEvent e) {
//                Connection connection = getConnection();
//
//
//
//       String query1 = "SELECT * FROM users WHERE (fname) = '"+productname.getText();
//       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())
//
//       Statement st1;
//
//
//       ResultSet rs1;
//                try
//            {
//                 st1 = connection.createStatement();
//
//           rs1 = st1.executeQuery(query1);
//           int a;
//           a=rs1.getInt(query1);
//            int tps=Integer.valueOf(quantity.getText());
//         int  p=(tps*a);
////price=Integer.toString(p);
//  price.setText(Integer.toString(p));
//               // Connection connection;
//              //  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","");
//
//                //String sql = "INSERT INTO `trans`( `fname`, `lname`,`updated_at`, `age`) VALUES ('"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
//                //PreparedStatement pst=connection.prepareStatement(sql);
//                //pst.executeUpdate(sql);
//            }
//                 catch (Exception a) {
//                System.err.println(a);
//                System.exit(1);
//            }
//               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//           }
//             });
//            table.addActionListener(new ActionListener() {
//
//           @Override
//           public void actionPerformed(ActionEvent e) {
//
//           }

//
//            });
           
            // Calender calender=Calender.getInstance();
//Jcart=jcartarea.getText();
            //java.sql.Date currentTimestamp=new
            //java.sql.Timestamp(calender.getInstance().getTime().getTime());

          
          
            
        }
    public ArrayList<User_2> getUsersList1()

   {

       ArrayList<User_2> usersList1 = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query1 = "SELECT * FROM trans WHERE DATE(updated_at) = DATE(NOW())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st1;


       ResultSet rs1;



       try {
           st1 = connection.createStatement();

           rs1 = st1.executeQuery(query1);

           User_2 user;

           while(rs1.next())

           {

               user = new User_2(rs1.getInt("id"),rs1.getString("fname"),rs1.getString("lname"),rs1.getInt("age"),rs1.getString("updated_at"));

               usersList1.add(user);

           }

       } catch (Exception e) {
       }

       return usersList1;

   }
      public void Show_Users_In_JTable1()

   {

       ArrayList<User_2> list1 = getUsersList1();

       DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id"});
       Object[] row = new Object[5];

       for(int i = 0; i < list1.size(); i++)

       {

           row[0] = list1.get(i).getUpdated_at();

           row[1] = list1.get(i).getFname();

           row[2] = list1.get(i).getLname();

           row[3] = list1.get(i).getAge();
           row[4] = list1.get(i).getId();



           model.addRow(row);

       }

    }
         public ArrayList<User_2> getUsersList2()

   {

       ArrayList<User_2> usersList2 = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query2 = "SELECT * FROM trans WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st2;


       ResultSet rs2;



       try {
           st2 = connection.createStatement();

           rs2 = st2.executeQuery(query2);

           User_2 user;

           while(rs2.next())

           {

               user = new User_2(rs2.getInt("id"),rs2.getString("fname"),rs2.getString("lname"),rs2.getInt("age"),rs2.getString("updated_at"));

               usersList2.add(user);

           }

       } catch (Exception e) {
       }

       return usersList2;

   }
          public void Show_Users_In_JTable2()

   {

       ArrayList<User_2> list2 = getUsersList2();

       DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id"});
       Object[] row = new Object[5];

       for(int i = 0; i < list2.size(); i++)

       {

           row[0] = list2.get(i).getUpdated_at();

           row[1] = list2.get(i).getFname();

           row[2] = list2.get(i).getLname();

           row[3] = list2.get(i).getAge();
           row[4] = list2.get(i).getId();



           model.addRow(row);

       }

    }
  public Connection getConnection()
    {
        Connection con = null;


        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return con;
    }
    public ArrayList<User_2> ListUsers(String ValToSearch)
    {
        ArrayList<User_2> usersList = new ArrayList<User_2>();

        Statement st;
        ResultSet rs;

        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `trans` WHERE CONCAT(`id`, `fname`, `lname`, `age`,`updated_at`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);

            User_2 user;

            while(rs.next())
            {
                user = new User_2(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getInt("age"),
                        rs.getString ("updated_at")
                                );
                usersList.add(user);
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return usersList;
    }
     public void findUsers()
    {

        ArrayList<User_2> users = ListUsers(jtFilter.getText());
        DefaultTableModel model = new DefaultTableModel();


        model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id"});
        Object[] row = new Object[5];

     for(int i = 0; i < users.size(); i++)
        {
             row[0] = users.get(i).getUpdated_at();

           row[1] = users.get(i).getFname();

           row[2] = users.get(i).getLname();

           row[3] = users.get(i).getAge();
           
           row[4] = users.get(i).getId();
           // row[1] = users.get(i).getFname();
           // row[2] = users.get(i).getLname();
            //row[3] = users.get(i).getAge();
            //row[3] = users.get(i).getUpdated_at();
            model.addRow(row);
        }
       table.setModel(model);

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

               DefaultTableModel model = (DefaultTableModel)table.getModel();

               model.setRowCount(0);

               findUsers();



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
        jLabel1 = new javax.swing.JLabel();
        jtFilter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        productnamelbl = new javax.swing.JLabel();
        productidlbl = new javax.swing.JLabel();
        quantitylbl = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        addtocartbtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productname = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        productid = new javax.swing.JEditorPane();
        price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 812));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSACTIONS");

        jtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFilterActionPerformed(evt);
            }
        });
        jtFilter.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jtFilterCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtFilterInputMethodTextChanged(evt);
            }
        });
        jtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilterKeyReleased(evt);
            }
        });

        table.setBackground(new java.awt.Color(51, 153, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5"
            }
        ));
        table.setRowHeight(40);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel2.setText("ENTER PRODUCT NAME,ID ");

        productnamelbl.setText("PRODUCT NAME");

        productidlbl.setText("DATE");

        quantitylbl.setText("QUANTITY");

        pricelbl.setText("PRICE");

        addtocartbtn.setText("DELETE");
        addtocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartbtnActionPerformed(evt);
            }
        });

        resetbtn.setText("UPDATE");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        productname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jScrollPane2.setViewportView(productname);

        productid.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jScrollPane3.setViewportView(productid);

        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TODAY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("THIS WEEK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CALCULATOR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(386, 386, 386))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productnamelbl)
                                    .addComponent(productidlbl)
                                    .addComponent(quantitylbl)
                                    .addComponent(pricelbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(price)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4))
                                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 129, Short.MAX_VALUE)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productnamelbl)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(productidlbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitylbl)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricelbl)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//private void createKeybindings(JTable table) {
//table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke
//(KeyEvent.VK_ENTER, 0), "Enter");
//    table.getActionMap().put("Enter", new
//AbstractAction() {
//        @Override
//        public void actionPerformed
//(ActionEvent ae) {
//            //do something on JTable enter pressed
//     int i = table.getSelectedRow();
//
//        TableModel model = table.getModel();
//
//        // Display Slected Row In JTexteFields
//
//        productid.setText(model.getValueAt(i,0).toString());
//
//        productname.setText(model.getValueAt(i,1).toString());
//
//        quantity1.setText("");
//
//        price.setText(model.getValueAt(i,3).toString());
//
//        }
//    });
//}

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //totalpurchase.setText("0");
        productname.setText(null);
        productid.setText(null);
        quantity.setText(null);
id.setText(null);
         price.setText(null);
       // totalprice.setText(null);
        //jcartarea.setText(null);

       // cashin.setText(null);
        //change.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Show_Users_In_JTable1();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Show_Users_In_JTable2();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void recieptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recieptbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recieptbtnActionPerformed

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_quantity1KeyReleased

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        String query = "UPDATE `trans` SET `fname`='"+productname.getText()+"',`lname`='"+quantity.getText()+"',`age`="+price.getText()+" WHERE `id` = "+id.getText();

       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_resetbtnActionPerformed

    private void addtocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartbtnActionPerformed
         String query = "DELETE FROM `trans` WHERE id = "+id.getText();

         executeSQlQuery(query, "Deleted");
    }//GEN-LAST:event_addtocartbtnActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        //createKeybindings();
    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();

        TableModel model = table.getModel();

        // Display Slected Row In JTexteFields

        productid.setText(model.getValueAt(i,0).toString());

        productname.setText(model.getValueAt(i,1).toString());

        quantity.setText(model.getValueAt(i,2).toString());

        price.setText(model.getValueAt(i,3).toString());
        id.setText(model.getValueAt(i, 4).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void jtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilterKeyReleased
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterKeyReleased

    private void jtFilterInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFilterInputMethodTextChanged

    private void jtFilterCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFilterCaretPositionChanged

    private void jtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilterActionPerformed
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Calc me=new Calc();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        // TODO add your handling code here:
//          Connection connection = getConnection();
//
//
//
//       String query1 = "SELECT 'price' FROM users WHERE 'fname' = "+productname.getText();
//       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())
//
//       Statement st1;
//
//
//       ResultSet rs1;
//                try
//            {
//                 st1 = connection.createStatement();
//
//           rs1 = st1.executeQuery(query1);
//           int a;
//           a=rs1.getInt(query1);
//            int tps=Integer.valueOf(quantity.getText());
//         int  p=(tps*a);
////price=Integer.toString(p);
//  price.setText(Integer.toString(p));
//    }
//                 catch (Exception a) {
//                System.err.println(a);
//                System.exit(1);
//            }
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
             
    }//GEN-LAST:event_quantityKeyReleased

      private void tableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        // TODO add your handling code here:
    }
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
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transupdate().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtocartbtn;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JTextField price;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JEditorPane productid;
    private javax.swing.JLabel productidlbl;
    private javax.swing.JEditorPane productname;
    private javax.swing.JLabel productnamelbl;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel quantitylbl;
    private javax.swing.JButton resetbtn;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
//this.jp.add(lbl);
   // private void executeSQlQuery(String query, String inserted) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    /**
     *
     * @param query
     * @param message
     */
//            public void executeSQlQuery(String query, String message)
//
//   {
//
//       //Connection con = getConnection();
//
//       Statement st;
//       ResultSet rs;
//
//       try{
//            Connection con = getConnection();
//            st = con.createStatement();
//            String queryi = "INSERT INTO `trans`( `fname`, `lname`, `age`) VALUES ('"+productname+"','"+price.getText()+"',"+quantity.getText()+")";
//            //rs = st.executeUpdate(queryi);
//
//           if((st.executeUpdate(queryi)) == 1)
//
//           {
//
//               // refresh jtable data
//
//               //DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
//
//               //model.setRowCount(0);
//
//               //Show_Users_In_JTable();
//
//
//
//               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
//
//           }else{
//
//               JOptionPane.showMessageDialog(null, "Data Not "+message);
//
//           }
//
//       }catch(Exception ex){
//
//           ex.printStackTrace();
//
//       }
//       //String query = "INSERT INTO `trans`( `fname`, `lname`, `age`) VALUES ('"+productname+"','"+price.getText()+"',"+quantity.getText()+")";
//        //executeSQlQuery(query, "Inserted");
//
//   }




}
