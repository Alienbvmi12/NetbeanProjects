/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tempat.percobaan;

/**
 *
 * @author user
 */
public class ContohOveriding {
}

class Hewan {
    protected String ayu = "Lah";
   public void mowe() {
      System.out.println("Hewan Bisa Bergerak");
   }
}
class Anjing extends Hewan {
   public void move() {
      super.mowe();
      System.out.println("Anjing Bisa Berjalan dan Berlari");
   }
}
class Babi extends Hewan {
   public void move() {
       super.mowe();
      System.out.println("Haram");
   }
}
 class TestDog {
   public static void main(String args[]) {
      Anjing a = new Anjing();
      Babi b = new Babi();
      System.out.println("Latihan 1");
      System.out.println("");
      a.move();
      b.move();// menjalankan method di dalam kelas hewan   // menjalankan method didalam kelas anjing
   }
}

class Kendaraan {
  protected String brand = "sepeda";        // Atribut dari class kendaraan
  public void gerak() {                    // method dari class kendaraan
    System.out.println("dikayuh");
  }
}
class Tipe extends Kendaraan {
  private String modelName = "Lipat";    // atribut dari tipe
  public static void main(String[] args) {

    Tipe myTipe = new Tipe();

    myTipe.gerak();
    
    System.out.println(myTipe.brand + " " + myTipe.modelName);
  }
}
    

