
package Tugas;




class Enemy {                                           //Class enemy adalah class induk atau superclass

    void attack(){
        System.out.println("Serang!");
    }
	}

class Zombie extends Enemy {                            //Zombie dan kawan-kawan adalah class turunan atau subclass dari class Enemy
	void walk(){
        System.out.println("Zombie jalan-jalan");
    }
}
class Pocong extends Enemy {
	  void jump(){
	        System.out.println("loncat-loncat!");
	    }
}
class Burung extends Enemy {
    void walk(){
        System.out.println("Burung berjalan");
    }
    void jump(){
        System.out.println("Burung loncat-loncat");
    }
    void fly(){
        System.out.println("Burung Terbang...");
    }
}

public class Inheritance extends Enemy {

	public static void main(String[] args) {
		Enemy monster = new Enemy();            //Memanggil atribut dan method dari class subclass
		Zombie zumbi = new Zombie();
		Pocong hantuPocong = new Pocong();
		Burung garuda = new Burung();

	//method dari class sendiri 	
		monster.attack();                      //Memanggil method dari subclass
		zumbi.walk();
		hantuPocong.jump();
		garuda.fly();
		garuda.jump();
		garuda.walk();                         

	//method dari class inheritance
		zumbi.attack();                        //Subclass bisa menggunakan method dari superclass
		hantuPocong.attack();
		garuda.attack();

	}

}
