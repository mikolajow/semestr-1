package pojazdy;

import java.io.Serializable;

import srodekTransportuInterface.Sposob;

public abstract class naziemny implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String typ;
	private String marka;
	private String model;
	private int rokProdukcji;
	private int przebieg;  //  8-12 mot  / 18-20 osob / 60-72 ciez / 125 tir 
	private int cenaNowego;
	private int podatek;
	protected Sposob sposobNaGenerowaniePodatku;

	
	public String getTyp() { return typ; }
	public String getMarka() {return marka; }
	public String getModel() { return model; }
	public int getRokProdukcji() { return rokProdukcji; }
	public int getPrzebieg() { return przebieg; }
	public int getCenaNowego() {return cenaNowego;}
	public int getObecnaCena() { return podatek; }
	public Sposob getSposob() { return sposobNaGenerowaniePodatku; }
	
	
	
	public void setSposobNaGenerowaniePodatku(Sposob nowy) {
		this.sposobNaGenerowaniePodatku = nowy;
	}
	
	public void LiczPodatek( ) {
		this.podatek= sposobNaGenerowaniePodatku.generujPodatek(this);
	}
	
	public void zmienCene(int cena) {
		this.cenaNowego=cena;
	}
	
	//KONSTRUKTOR
	
	public naziemny( String typ, String marka, String model, int rokProdukcji, int przebieg, int cena ) {
		this.typ = typ;
		this.marka = marka;
		this.model = model;
		this.rokProdukcji = rokProdukcji;
		this.przebieg = przebieg;
		this.cenaNowego=cena;
	}

}//koniec klasy

