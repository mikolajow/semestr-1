package pojazdy;

import srodekTransportuInterface.sposobDlaWlochy;

public class dostawczy extends naziemny {
	
	private static final long serialVersionUID = 1L;
	
	
	private double maxUdzwig;
	
	//KONSTRUKTOR
	public dostawczy ( String typ, String marka, String model, int rokProdukcji, int przebieg, int cena, double maxUdzwig ){
		super(typ, marka, model, rokProdukcji, przebieg, cena);
		this.maxUdzwig = maxUdzwig;
		//this.podatek=0;
		sposobNaGenerowaniePodatku = new sposobDlaWlochy();
	}
	
		
	
	//GETER
	public double getMaxUdzwig() { return maxUdzwig; }
	
	public String toString() {return this.getModel();}
	
	
	
}
