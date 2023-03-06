/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ujikom3;

/**
 *
 * @author Acer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class koneksi {

    Connection con;
    Statement stm;
    
    public void config(){
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peminjaman", "root", "");
            stm = con.createStatement();
            System.out.println("Konek");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "koneksi gagal "+e.getMessage());
        }
    }
  
}