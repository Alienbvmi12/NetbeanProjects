package Tugas;

//Contoh Polimorfisme statis atau overloading
//Polimerfisme overloading

class Komputer {                                     //Komputer adalah induk class
  static String cekInfo(int memory) {               //cekInfo sebagai method dan memory sebagai variabel
    return "Komputer dengan "+memory+" GB RAM"; 
  }
}
 
class laptop extends Komputer {                     //laptop adalah subclass dari Komputer
   
  static String cekInfo(String pemili) {            //cekInfo sebagai method dan pemili sebagai variabel
    return"Ini Laptop milik " + pemili; 
}
}
class pa extends Komputer {                           //pa adalah sub class dari komputer
   
 void cekInfo(int ps, int s, int p) {               //cekInfo sebagai method dan ps, s, p sebagai variabel 
    System.out.println(ps + (s * p));
  }
}
class BelajarJava {
  public static void main(String args[]){           //sebagai main class
     
    Komputer l = new Komputer();  
    pa p = new pa();                                //utuk Memasukan variabel
    laptop c = new laptop();
    System.out.println(l.cekInfo(18));              
    System.out.println(c.cekInfo("Regina"));
    p.cekInfo(1,2,3);
    
 
  }
}

//Contoh Polimorfisme dinamis atau Overriding
//Polimorfisme Overriding

class Polimorfi {
    float luas(){                                               //Method luas di induk
        System.out.println("Menghitung luas bangun datar");
        return 0;
    }
    
    float keliling(){                                           //Method lagi yang berbeda di class induk
        System.out.println("Menghitung keliling bangun datar");
        return 0;
    }
}


class Persegi extends Polimorfi{                                //Class extends dari class induk
    int sisi;
    
    public Persegi(int sisi) {
        this.sisi = sisi;
    }
    
    @Override
    public float luas() {                                       //Bentuk lain dari method luas
        return this.sisi * this.sisi;
    }
    
    @Override
    public float keliling(){                                    //Bentuk lain dari method keliling...
        return this.sisi * 4;                                   //Dan seterusnya...
    }
}

class Segitiga extends Polimorfi{                             
   int alas;
   int tinggi;

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }
   
    
   @Override
   public float luas(){
       return this.alas * this.tinggi;
   }
}

class Lingkaran extends Polimorfi {
    int r;

     Lingkaran(int r) {
        this.r = r;
    }
    
    @Override
    public float luas(){
        return (float) (Math.PI * r * r);
    }
    
    @Override
    public float keliling(){
        return (float) (2 * Math.PI * r);
    }
    
}

class Polimorfisme {
    public static void main(String args[]) {            //Semua class dipanggil pada main method
        
        Polimorfi bangunDatar = new Polimorfi();
        Polimorfi persegi = new Persegi(5);
        Segitiga segitiga = new Segitiga(6, 3);
        Lingkaran lingkaran = new Lingkaran(50);
        
                                                        // memanggil method luas dan keliling dari main class
        bangunDatar.luas();
        bangunDatar.keliling();
        
                                                        //memanggil method dari class turunan
        System.out.println("Luas persegi: " + persegi.luas());
        System.out.println("keliling persegi: " + persegi.keliling());
        System.out.println("Luas segitiga: " + segitiga.luas());
        System.out.println("Luas lingkaran: " + lingkaran.luas());
        System.out.println("keliling lingkaran: " + lingkaran.keliling());
    }
}

