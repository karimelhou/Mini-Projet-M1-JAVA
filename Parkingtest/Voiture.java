/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author HP
 */

public class Voiture implements Runnable { 
	String nom; 
	Parking park;
	
	public Voiture(String name, Parking park){
		this.nom=name; 
		this.park=park; 
	}
	public String toString(){ return this.nom;} 
	
	public void rentrer() throws InterruptedException{	
		while (!(this.park.accept(this)))
		{
            Thread.sleep((long)  (1000* Math.random()));
    		System.out.format("[%s]  : Je redemande Ã  rentrer  \n", this.nom);
		}
	}
	
	public void run(){ 
	System.out.format("[%s]: Je dÃ©bute !  \n", this.nom);
	try {
		
	while(true){
		Thread.sleep((long)  (50000* Math.random()));
		System.out.format("[%s]: Je demande Ã  rentrer  \n", this.nom);
		this.rentrer();
		System.out.format("[%s]: Je viens d'entrer \n", this.nom);
		Thread.sleep((long)  (50000* Math.random()));
	    System.out.format("[%s]: Je demande Ã  sortir  \n", this.nom);
	    this.park.leave(this);  

	}}
	catch (InterruptedException e) {
		e.printStackTrace();	}
	}
	public String getNom(){
            return nom;
        }
	
	public static void main(String[] args) {
		
		int TailleParking=8;
		int nbVoitures=15; 
		Parking leParking = new Parking(TailleParking);
		
		
		
		Thread MesVoitures[] = new Thread[nbVoitures];

		for (int i =0; i< nbVoitures; i++){
			MesVoitures[i]= new Thread(new Voiture(String.format("Voit %d ", i) , leParking));
			MesVoitures[i].start();
		}
		
	}
}