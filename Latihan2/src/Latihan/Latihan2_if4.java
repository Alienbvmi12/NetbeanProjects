
package Latihan;
import java.util.Scanner;
public class Latihan2_if4 {
    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        System.out.print("Nilai uts :");
        float a = input.nextInt();
        System.out.print("Nilai uas :");
        float b = input.nextInt();
        System.out.print("Nilai tugas :");
        float c = input.nextInt();
        float na = (a + b + c)/3;
        
        System.out.println("Nilai Akhir : " + na);
        if (na >= 90){
            System.out.println("Siswa lulus, predikat a");
        }
        else if ( na >= 80){ if ( na < 90) {
            System.out.println("Siswa lulus, predikat b");
        }}
        else if ( na >= 70){ if (na < 80) {
            System.out.println("Siswa lulus, predikat c");
        }}
        else{
            System.out.println("Siswa lulus, predikat d");
        }
            
        }
    }
    

