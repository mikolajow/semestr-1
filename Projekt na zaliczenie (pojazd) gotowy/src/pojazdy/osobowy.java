package pojazdy;

import srodekTransportuInterface.sposobDlaPolska;

public class osobowy extends naziemny {
	

	private static final long serialVersionUID = 1L;
	
	//KONSTRUKTOR
	public osobowy( String typ, String marka, String model, int rokProdukcji, int przebieg, int cena ) {
		super(typ, marka, model, rokProdukcji, przebieg, cena);
		//this.LiczPodatek();
		sposobNaGenerowaniePodatku = new sposobDlaPolska();
	}
	
	
	public String toString() {
		return this.getModel();
	}
	

	
	
}//koniec klasy
