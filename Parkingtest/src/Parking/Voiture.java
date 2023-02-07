
package Parking;


import java.awt.*;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
public class Voiture extends JLabel implements Runnable {

    ImageIcon voiture ;
    int posx;
    int posy;

    public Voiture()
    {
        this.posx=12;
        this.posy=600 ;
        voiture=new ImageIcon("2.png");
        this.setIcon(voiture);
        Dimension size = this.getPreferredSize();
        setBounds(posx, posy, 250,236);
    }

    public void image(int i)
    {
        voiture=new ImageIcon(i+".png");
        this.setIcon(voiture);
    }
    public void setImage(int i) {
        voiture=new ImageIcon(i+".png");
        this.setIcon(voiture);
    }


    public void entrer()
    {
        System.out.println("Car is entering the parking lot");

        Traitement.Monter(this, this.posx, this.posy);
        if(InterfaceParking.Place[0]==false)
        {

            Traitement.Stationner(this, this.posx, this.posy);
            InterfaceParking.Place[0]=true;
            System.out.println("Car is parked at position: " + 1);

        }
        else
        {
            Traitement.Avancer(this, this.posx, this.posy, 170);
            if(InterfaceParking.Place[1]==false)
            {
                Traitement.Stationner(this, this.posx, this.posy);
                InterfaceParking.Place[1]=true;
                System.out.println("Car is parked at position: " + 2);

            }
            else
            {
                Traitement.Avancer(this, this.posx, this.posy,328);
                if(InterfaceParking.Place[2]==false)
                {
                    Traitement.Stationner(this, this.posx, this.posy);
                    InterfaceParking.Place[2]=true;
                    System.out.println("Car is parked at position: " + 3);

                }
                else
                {
                    Traitement.Avancer(this, this.posx, this.posy,480);
                    if(InterfaceParking.Place[3]==false)
                    {
                        Traitement.Stationner(this, this.posx, this.posy);
                        InterfaceParking.Place[3]=true;
                        System.out.println("Car is parked at position: " + 4);

                    }
                    else {
                        Traitement.Avancer(this, this.posx, this.posy, 1000);
                    }
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sortir()
    {
        System.out.println("Car is exiting the parking lot");

        if(this.posx>=-100 && this.posx<=50)
        {
            Traitement.MarcheArrier(this, posx, posy);
            Traitement.sortir(this, posx, posy);
            InterfaceParking.Place[0]=false;
            //System.out.println("position: " + 1 + "  is empty now");

        }
        if(this.posx>=50 && this.posx<=200)
        {
            Traitement.MarcheArrier(this, posx, posy);
            Traitement.sortir(this, posx, posy);
            InterfaceParking.Place[1]=false;
            //System.out.println("position: " + 2 + "  is empty now");

        }
        if(this.posx>=200 && this.posx<=350)
        {
            Traitement.MarcheArrier(this, posx, posy);
            Traitement.sortir(this, posx, posy);
            InterfaceParking.Place[2]=false;
            //System.out.println("position: " + 3 + "  is empty now");

        }
        if(this.posx>=350 && this.posx<=500)
        {
            Traitement.MarcheArrier(this, posx, posy);
            Traitement.sortir(this, posx, posy);
            InterfaceParking.Place[3]=false;
            //System.out.println("position: " + 4 + "  is empty now");

        }

    }

    public void run()
    {

        try
        {
            int r= (int)(Math.random() * 2) + 1 ;
            int t = new Random().nextInt(4) + 1;
            setImage(t);



            InterfaceParking.semaphore.acquire();
            entrer();
            InterfaceParking.semaphore.release();

            if(r==1) Thread.sleep(5000);

            InterfaceParking.semaphore.acquire();
            sortir();

            InterfaceParking.semaphore.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}




