
package ContohA;


public class Karyawan {
    String ID, nama, divisi ;
    Double gaji;
    
    void cetakdata(){
        System.out.println("Data karyawan");
        System.out.println("ID:" + ID);
        System.out.println("Nama :" +nama);
        System.out.println("Divisi :" +divisi);
        System.out.println("Gaji :" +gaji);
    }
    
    double hitungsumbanganzakat (){
        double zakat = gaji * 0.025;
        return zakat;
    }
}

