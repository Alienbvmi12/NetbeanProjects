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
public class CLI_C {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int st;
        int bin;
        int i ;
        System.out.print("MAsukan bintang = ");
        st = scanner.nextInt();
        
        for( i = 0 ; i < st; i++){
            for(bin = 1; bin <= st-i; bin++ ){
                System.out.print("*");
            }
        System.out.println();
        }
        
    }
}
