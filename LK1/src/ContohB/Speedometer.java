package ContohB;

public class Speedometer{
}   


class Mobil extends Speedometer{
public void tambahkecepatan(){
System.out.println("injak kupling lalu, pindah ke gear yang lebih tinggi & gas mobilnya");
}

public void kurangiKecepatan(){
System.out.println("rem Mobilnya & pindah gear yang lebih rendah");
}}

class Motor extends Speedometer{
public void tambahKecepatan(){
System.out.println("pindah ke gear yang lebih tinggi & gas motornya");
}

public void kurangiKecepatan(){
System.out.println("Rem motornya dengan rem belakang + rem depan, lalu pindah gear yang lebih rendah");
}}

class testKendaraan{
    public static void main(String[]args){
        Mobil mobil = new Mobil();
        Motor motor = new Motor();
        
        System.out.print("Cara ngebut pake motor : ");
        motor.tambahKecepatan();
        System.out.print("Cara berhentinya : ");
        motor.kurangiKecepatan();
        System.out.print("Cara ngebut pake mobil");
        mobil.tambahkecepatan();
        System.out.print("Cara berhentinya");
        mobil.kurangiKecepatan();
        
    }
}
     
