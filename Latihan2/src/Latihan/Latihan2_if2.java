
package Latihan;
import java.util.Scanner;
public class Latihan2_if2 {
    public static void main(String args[]) {
        // mengatifkan Scanner untuk membaca input dari keyboard ke konsol 
        Scanner input = new Scanner(System.in);
        System.out.print("Nilai Anda : ");
        int a = input.nextInt();
        
        int nilai = a;

        // syarat nilai mi nimal untuk lulus adalah 67

        if (nilai >= 67) {
                        System.out.println("Anda Lulus!");                
        }
        else { 
              System.out.println("Anda Gagal!");
        }
    }
 }
