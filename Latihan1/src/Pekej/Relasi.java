/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pekej;

/**
 *
 * @author user
 */
class Relasi {
    public static void main (String []args){ //mau ganti main disini
        int a = 100, b = 30;
        
        boolean kd = a < b; // kd = kurang dari
        boolean ld = a > b; // ld = lebih dari
        boolean ksm = a <= b; // ksm = kurang dari atau sama dengan
        boolean lsm = a >= b; // lsm = kurang dari
        boolean sm = a == b; // sm = sama dengan
        boolean ts = a != b; // ts = tidak sama dengan
        
        System.out.println();
        System.out.println("====Relasi====");
        System.out.println();
        System.out.println(a + " < " + b + " Nilainya " + kd);
        System.out.println(a + " > " + b + " Nilainya " + ld);
        System.out.println(a + " <= " + b + " Nilainya " + ksm);
        System.out.println(a + " >= " + b + " Nilainya " + lsm);
        System.out.println(a + " == " + b + " Nilainya " + sm);
        System.out.println(a + " != " + b + " Nilainya " + ts);
    }
}
