package srodekTransportuInterface;

import java.util.Date;

import pojazdy.naziemny;

public class sposobDlaSamochodu implements Sposob {
	
	Date d = new Date();
	
	@Override
	public int generujCene(naziemny p) {
		int nowa =0; 
		//GENERUJE CENE DLA SAMOCHODU
		if(p.getRokProdukcji()!=d.getYear()+1900) {
		
		nowa = p.getCenaNowego() / (2* (( 1900 + d.getYear())-p.getRokProdukcji()));
		} else nowa = p.getCenaNowego();
			
		return nowa;
	}
	
}
