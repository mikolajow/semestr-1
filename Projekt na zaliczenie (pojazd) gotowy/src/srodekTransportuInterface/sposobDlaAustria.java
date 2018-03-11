package srodekTransportuInterface;

import java.util.Date;

//import pojazdy.dostawczy;
import pojazdy.naziemny;

public class sposobDlaAustria implements Sposob{

	Date d = new Date();
	
	@Override
	public int generujPodatek(naziemny p) {
		int nowa =0; 
		
		nowa = p. getCenaNowego()  /100  * 20  ;
		
		return nowa;
	}
	@Override
	public String toString() {
		return "wybrano sposobDlaAustria" ;
	}
}
