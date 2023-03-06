/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

public class Enkapsulasi {

    private String nama;                                    //Tambahkan modifier private agar variabel tidak 
    private int nim;                                        //bisa digunakan oleh class lain termasuk subclass-nya,
                                                            //dan hanya bisa digunakan oleh class itu sendiri
    public String getNama() {
        return this.nama;                                   //Return variabel nama
    }

    public void ModifNama(String nama) {                    //Memasukan variabel nama menjadi method
        this.nama = nama;
    }
}

class main {

    public static void main(String[] args) {                //Memanggil method dari class Enkapsulasi
        Enkapsulasi objek = new Enkapsulasi();
        objek.ModifNama("Syifa-chan");
        System.out.println("Nama : " + objek.getNama());

    }
}
