/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soal.lk3;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SoalLK3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int i, stop;
        System.out.println("Cetak sampai angka:");
        stop = scanner.nextInt();
        i=1;
        do{
            System.out.println(i);
            i++;           
        }
        while (i<=stop);
        System.out.println("Variabel i kita input value nya, dan system DoWhile "
                + "akan mencetak angka berurutan sebanyak i" );
    }
    
}
