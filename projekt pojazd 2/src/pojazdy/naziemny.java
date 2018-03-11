package pojazdy;

import java.io.Serializable;

import srodekTransportuInterface.Sposob;

public abstract class naziemny implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	protected String typ;
	protected String marka;
	protected String model;
	protected int rokProdukcji;
	protected int przebieg;  //  8-12 mot  / 18-20 osob / 60-72 ciez / 125 tir 
	protected int cenaNowego;
	protected int obecnaCena;
	protected Sposob sposobNaGenerowanieCeny;

	
	public String getTyp() { return typ; }
	public String getMarka() {return marka; }
	public String getModel() { return model; }
	public int getRokProdukcji() { return rokProdukcji; }
	public int getPrzebieg() { return przebieg; }
	public int getCenaNowego() {return cenaNowego;}
	public int getObecnaCena() { return obecnaCena; }
	public Sposob getSposob() { return sposobNaGenerowanieCeny; }
	
	
	
	public void setSposobNaGenerowanieCeny(Sposob nowy) {
		this.sposobNaGenerowanieCeny = nowy;
	}
	
	public void setObecnaCena( ) {
		this.obecnaCena= sposobNaGenerowanieCeny.generujCene(this);
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

