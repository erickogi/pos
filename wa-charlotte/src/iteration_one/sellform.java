/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteration_one;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class sellform extends javax.swing.JFrame {
   DefaultTableModel model = new DefaultTableModel();
  int b;
   int a;
   
 //jcartarea.append( "name"+tab);
            //jcartarea.append( "quantity"+tab);
            //jcartarea.append( "pric"+newline);
  // int qua;
 // int y;
         //y =Integer.valueOf(quantity1.getText());   // private Object bp;
   //jcartarea.getText();
   //String Jcart;
  // Jcart.setText(jcartarea.getText());
    /** Creates new form TestPrint */
    //public TestPrint() {

    //}


        // Only do this once per print







   //private static JLabel lbl = new JLabel("Hello");

   //DefaultListModel listmodel;
   //private JList list;
//   private void blinkTheLabel()
//  {
//       lbll = new JLabel("Hello   n");
//       jp.add(lbll);
//     // private  long ctr = 0;
//    final java.util.Timer tmr = new java.util.Timer();
//    tmr.scheduleAtFixedRate(new TimerTask()
//    {
//      public void run()
//      {
//        if(ctr%2 == 0) jp.remove(lbll);
//        else jp.add(lbll);
//        //setContentPane(frame);
//        if(ctr==1000000000)tmr.cancel();
//        ctr++;
//      }
//    },500,500);
//  }
    public sellform() {
      //  this.y = Integer.valueOf(quantity1.getText());
// int y=Integer.valueOf(quantity1.getText());
       
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
//            table.addActionListener(new ActionListener() {
//
//           @Override
//           public void actionPerformed(ActionEvent e) {
//
//           }

//
//            });
             quantity1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TxtPassword.requestFocus(); //To change body of generated methods, choose Tools | Templates.
                 final String newline="\n";
            final String tab="\t";
            int pric;
            int qua;
int y,c;
c=Integer.parseInt(quantity1.getText());
y=b*c;
            pric=Integer.valueOf(price.getText());
            qua=Integer.valueOf(quantity1.getText());
            String tp=totalpurchase.getText();
            int tps=Integer.valueOf(tp);

            int top=(pric*qua);
            tp=Integer.toString(top+tps);
            //String b=Integer.toString(a);
            //int ptop=(top+tp);

            totalprice.setText(Integer.toString(top));

            totalpurchase.setText(tp);

            //jcartarea.append( "name"+tab);
            //jcartarea.append( "quantity"+tab);
            //jcartarea.append( "price"+newline);
            //Jcart=jcartarea.getText();

            jcartarea.append(  productname.getText()+tab );
            jcartarea.append(quantity1.getText()+tab);
            //jcartarea.append(productid.getText()+tab);
            jcartarea.append(totalprice.getText()+newline +newline);
            // Calender calender=Calender.getInstance();
//Jcart=jcartarea.getText();
            //java.sql.Date currentTimestamp=new
            //java.sql.Timestamp(calender.getInstance().getTime().getTime());

            try
            {
                Connection connection;
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

                String sql = "INSERT INTO `trans`( `bp`,`fname`, `lname`,`updated_at`, `age`) VALUES ("+y+"'"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
                PreparedStatement pst=connection.prepareStatement(sql);
                pst.executeUpdate(sql);
            }
            catch (Exception a) {
                System.err.println(a);
                System.exit(1);
            }
            try
            {
                Connection connection;
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

                String sql = "UPDATE users SET lname = lname-'"+quantity1.getText()+"'  WHERE id='"+productid.getText()+"'";

                PreparedStatement pst=connection.prepareStatement(sql);
                pst.executeUpdate(sql);
            }
            catch (Exception a) {
                System.err.println(a);
                System.exit(1);
            }
            }
        });
                   SimpleDateFormat df = new SimpleDateFormat();
