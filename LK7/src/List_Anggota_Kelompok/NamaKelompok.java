/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List_Anggota_Kelompok;

//Contoh overloading lagi

class NamaKelompok {
    String kelompok(){
        System.out.println("Daftar anggota kelompok");
        return null;
    }
}
class rayhan extends NamaKelompok{
     String kelompok(){
        System.out.println("1. M.Rayhan.F");
        return null;
    }
}
class ridho extends NamaKelompok{
     String kelompok(){
        System.out.println("2. M.Ridho.H");
        return null;
    }
}
class putri extends NamaKelompok{
     String kelompok(){
        System.out.println("3. Putri.Y");
        return null;
    }
}
class regina extends NamaKelompok{
     String kelompok(){
        System.out.println("4. Regina.R");
        return null;
    }
}
class syifa extends NamaKelompok{
     String kelompok(){
        System.out.println("5. Syifa.A");
        return null;
    }
}
class hasil{
    public static void main(String args[]){
        NamaKelompok nol = new NamaKelompok();
        NamaKelompok satu = new rayhan();
        NamaKelompok dua = new ridho();
        NamaKelompok tiga = new putri();
        NamaKelompok empat = new regina();
        NamaKelompok lima = new syifa();
        
        nol.kelompok();
        satu.kelompok();
        dua.kelompok();
        tiga.kelompok();
        empat.kelompok();
        lima.kelompok();
    }
}
