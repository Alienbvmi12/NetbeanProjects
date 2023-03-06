/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLI;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class CLI_B {
    public static void main(String[]args){
      String x, y;
      int z;
      Scanner input = new Scanner(System.in);
      System.out.print("Nama : " );
      x = input.nextLine();
      System.out.print("Kelas : " );
      y = input.nextLine();
      System.out.print("Nilai : " );
      z = input.nextInt();
      
      if(z >= 75){
          System.out.println("Anda lulus");
      }
      else{
          System.out.println("Anda tidak lulus");
      }
             
    }
    
}