String receiptDetailLine;
              df.applyPattern("dd/MM/yyyy HH:mm:ss");
    String strText = null;
    final String LF = "\n";// text string to output
    int lineStart;           // start index of line in jcartarea
    int lineEnd;             // end index of line in jcartarea
    int lineNumber;
    int lineCount;
    final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
    final String uline = "________________________________________";
    final String dline = "----------------------------------------";
    String greetings = "THANKS FOR YOUR VISIT";
    receiptDetailLine = "RETAIL HARDWARE";
      //jcartarea.append(SPACES + "sadasdsad" + "\n");

    //jcartarea.append(" " + SPACES + "sadasdsad" + "\n");

   // jcartarea.append(SPACES + "sadasdsad" + "\n");

    jcartarea.append("" + SPACES + "07565454645" + "\n");

    jcartarea.append(SPACES + "YOUR PUCHASES" + "\n");

    jcartarea.append(uline + "\n");
   // jcartarea.append("Order Ref:" + "   " + receiptDetailLine + "\n");
    jcartarea.append(dline + "\n");
    jcartarea.append(" Qty     Description" + SPACES + "  Price" + LF);
//              final String newline="\n";
//            final String tab="\t";
//       this.jcartarea.append( "name"+tab);
//           this.jcartarea.append( "quantity"+tab);
//            this.jcartarea.append( "pric"+newline);
    }
    public void a() {
    PageFormat format = new PageFormat();
    Paper paper = new Paper();

    double paperWidth = 3;//3.25
    double paperHeight = 3.69;//11.69
    double leftMargin = 0.12;
    double rightMargin = 0.10;
    double topMargin = 0;
    double Margin = 0;
    double bottomMargin = 0.01;

    paper.setSize(paperWidth * 200, paperHeight * 200);
    paper.setImageableArea(leftMargin * 200, topMargin * 200,
            (paperWidth - leftMargin - rightMargin) * 200,
            (paperHeight - topMargin - bottomMargin) * 200);

    format.setPaper(paper);

    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(OrientationRequested.PORTRAIT);


    PrinterJob printerJob = PrinterJob.getPrinterJob();
    Printable printable = new ReceiptPrint();

    format = printerJob.validatePage(format);
    boolean don = printerJob.printDialog();
    printerJob.setPrintable(printable, format);
    try {
        printerJob.print(aset);
    } catch (Exception e) {
        e.printStackTrace();
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
    public ArrayList<User_1> ListUsers(String ValToSearch)
    {
        ArrayList<User_1> usersList = new ArrayList<User_1>();

        Statement st;
        ResultSet rs;

        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`id`, `fname`, `lname`, `age`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);

            User_1 user;

            while(rs.next())
            {
                user = new User_1(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getInt("age"),
                        rs.getInt("bp"),
                        rs.getString("from")
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

        ArrayList<User_1> users = ListUsers(jtFilter.getText());
        DefaultTableModel model = new DefaultTableModel();


        model.setColumnIdentifiers(new Object[]{"ID","name","quantity","price","buy price"});
        Object[] row = new Object[5];

     for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getBp();
            model.addRow(row);
        }
       table.setModel(model);

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
        calc = new javax.swing.JButton();
        inventorybtn = new javax.swing.JButton();
        transactionbtn = new javax.swing.JButton();
        addproductbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        productnamelbl = new javax.swing.JLabel();
        productidlbl = new javax.swing.JLabel();
        quantitylbl = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        addtocartbtn = new javax.swing.JButton();
        recieptbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productname = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        productid = new javax.swing.JEditorPane();
        adminbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        totalprice = new javax.swing.JEditorPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jcartarea = new javax.swing.JTextArea();
        totalpurchase = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cashin = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jp = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        lbll = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        quantity1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 812));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" RETAIL SYSTEM ");

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

        calc.setText("CALCULATOR");
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        inventorybtn.setText("CHECK INVENTORY");
        inventorybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventorybtnActionPerformed(evt);
            }
        });

        transactionbtn.setText("TRANSACTIONS");
        transactionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionbtnActionPerformed(evt);
            }
        });

        addproductbtn.setText("ADD PRODUCTS");
        addproductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductbtnActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(51, 153, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price"
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

        productidlbl.setText("PRODUCT ID");

        quantitylbl.setText("QUANTITY");

        pricelbl.setText("PRICE");

        addtocartbtn.setText("ADD");
        addtocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartbtnActionPerformed(evt);
            }
        });

        recieptbtn.setText("RECIEPT");
        recieptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recieptbtnActionPerformed(evt);
            }
        });

        productname.setEditable(false);
        productname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jScrollPane2.setViewportView(productname);

        productid.setEditable(false);
        productid.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jScrollPane3.setViewportView(productid);

        adminbtn.setText("ADMIN PANEL");
        adminbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbtnActionPerformed(evt);
            }
        });

        jLabel7.setText("ITEMS IN CART");

        totalprice.setEditable(false);
        totalprice.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jScrollPane7.setViewportView(totalprice);

        jcartarea.setEditable(false);
        jcartarea.setBackground(new java.awt.Color(255, 255, 153));
        jcartarea.setColumns(20);
        jcartarea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcartarea.setRows(5);
        jScrollPane8.setViewportView(jcartarea);

        totalpurchase.setEditable(false);
        totalpurchase.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalpurchase.setText("0");

        jLabel3.setText("sh");

        jLabel4.setText("cash in");

        cashin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cashin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashinKeyReleased(evt);
            }
        });

        change.setEditable(false);
        change.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CALENDER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jp.setBackground(new java.awt.Color(255, 204, 204));
        jp.setAutoscrolls(true);

        lbll.setText("           ");

        javax.swing.GroupLayout jpLayout = new javax.swing.GroupLayout(jp);
        jp.setLayout(jpLayout);
        jpLayout.setHorizontalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLayout.createSequentialGroup()
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lbl))
                    .addGroup(jpLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lbll)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jpLayout.setVerticalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLayout.createSequentialGroup()
                .addComponent(lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbll)
                .addGap(36, 36, 36))
        );

        jButton3.setText("send todays");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        quantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantity1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(adminbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addproductbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transactionbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inventorybtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productnamelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantitylbl)
                                    .addComponent(productidlbl)
                                    .addComponent(pricelbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cashin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(totalpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recieptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(productnamelbl)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(productidlbl)
                                        .addGap(86, 86, 86)
                                        .addComponent(quantitylbl))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pricelbl)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane8)
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recieptbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cashin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(inventorybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(transactionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(addproductbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(adminbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton3)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cashinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashinKeyReleased
        // TODO add your handling code here:
        int pric;
       int qua;
        String tp;

        pric=Integer.valueOf(cashin.getText());
        qua=Integer.valueOf(totalpurchase.getText());
        //String tp=change.getText();
        //int tps=Integer.valueOf(tp);

        int top=(pric-qua);
        tp=Integer.toString(top);
        //String b=Integer.toString(a);
        //int ptop=(top+tp);

        //totalprice.setText(Integer.toString(top));

        change.setText(tp);
    }//GEN-LAST:event_cashinKeyReleased

    private void adminbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminbtnActionPerformed
        // TODO add your handling code here:
        Adminpanell m=new Adminpanell();
         this.setVisible(true);
        m.setVisible(true);
        //this.setVisible(true);
    }//GEN-LAST:event_adminbtnActionPerformed

    private void addtocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartbtnActionPerformed
        // TODO add your handling code here:
        // private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {

            final String newline="\n";
            final String tab="\t";
            int pric;
            int qua;

            pric=Integer.valueOf(price.getText());
            qua=Integer.valueOf(quantity1.getText());
            String tp=totalpurchase.getText();
            int tps=Integer.valueOf(tp);
            final String LF = "\n";
final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
            int top=(pric*qua);
            tp=Integer.toString(top+tps);
            //String b=Integer.toString(a);
            //int ptop=(top+tp);

            totalprice.setText(Integer.toString(top));

            totalpurchase.setText(tp);

            //jcartarea.append( "name"+tab);
            //jcartarea.append( "quantity"+tab);
            //jcartarea.append( "pric"+newline);
            //Jcart=jcartarea.getText();
       final String ab=quantity1.getText();
        final String ta=productname.getText();
         final String tb=totalprice.getText();
    //jcartarea.append(  productname.getText()+tab );
           //jcartarea.append(quantity1.getText()+tab);
           //jcartarea.append(  productname.getText()+tab );
           //jcartarea.append(productid.getText()+tab);
          // jcartarea.append(totalprice.getText()+newline +newline);
            // jcartarea.append(" Qty     Description" + SPACES + "  Price" + LF);
            jcartarea.append( ab+ "                " +ta +"                "+tb +newline );
            //productname.getText(),  + SPACES +, totalprice.getText()+ LF);
   // jcartarea.append(dline + "\n");

   // System.out.println(2);

   // String printedLine = "       Service Charge Complimentary";
    //jcartarea.append(printedLine + LF);

    //jcartarea.append(LF + SPACES + "   Your Reciept\n" + SPACE + greetings + LF);
    //jcartarea.append(df.format(new Date()) + LF);
    jcartarea.setEditable(false);
            
            // Calender calender=Calender.getInstance();
//Jcart=jcartarea.getText();
            //java.sql.Date currentTimestamp=new
            //java.sql.Timestamp(calender.getInstance().getTime().getTime());

            try
            {
                Connection connection;
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");
int y,c;
c=Integer.parseInt(quantity1.getText());
y=b*c;
                String sql = "INSERT INTO `trans`(`bp`, `fname`, `lname`,`updated_at`, `age`) VALUES ("+y+",'"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
                  //String sql = "INSERT INTO `trans`( `fname`, `lname`,`updated_at`, `age`) VALUES ('"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
                PreparedStatement pst=connection.prepareStatement(sql);
                pst.executeUpdate(sql);
            }
            catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
            try
            {
                Connection connection;
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

                String sql = "UPDATE users SET lname = lname-'"+quantity1.getText()+"'  WHERE id='"+productid.getText()+"'";

                PreparedStatement pst=connection.prepareStatement(sql);
                pst.executeUpdate(sql);
            }
            catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
    }//GEN-LAST:event_addtocartbtnActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        //createKeybindings();

    }//GEN-LAST:event_tableKeyPressed
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();
//int bp,Interger;
        TableModel model = table.getModel();

        // Display Slected Row In JTexteFields
 
        productid.setText(model.getValueAt(i,0).toString());

        productname.setText(model.getValueAt(i,1).toString());
