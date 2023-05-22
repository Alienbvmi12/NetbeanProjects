/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nilaisiswa;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class koneksi {
    private static Connection connection = null;
    private static Statement stm;
    
    public static Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pbo";
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        }
        return connection;
    }
    
    public static void getStatement(){
       getConnection();
       try{
           stm = connection.createStatement();
       }
       catch(SQLException ee){
           JOptionPane.showMessageDialog(null, ee);
       }
    } 
    
    public static ResultSet read(String sql) throws SQLException{
        getStatement();
        return stm.executeQuery(sql);
    }
    
    public static void post(String sql) throws SQLException{
        getStatement();
        stm.execute(sql);
    }
}
    
