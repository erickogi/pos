package iteration_one;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimani kogi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class SendMail {

//   static double total1;
//// public  void sum3() throws Exception {
//    double sum2 = 0;
//      double total;
//    //double total;
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
//        "root", "");
//    Statement st2 = con.createStatement();
//    ResultSet res2 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
//    while (res2.next()) {
//      double c2 = res2.getInt(1);
//      sum2 = sum2 + c2;
//      // total=sum2;
//    }
//  total=sum2;
  //}
//  public  void sum1() throws Exception {
//    double sum1 = 0;
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
//        "root", "");
//    Statement st1 = con.createStatement();
//    ResultSet res1 = st1.executeQuery("SELECT SUM(age) FROM trans  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
//    while (res1.next()) {
//      double c1 = res1.getInt(1);
//      sum1 = sum1 + c1;
//
//
//    }
//  // total1.setText(Double.toString(sum1));
//     total1=sum1;
//  }
    public static void main() throws ClassNotFoundException, SQLException {
 double total1;
// public  void sum3() throws Exception {
    double sum2 = 0;
    double sum3 = 0;
      double total;
      //double total1;
    //double total;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
        "root", "123ERYcog.");
    Statement st2 = con.createStatement();
    ResultSet res2 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    while (res2.next()) {
      double c2 = res2.getInt(1);
      sum2 = sum2 + c2;
      total=sum2;
      Statement st3 = con.createStatement();
    ResultSet res3 = st3.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    while (res3.next()) {
      double c3 = res3.getInt(1);
      sum3 = sum3 + c3;
      total1=sum3;
        final String username = "erickimani15@gmail.com";
        final String password = "erickogikimani";

//        Properties props = new Properties();
//       props.put("mail.smtp.starttls.enable", "false");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
          Properties props = new Properties();
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.debug", "true");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
       return new PasswordAuthentication(username,password);
   }
    });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("erickogi14@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("nderiann41@gmail.com"));
            message.setSubject("TRANSACTION REPORT");

             //message.setText("\n\ntoday"+ Double.toString(total));
              message.setText("week,"+ Double.toString(total1)+"\n\ntoday"+ Double.toString(total));

            Transport.send(message);
 JOptionPane.showMessageDialog(null, "Data sent Succefully");
           // System.out.println("Done");

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Data not sent Succefully");
            throw new RuntimeException(e);
        }
    }

    }
    }
}
