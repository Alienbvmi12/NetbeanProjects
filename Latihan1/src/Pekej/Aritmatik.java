/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pekej;

/**
 *
 * @author user
 */
class Aritmatik {
    public static void main (String [] args){ //mau ganti main disini
        int a = 15, b = 6; 
        
        int jumlah = a + b;
        int kurang = a - b;
        int kali = a * b;
        float bagi = (float) a/b;
        int modulo = a % b;
        
        System.out.println();
        System.out.println("====Aritmatik====");
        System.out.println();
        System.out.println("Penjumlahan : " + a + " + " + b + " = " + jumlah);
        System.out.println("Pengurangan : " + a + " - " + b + " = " + kurang);
        System.out.println("Perkalian : " + a + " x " + b + " = " + kali);
        System.out.println("Pembagian : " + a + " : " + b + " = " + bagi);
        System.out.println("Sisa bagi : " + a + " % " + b + " = " + modulo);
        if (a == kurang){System.out.println("sama");}
        else if ( a > kurang){System.out.println("lebih besar");}
        else {System.out.println("kurang dari");}
    }
}
