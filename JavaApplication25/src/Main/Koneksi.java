/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class Koneksi {
    Connection kon;
    Statement stm;
    public void config(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           kon = DriverManager.getConnection("jdbc:mysql://localhost/pbo","root","");
           stm = kon.createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tidak bisa konek ke database!!");
        }
    }
}
