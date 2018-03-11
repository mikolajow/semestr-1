package pojazdy;

import srodekTransportuInterface.sposobDlaSamochodu;

public class osobowy extends naziemny {
	

	private static final long serialVersionUID = 1L;
	
	//KONSTRUKTOR
	public osobowy( String typ, String marka, String model, int rokProdukcji, int przebieg, int cena ) {
		super(typ, marka, model, rokProdukcji, przebieg, cena);
		this.obecnaCena=0;
		sposobNaGenerowanieCeny = new sposobDlaSamochodu();
	}
	
	
	public String toString() {
		return model;
	}
	

	
	
}//koniec klasy
