package contohgui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;


class Latihan7c extends JFrame{
private Container ctn  = new Container();

public Latihan7c(String title) {

setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
setSize(300,150);
setLocation (200,150); 
setTitle (title);

ctn = getContentPane();
ctn.add(new JButton("Tombol 1"), BorderLayout.PAGE_START);

ctn.add(new JButton("Tombol 2"), BorderLayout.CENTER); 
ctn.add(new JButton("Tombol 3"), BorderLayout.LINE_START);

ctn.add(new JButton("Tombol 4"), BorderLayout.PAGE_END);

ctn.add(new JButton("Tombol 5"), BorderLayout.LINE_END);
setVisible(true);

}

public static void main(String args[]){ 

    JFrame.setDefaultLookAndFeelDecorated(true);
    new Latihan7c("Window Utama");
    }
}
