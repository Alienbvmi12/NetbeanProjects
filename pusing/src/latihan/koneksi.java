/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

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
          Class.forName("com.mysql.jdbc.cj.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/inventorii","root","");
          stm = con.createStatement();
      }catch (Exception e){
          JOptionPane.showMessageDialog(null, "Data Base ditemukan !");
      }
  }
}
