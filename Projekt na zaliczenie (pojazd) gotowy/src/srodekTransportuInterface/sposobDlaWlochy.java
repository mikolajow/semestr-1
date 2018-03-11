package srodekTransportuInterface;

import java.util.Date;

//import pojazdy.dostawczy;
import pojazdy.naziemny;

public class sposobDlaWlochy implements Sposob {

	Date d = new Date();
	
	@Override
	public String toString() {
		return "wybrano sposobDlaWlochy";
	}

	@Override
	public int generujPodatek(naziemny p) {// GENERUJ LICZ PODATEK
		int nowa =0; 
		
		nowa = p. getCenaNowego() /100   * 22;
		
		return nowa;
	}
	
}