//bp.(model.getValueAt(i, 4).toString());
        quantity1.setText("");

        price.setText(model.getValueAt(i,3).toString());
        //int a;
        //int b;
 b=(Integer)model.getValueAt(i, 4);
// a=b*quantity1.getText();
 //int c;
 //c=Integer.parseInt(quantity1.getText());
// a=a+(b*(Integer.valueOf(quantity1.getText())));
 //a=(b*c);
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcActionPerformed
        // TODO add your handling code here:
        //Calc me=new Calc();
        Calc me=new Calc();
        // this.setVisible(true);
        //me.setVisible(true);
    }//GEN-LAST:event_calcActionPerformed

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

    private void addproductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductbtnActionPerformed
        // TODO add your handling code here:
        AdminI m=new AdminI();
        this.setVisible(true);
        m.setVisible(true);
        //this.setVisible(true);
    }//GEN-LAST:event_addproductbtnActionPerformed

    private void transactionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionbtnActionPerformed
        // TODO add your handling code here:
        Tadmin m=new Tadmin();
        this.setVisible(true);
        m.setVisible(true);

    }//GEN-LAST:event_transactionbtnActionPerformed

    private void inventorybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventorybtnActionPerformed
        // TODO add your handling code here:
        Aadmin m=new Aadmin();
        this.setVisible(true);
        m.setVisible(true);

    }//GEN-LAST:event_inventorybtnActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        totalpurchase.setText("0");
        productname.setText(null);
        productid.setText(null);
        quantity1.setText(null);

         price.setText(null);
        totalprice.setText(null);
        jcartarea.setText(null);

        cashin.setText(null);
        change.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        blinkTheLabel();
         CalendarProgram m = new CalendarProgram();
         m.main();
         //CalendarProgram.tblCalendarRenderer;
      // blinkTheLabel();
        //CalendarProgram.refreshCalendar ();



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SendMail m=new SendMail();
       try {
           SendMail.main();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void recieptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recieptbtnActionPerformed
        // TODO add your handling code here:
       // jcartarea.setText(null);
        a();
    }//GEN-LAST:event_recieptbtnActionPerformed

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
        // TODO add your handling code here:
         int pric;
       int qua;
        pric=Integer.parseInt(price.getText());
        qua=Integer.parseInt(quantity1.getText());
        int top=(pric*qua);

        totalprice.setText(Integer.toString(top));
    }//GEN-LAST:event_quantity1KeyReleased

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
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sellform().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addproductbtn;
    private javax.swing.JButton addtocartbtn;
    private javax.swing.JButton adminbtn;
    private javax.swing.JButton calc;
    private javax.swing.JTextField cashin;
    private javax.swing.JTextField change;
    private javax.swing.JButton inventorybtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jcartarea;
    private javax.swing.JPanel jp;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbll;
    private javax.swing.JTextField price;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JEditorPane productid;
    private javax.swing.JLabel productidlbl;
    private javax.swing.JEditorPane productname;
    private javax.swing.JLabel productnamelbl;
    private javax.swing.JTextField quantity1;
    private javax.swing.JLabel quantitylbl;
    private javax.swing.JButton recieptbtn;
    public javax.swing.JTable table;
    private javax.swing.JEditorPane totalprice;
    private javax.swing.JTextField totalpurchase;
    private javax.swing.JButton transactionbtn;
    // End of variables declaration//GEN-END:variables
