package srodekTransportuInterface;

import java.util.Date;

//import pojazdy.dostawczy;
import pojazdy.naziemny;

public class SposobDlaTira implements Sposob{

	Date d = new Date();
	
	@Override
	public int generujCene(naziemny p) {
		int nowa =0; 
		//GENERUJE CENE DLA TIRA
		//dostawczy dost = (dostawczy) p;
		
		if(p.getRokProdukcji()!=d.getYear()+1900) {
		
		nowa = p.getCenaNowego() / (4* (( 1900 + d.getYear())-p.getRokProdukcji()));
		
		} else nowa = p.getCenaNowego();
		
		return nowa;
	}
	
}
