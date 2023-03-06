/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pekej;

/**
 *
 * @author user
 */
class Logika {
    public static void main (String [] args){ //mau ganti main disini
    boolean a = true , b = false;
    
    boolean log_AND = a && b; // a AND b
    boolean log_OR = a || b; // a OR b
    boolean log_NOTa = !a; // NOT a
    boolean log_NOTb = !b; // NOT b
    
    
    
    System.out.println();
    System.out.println("====Logika====");
    System.out.println();
    System.out.println(a + " AND " + b +" nilainya " + log_AND);
    System.out.println(a + " OR " + b +" nilainya " + log_OR);
    System.out.println("NOT " + a +" nilainya " + log_NOTa);
    System.out.println("NOT " + b +" nilainya " + log_NOTb);
    
    
    }
    
}