//this.jp.add(lbl);
   // private void executeSQlQuery(String query, String inserted) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    private  class ReceiptPrint implements Printable {
SimpleDateFormat df = new SimpleDateFormat();
String receiptDetailLine;
public static final String pspace = "               ";//15-spaces
        
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {

    df.applyPattern("dd/MM/yyyy HH:mm:ss");
    String strText = null;
    final String LF = "\n";// text string to output
    int lineStart;           // start index of line in jcartarea
    int lineEnd;             // end index of line in jcartarea
    int lineNumber;
    int lineCount;
    final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
    final String uline = "________________________________________";
    final String dline = "----------------------------------------";
    String greetings = "THANKS FOR YOUR VISIT";
    receiptDetailLine = "asdasdasda";

    Graphics2D g2d = (Graphics2D) graphics;
    Font font = new Font("MONOSPACED", Font.BOLD, 9);

    if (pageIndex < 0 || pageIndex >= 1) {
        return Printable.NO_SUCH_PAGE;
    }
  String printedLine = "       Service Charge Complimentary";
    jcartarea.append(printedLine + LF);

    jcartarea.append(LF + SPACES + "   Your Reciept\n" + SPACE + greetings + LF);
    jcartarea.append(df.format(new Date()) + LF);
    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

    g2d.setFont(font);
    lineNumber = 0;
    lineCount = jcartarea.getLineCount();
    strText = jcartarea.getText();
    while (lineCount != 0) {
        try {

            lineStart = jcartarea.getLineStartOffset(lineNumber);
            lineEnd = jcartarea.getLineEndOffset(lineNumber);
            strText = jcartarea.getText(lineStart, lineEnd - lineStart);
        } catch (Exception exception) {
            System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
        }

        g2d.drawString(strText, 1, (lineNumber + 1) * 18);
        //spacing    between lines
        lineNumber = lineNumber + 1;
        lineCount--;
    }
    return Printable.PAGE_EXISTS;
    }

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
}
