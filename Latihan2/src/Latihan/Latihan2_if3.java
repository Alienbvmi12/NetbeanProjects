
package Latihan;
import java.util.Scanner;
public class Latihan2_if3 {
    public static void main(String args []){
        //Mengaktifkan scanner untuk membaca input dari keyboard ke konsol
    Scanner input = new Scanner(System.in);
    System.out.println("Nilai anda: ");
    int a = input.nextInt();
    
    int nilai = a;
    
    //Syarat nilai lulus memuaskan adalah di atas 90
    //syarat nilai minimal untuk lulus adalah 60

      if(nilai > 90){
          System.out.println("anda lulus memuaskan!");
      }

    else if (nilai >= 60) {
                        System.out.println("Anda Lulus!");                
        }
        else { 
              System.out.println("Anda Gagal!");
        }
    }
 }

  