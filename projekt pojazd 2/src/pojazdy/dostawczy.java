package pojazdy;

import srodekTransportuInterface.sposobDlaCiezarowki;

public class dostawczy extends naziemny {
	
	private static final long serialVersionUID = 1L;
	
	
	private double maxUdzwig;
	
	//KONSTRUKTOR
	public dostawczy ( String typ, String marka, String model, int rokProdukcji, int przebieg, int cena, double maxUdzwig ){
		super(typ, marka, model, rokProdukcji, przebieg, cena);
		this.maxUdzwig = maxUdzwig;
		this.obecnaCena=0;
		sposobNaGenerowanieCeny = new sposobDlaCiezarowki();
	}
	
		
	
	//GETER
	public double getMaxUdzwig() { return maxUdzwig; }
	
	public String toString() {return model;}
	
	
	
}
