
package Latihan;

public class Latihan2_if1 {

  
    public static void main(String[] args) {
      int a, b, c ;
      a = 2;
      b = 3;
      
      c = a - b; //operasi pertama
      
      if(c >= 0){
          System.out.println("c adalah bilangan positif");
      }
      if(c < 0){
        System.out.println("c adalah bilangan negatif");
    }   
    
      System.out.println();
      c = b - a; //operasi kedua
      if(c >= 0){
          System.out.println("c adalah bilangan positif");
      }
      if(c < 0){
        System.out.println("c adalah bilangan negatif");
    }   
}
}

