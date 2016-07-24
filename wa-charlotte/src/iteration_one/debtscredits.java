/*
 * Copyright 2016 kimani kogi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package iteration_one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author kimani kogi
 */
public class debtscredits extends javax.swing.JFrame {
 DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form debtscredits
     */
    public debtscredits() {
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
           // initComponents();
     this.table2 = new JTable(model);
        this.jtFilter2= new JTextField();
         final TableRowSorter<TableModel> rowSorter1 = new TableRowSorter<>(table2.getModel());
       table2.setRowSorter(rowSorter); 
          jtFilter2.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtFilter2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
           @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtFilter2.getText();

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
         debtorsname.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               debtorsamount.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
          debtorsamount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              debtorsstatus.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
           creditorname.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               creditoramount.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
          creditoramount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              creditorstatus.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
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
 public ArrayList<User_dc> ListUsers(String ValToSearch)
    {
        ArrayList<User_dc> usersList = new ArrayList<User_dc>();

        Statement st;
        ResultSet rs;

        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `debts` WHERE CONCAT(`id`, `fname`, `lname`, `age`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);

            User_dc user;

            while(rs.next())
            {
                user = new User_dc(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getString("age"),
                                 rs.getString("product")
                                );
                usersList.add(user);
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return usersList;
    }
  public ArrayList<User_dc> ListUsers1(String ValToSearch1)
    {
        ArrayList<User_dc> usersList1 = new ArrayList<User_dc>();

        Statement st1;
        ResultSet rs1;

        try{
            Connection con = getConnection();
            st1 = con.createStatement();
            String searchQuery1 = "SELECT * FROM `credits` WHERE CONCAT(`id`, `fname`, `lname`, `age`) LIKE '%"+ValToSearch1+"%'";
            rs1 = st1.executeQuery(searchQuery1);

            User_dc user;

            while(rs1.next())
            {
                user = new User_dc(
                                 rs1.getInt("id"),
                                 rs1.getString("fname"),
                                 rs1.getString("lname"),
                                 rs1.getString("age"),
                        rs1.getString("product")
                                );
                usersList1.add(user);
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return usersList1;
    }
  public void findUsers()
    {
       
        ArrayList<User_dc> users = ListUsers(jtFilter.getText());
        DefaultTableModel model = new DefaultTableModel();
         
         
        model.setColumnIdentifiers(new Object[]{"id","name","cash","status","product"});
        Object[] row = new Object[5];

     for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getProduct();
            model.addRow(row);
        }
       table.setModel(model);

    }
 public void findUsers2()
    {
       
        ArrayList<User_dc> users = ListUsers1(jtFilter2.getText());
        DefaultTableModel model = new DefaultTableModel();
         
         
        model.setColumnIdentifiers(new Object[]{"id","name","cash","status","product"});
        Object[] row = new Object[5];

     for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getProduct();
            model.addRow(row);
        }
       table2.setModel(model);

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
     *
     * @param query
     * @param message
     */
    public void executeSQlQuery2(String query, String message)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(query)) == 1)

           {

               // refresh jtable data

               DefaultTableModel model = (DefaultTableModel)table2.getModel();

               model.setRowCount(0);

               findUsers2();

               

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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        debtorsname = new javax.swing.JTextField();
        debtorsamount = new javax.swing.JTextField();
        debtorsstatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        creditorname = new javax.swing.JTextField();
        creditoramount = new javax.swing.JTextField();
        creditorstatus = new javax.swing.JTextField();
        adddebtors = new javax.swing.JButton();
        debtorpaid = new javax.swing.JButton();
        changedebtor = new javax.swing.JButton();
        addcreditor = new javax.swing.JButton();
        creditorpaid = new javax.swing.JButton();
        changecreditor = new javax.swing.JButton();
        jtFilter = new javax.swing.JTextField();
        jtFilter2 = new javax.swing.JTextField();
        gotosell = new javax.swing.JButton();
        clearfields = new javax.swing.JButton();
        clearfields1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        debtorsid = new javax.swing.JTextField();
        creditorid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 255));

        jLabel1.setText("name");

        jLabel2.setText("amount");

        jLabel4.setText("status");

        debtorsstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debtorsstatusActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(153, 153, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "amount", "date due", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel5.setText("name");

        jLabel7.setText("status");

        table2.setBackground(new java.awt.Color(153, 153, 255));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "amount", "date due", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setMaximumSize(null);
        table2.setMinimumSize(null);
        table2.setRowHeight(40);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jLabel8.setText("amount");

        adddebtors.setText("Add new");
        adddebtors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddebtorsActionPerformed(evt);
            }
        });

        debtorpaid.setText("Update");
        debtorpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debtorpaidActionPerformed(evt);
            }
        });

        changedebtor.setText("Delete");
        changedebtor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedebtorActionPerformed(evt);
            }
        });

        addcreditor.setText("Add new");
        addcreditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcreditorActionPerformed(evt);
            }
        });

        creditorpaid.setText("Update");
        creditorpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditorpaidActionPerformed(evt);
            }
        });

        changecreditor.setText("Delete");
        changecreditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changecreditorActionPerformed(evt);
            }
        });

        jtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFilterActionPerformed(evt);
            }
        });
        jtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilterKeyReleased(evt);
            }
        });

        jtFilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFilter2ActionPerformed(evt);
            }
        });
        jtFilter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilter2KeyReleased(evt);
            }
        });

        gotosell.setText("GO TO SELL");
        gotosell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotosellActionPerformed(evt);
            }
        });

        clearfields.setText("clear");
        clearfields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearfieldsActionPerformed(evt);
            }
        });

        clearfields1.setText("clear");
        clearfields1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearfields1ActionPerformed(evt);
            }
        });

        jLabel11.setText("debtors");

        jLabel12.setText("creditors");

        jButton1.setText("PANEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("product(optional)");

        jLabel6.setText("product(optional)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adddebtors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(debtorpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changedebtor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clearfields1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(debtorsid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(debtorsstatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                            .addComponent(debtorsamount)
                                            .addComponent(debtorsname)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(17, 17, 17)))))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addcreditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(creditorpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changecreditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel8))
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(creditorstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                            .addComponent(creditoramount)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(clearfields)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addComponent(jTextField2))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(creditorname, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(creditorid))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtFilter2)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gotosell, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearfields)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creditorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(creditoramount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(creditorstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addcreditor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(creditorpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changecreditor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(clearfields1)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(debtorsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(debtorsname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(debtorsamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(debtorsstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adddebtors, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(debtorpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(changedebtor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(377, 377, 377)
                                .addComponent(gotosell, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void debtorsstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debtorsstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debtorsstatusActionPerformed

    private void jtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilterActionPerformed
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterActionPerformed

    private void jtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilterKeyReleased
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterKeyReleased

    private void jtFilter2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilter2KeyReleased
        // TODO add your handling code here:
        findUsers2();
    }//GEN-LAST:event_jtFilter2KeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int i = table.getSelectedRow();




        TableModel model = table.getModel();

        

         // Display Slected Row In JTexteFields

        debtorsid.setText(model.getValueAt(i,0).toString());




        debtorsname.setText(model.getValueAt(i,1).toString());




        debtorsamount.setText(model.getValueAt(i,2).toString());




       debtorsstatus.setText(model.getValueAt(i,3).toString());
        jTextField1.setText(model.getValueAt(i,4).toString());

                                                     



                               
    }//GEN-LAST:event_tableMouseClicked

    private void adddebtorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddebtorsActionPerformed
        // TODO add your handling code here:
        String query = "INSERT INTO debts( lname,fname, age,product) VALUES ('"+debtorsamount.getText()+"','"+debtorsname.getText()+"','"+debtorsstatus.getText()+"','"+jTextField1.getText()+"')";
        // String query = "INSERT INTO `users`(`fname`, `lname`, `age`) VALUES ('"+jTextField_name.getText()+"','"+jTextField_quantity.getText()+"',"+jTextField_price.getText()+")";

        

        executeSQlQuery(query, "Inserted");
    }//GEN-LAST:event_adddebtorsActionPerformed

    private void debtorpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debtorpaidActionPerformed
        // TODO add your handling code here:
      String query = "UPDATE `debts` SET `lname`='"+debtorsamount.getText()+"',`fname`='"+debtorsname.getText()+"',`age`='"+debtorsstatus.getText()+"' WHERE `id` = "+debtorsid.getText();

       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_debtorpaidActionPerformed

    private void changedebtorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changedebtorActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM `debts` WHERE id = "+debtorsid.getText();

         executeSQlQuery(query, "Deleted");
    }//GEN-LAST:event_changedebtorActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
         int i = table2.getSelectedRow();




        TableModel model = table2.getModel();

        

         // Display Slected Row In JTexteFields

        creditorid.setText(model.getValueAt(i,0).toString());




        creditorname.setText(model.getValueAt(i,1).toString());




        creditoramount.setText(model.getValueAt(i,2).toString());




       creditorstatus.setText(model.getValueAt(i,3).toString());
         jTextField2.setText(model.getValueAt(i,4).toString());

                                          
    }//GEN-LAST:event_table2MouseClicked

    private void addcreditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcreditorActionPerformed
        // TODO add your handling code here:
         String query = "INSERT INTO credits( lname,fname, age,product) VALUES ('"+creditoramount.getText()+"','"+creditorname.getText()+"','"+creditorstatus.getText()+"','"+jTextField2.getText()+"')";
        // String query = "INSERT INTO `users`(`fname`, `lname`, `age`) VALUES ('"+jTextField_name.getText()+"','"+jTextField_quantity.getText()+"',"+jTextField_price.getText()+")";

        

        executeSQlQuery2(query, "Inserted");
    }//GEN-LAST:event_addcreditorActionPerformed

    private void creditorpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditorpaidActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE `credits` SET `lname`='"+creditoramount.getText()+"',`fname`='"+creditorname.getText()+"',`age`='"+creditorstatus.getText()+"' WHERE `id` = "+creditorid.getText();

       executeSQlQuery2(query, "Updated");
    }//GEN-LAST:event_creditorpaidActionPerformed

    private void changecreditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changecreditorActionPerformed
        // TODO add your handling code here:
         String query = "DELETE FROM `credits` WHERE id = "+creditorid.getText();

         executeSQlQuery2(query, "Deleted");
    }//GEN-LAST:event_changecreditorActionPerformed

    private void clearfields1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearfields1ActionPerformed
        // TODO add your handling code here:
        debtorsname.setText(null);
        debtorsamount.setText(null);
        debtorsid.setText(null);
        debtorsstatus.setText(null);
        jTextField1.setText(null);
        
        
    }//GEN-LAST:event_clearfields1ActionPerformed

    private void jtFilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilter2ActionPerformed
        // TODO add your handling code here:
        findUsers2();
    }//GEN-LAST:event_jtFilter2ActionPerformed

    private void gotosellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotosellActionPerformed
        // TODO add your handling code here:
        sellform m=new sellform();
        this.setVisible(true);
        m.setVisible(true);
    }//GEN-LAST:event_gotosellActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        adminpanel m=new adminpanel();
               m.setVisible(true);
               this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearfieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearfieldsActionPerformed
        // TODO add your handling code here:
          jTextField2.setText(null);
          creditoramount.setText(null);
           creditorname.setText(null);
            creditorstatus.setText(null);
             creditorid.setText(null);
    }//GEN-LAST:event_clearfieldsActionPerformed

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
            java.util.logging.Logger.getLogger(debtscredits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(debtscredits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(debtscredits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(debtscredits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new debtscredits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcreditor;
    private javax.swing.JButton adddebtors;
    private javax.swing.JButton changecreditor;
    private javax.swing.JButton changedebtor;
    private javax.swing.JButton clearfields;
    private javax.swing.JButton clearfields1;
    private javax.swing.JTextField creditoramount;
    private javax.swing.JTextField creditorid;
    private javax.swing.JTextField creditorname;
    private javax.swing.JButton creditorpaid;
    private javax.swing.JTextField creditorstatus;
    private javax.swing.JButton debtorpaid;
    private javax.swing.JTextField debtorsamount;
    private javax.swing.JTextField debtorsid;
    private javax.swing.JTextField debtorsname;
    private javax.swing.JTextField debtorsstatus;
    private javax.swing.JButton gotosell;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JTextField jtFilter2;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
