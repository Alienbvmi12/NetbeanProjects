/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ujikompetensismt3;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Thosiba
 */
public class koneksi {
  Connection con ;
  Statement stm;
  public void config(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
          stm = con.createStatement();
      }catch (Exception e){
          JOptionPane.showMessageDialog(null, "error !");
      }
  }
}
