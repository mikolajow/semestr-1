package srodekTransportuInterface;

import java.util.Date;

import pojazdy.naziemny;

public class sposobDlaPolska implements Sposob {
	
	Date d = new Date();
	
	@Override
	public int generujPodatek(naziemny p) {
		int nowa =0; 
		//GENERUJE CENE DLA SAMOCHODU
		
		nowa = p. getCenaNowego() /100 *23;
			
		return nowa;
	}
	@Override
	public String toString() {
		return "wybrano sposobDlaPolska";
	}
}
