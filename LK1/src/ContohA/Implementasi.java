package ContohA;


public class Implementasi {
    public static void main (String []args){
    Karyawan karyawan001 = new Karyawan ();
    karyawan001.ID = "k001";
    karyawan001.nama = "M.Rayhan.F";
    karyawan001.divisi = "Keuangan";
    karyawan001.gaji = 1850000.0;
    
    karyawan001.cetakdata();
    
    System.out.println("Sumbangan zakat: " + karyawan001.hitungsumbanganzakat ());
    }
}
