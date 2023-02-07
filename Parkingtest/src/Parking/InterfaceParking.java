
package Parking;
import java.awt.*;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class InterfaceParking extends JPanel{
    ImageIcon image;
    static boolean[] Place ;
    static Semaphore semaphore ;

    public InterfaceParking(){

        semaphore =new Semaphore(1);
        Place =new boolean[4];
        for(int i=0 ; i<Place.length;i++)
        {
            Place[i]=false ;
        }
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        image =new ImageIcon("parki.png");
        image.paintIcon(this, g, WIDTH,WIDTH);
    }

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Simulation de la gestion d'un parking");
        InterfaceParking panel = new InterfaceParking();
        frame.setContentPane(panel);
        panel.setLayout(null);
        frame.setSize(830, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Voiture c1 = new Voiture();
        Voiture c2 = new Voiture();
        Voiture c3 = new Voiture();
        Voiture c4 = new Voiture();
        Voiture c5 = new Voiture();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        Thread t5 = new Thread(c5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        panel.add(c1);
        panel.add(c2);
        panel.add(c3);
        panel.add(c4);
        panel.add(c5);


    }

}
