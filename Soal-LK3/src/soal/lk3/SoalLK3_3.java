/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soal.lk3;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class SoalLK3_3 {
    public static void main(String[]args){
        int st;
        String bin = "*";
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cetak sampai = ");
        st = scanner.nextInt();
        for( i = 1 ; i <= st; i++){
            System.out.println(bin);
            bin = bin + "*";
            
    }
    }
    
}
