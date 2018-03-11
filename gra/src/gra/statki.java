package gra;

public class statki {
	private int ileTrafien=0;
	private int [] polozenieStatku;
	
	public void setpolozenieStatku(int [] pos) {
	polozenieStatku=pos;
	} //koniec metody
	
	public void sprawdz(String str){
		int strzal = Integer.parseInt(str);
		String wynik= "pudlo";
		for (int i=0; i<polozenieStatku.length; i++ ) {
			if ( strzal==polozenieStatku[i] ) {
				wynik="trafienie";
				ileTrafien++;
				if (ileTrafien==polozenieStatku.length)
					wynik="zatopiony";
			}//koniec if
		}//koniec petli for
		System.out.println(wynik);
	}//koniec metody
	
}//koniec klasy
