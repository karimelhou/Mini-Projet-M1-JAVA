package Parking;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;
public class Traitement {


    public static void Monter(Voiture c, int vx, int vy) {

        while (vx > -50 && vx < 30 && vy >= 150) {
            c.image(2);
            vy -= 10;
            c.setLocation(vx, vy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        c.posx = vx;
        c.posy = vy;
    }

    static void Avancer(Voiture C, int vx, int vy, int i) {

        while (vx > -50 && vx <= i) {
            C.image(1);
            vx += 15;
            C.setLocation(vx, vy - 40);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        C.posx = vx;
        C.posy = vy;
    }

    public static void Stationner(Voiture c, int vx, int vy) {
        while (vy >= -20) {
            c.image(2);
            vy -= 10;
            c.setLocation(vx, vy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        c.posx = vx;
        c.posy = vy;
    }

    public static void MarcheArrier(Voiture c, int vx, int vy) {

        while (vy <= 90) {
            vy += 5;
            c.setLocation(vx, vy - 45);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        c.posx = vx;
        c.posy = vy;
    }

    public static void sortir(Voiture c, int vx, int vy) {
        while (vx <= 1500) {
            c.image(1);
            vx += 10;
            c.setLocation(vx, vy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        c.posx = vx;
        c.posy = vy;
    }

}
