package srodekTransportuInterface;

import java.util.Date;

import pojazdy.naziemny;

public class sposobDlaNiemcy implements Sposob {

	Date d = new Date();
	
	@Override
	public int generujPodatek(naziemny p) {
		int nowa =0; 
		
		nowa = p. getCenaNowego()  /100  * 19;
		
		
		return nowa;
	}
	@Override
	public String toString() {
		return "wybrano sposobDlaNiemcy";
	}
}
