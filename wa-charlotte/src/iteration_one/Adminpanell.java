/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteration_one;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Login.java
 *
 * Created on June 30, 2012, 10:05 AM
 */



/**
 *
 * @author  Administrator
 */
public class Adminpanell extends javax.swing.JFrame {

    /** Creates new form Login */
    public Adminpanell() {
        initComponents();
        TxtUserName.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               TxtPassword.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        TxtPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //TxtPassword.requestFocus(); //To change body of generated methods, choose Tools | Templates.
                 String stru="";
        stru=TxtUserName.getText();

        String strp="";
        strp=TxtPassword.getText();
        if (stru.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter User Name");
         return;
        }

        if (strp.isEmpty()==true)
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
            str="select * from adminuser where user_name =? and user_password =?";
           PreparedStatement pst=connection.prepareStatement(str);
           pst.setString(1, stru);
           pst.setString(2, strp);
           ResultSet rs;
           rs=pst.executeQuery();
           if (rs.next())
           {
              // MainClass.StrUser=TxtUserName.getText();
               //this.setVisible(false);

                adminpanel m=new adminpanel();
                m.setVisible(true);
              Adminpanell k= new Adminpanell();
                      k.setVisible(false);

               //new Adminpanell().setVisible(false);
               //m.setVisible(true);


           }
           else
           {
                JOptionPane.showMessageDialog(null,"User name or password are not correct.");
                return;
            }


        }
        catch (Exception a)
        {
            System.err.println(a);
            System.exit(1);
        }
            }


            });
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtUserName = new javax.swing.JTextField();
        CmdOk = new javax.swing.JButton();
        CmdClose = new javax.swing.JButton();
        TxtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" RETAIL SYSTEM");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" RETAIL SYSTEM");

        jLabel2.setText("User Name:");

        jLabel3.setText("Password:");

        CmdOk.setText("LOGIN");
        CmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdOkActionPerformed(evt);
            }
        });

//        CmdClose.setText("QUIT");
//        CmdClose.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                CmdCloseActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(CmdOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmdOk)
                    .addComponent(CmdClose))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

//    private void CmdCloseActionPerformed(java.awt.event.ActionEvent evt) {
//        // Close project
//        System.exit(1);
//    }

    private void CmdOkActionPerformed(java.awt.event.ActionEvent evt) {
        //validation

  // MainClass b=new MainClass();
      //  b.setVisible(true);
        String stru="";
        stru=TxtUserName.getText();

        String strp="";
        strp=TxtPassword.getText();
        if (stru.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter User Name");
         return;
        }

        if (strp.isEmpty()==true)
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
            str="select * from adminuser where user_name =? and user_password =?";
           PreparedStatement pst=connection.prepareStatement(str);
           pst.setString(1, stru);
           pst.setString(2, strp);
           ResultSet rs;
           rs=pst.executeQuery();
           if (rs.next())
           {
              // MainClass.StrUser=TxtUserName.getText();
                adminpanel m=new adminpanel();
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


    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminpanell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton CmdClose;
    private javax.swing.JButton CmdOk;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration

}
