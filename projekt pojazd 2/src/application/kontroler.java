package application;

import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojazdy.dostawczy;
import pojazdy.osobowy;
import srodekTransportuInterface.Sposob;
import srodekTransportuInterface.SposobDlaTira;
import srodekTransportuInterface.sposobDlaCiezarowki;
import srodekTransportuInterface.sposobDlaMotoru;
import srodekTransportuInterface.sposobDlaSamochodu;

public class kontroler {
	
	private static ObservableList<osobowy> tablicaOs = FXCollections.observableArrayList();
	private static ObservableList<dostawczy> tablicaD = FXCollections.observableArrayList();
	
	public static ObservableList<osobowy> getTablicaOs() { return tablicaOs;}
	public static ObservableList<dostawczy> getTablicaD() { return tablicaD; }
	
	
	//drukuje arraylisty 
	public void drukujOs(){ 
		for (int i=0 ; i< tablicaOs.size() ; i++) {
			System.out.println( tablicaOs.get(i) );
		 }}
	public void drukujD(){ 
		for (int i=0 ; i< tablicaD.size() ; i++) {
			System.out.println( tablicaD.get(i) );
		 }}
	//------------------------------------------------------------------------------------------------------------------------------
	//WCZYTAJ Z PLIKU dodaje do arrylist
	//OSOBOWE
	
	public ComboBox<String> comboOs;
	
	public void wczytajOs(){
		try {
		comboOs.getItems().addAll(
			"Dla Samochodu",
			"Dla Motoru"
			);	
		FileReader czyt = new FileReader("osoboweZapis.txt");
		BufferedReader czytnik = new BufferedReader(czyt);
		String wiersz;
		while ((wiersz = czytnik.readLine()) != null) {
			dodajObiektOs(wiersz);
		}//koniec while
		czytnik.close();
		} catch (Exception e) {
			System.out.println("nie mozna znalezæ pliku");
			e.printStackTrace();
		}
	}//koniec wczytaj
	
	public void dodajObiektOs(String wierszDanych) {
		String[] dane = wierszDanych.split("/");
		osobowy obiekt = new osobowy(dane[0], dane[1], dane[2], Integer.parseInt(dane[3]), Integer.parseInt(dane[4]), Integer.parseInt(dane[5]));
		tablicaOs.add(obiekt);
	}//koniec dodaj obiektOS
	
	//DOSTAWCZE
	
	public ComboBox<String> comboD;
	
	public void wczytajD(){
		try {
		comboD.getItems().addAll(
				"Dla Ciêzarówki",
				"Dla Tira"
				);
		FileReader czyt = new FileReader("dostawczeZapis.txt");
		BufferedReader czytnik = new BufferedReader(czyt);
		String wiersz;
		while ((wiersz = czytnik.readLine()) != null) {
			dodajObiektD(wiersz);
		}//koniec while
		czytnik.close();
		} catch (Exception e) {
			System.out.println("nie mozna znalezæ pliku");
			e.printStackTrace();
		}
	}//koniec wczytaj
	
	public void dodajObiektD(String wierszDanych) {
		String[] dane = wierszDanych.split("/");
		dostawczy obiekt = new dostawczy(dane[0], dane[1], dane[2], Integer.parseInt(dane[3]), Integer.parseInt(dane[4]), Integer.parseInt(dane[5]),Double.parseDouble(dane[6]) );
		tablicaD.add(obiekt);
		
	}//koniec dodaj obiektOS
	//LISTY----------------------------------------------------------------------------------------------------------------
	//TABLICA OSOBOWYCH
	public TableColumn<osobowy, String> kolumnaTypOs;
	public TableColumn<osobowy, String> kolumnaMarkaOs;
	public TableColumn<osobowy, String> kolumnaModelOs;
	public TableColumn<osobowy, Integer> kolumnaRokProdukcjiOs;
	public TableColumn<osobowy, Integer> kolumnaPrzebiegOs;
	public TableColumn<osobowy, Integer> kolumnaCenaOs;
	public TableColumn<osobowy, Integer> proponowanaCenaOs;
	public TableView<osobowy> tabelaOsobowy;
	public MenuItem menuZaladujOs;
	
	public void wypelnijOs() {
		wczytajOs();
		kolumnaTypOs.setCellValueFactory( new PropertyValueFactory<>("typ"));
		kolumnaMarkaOs.setCellValueFactory( new PropertyValueFactory<>("marka"));
		kolumnaModelOs.setCellValueFactory( new PropertyValueFactory<>("model"));
		kolumnaRokProdukcjiOs.setCellValueFactory( new PropertyValueFactory<>("rokProdukcji"));
		kolumnaPrzebiegOs.setCellValueFactory( new PropertyValueFactory<>("przebieg"));
		kolumnaCenaOs.setCellValueFactory( new PropertyValueFactory<>("cenaNowego"));
		proponowanaCenaOs.setCellValueFactory(new PropertyValueFactory<>("obecnaCena"));
		tabelaOsobowy.setItems(tablicaOs);
		menuZaladujOs.setDisable(true);
	}
	
	//TABLICA DOSTAWCZYCH
	public TableColumn<dostawczy, String> kolumnaTypD;
	public TableColumn<dostawczy, String> kolumnaMarkaD;
	public TableColumn<dostawczy, String> kolumnaModelD;
	public TableColumn<dostawczy, Integer> kolumnaRokProdukcjiD;
	public TableColumn<dostawczy, Integer> kolumnaPrzebiegD;
	public TableColumn<dostawczy, Integer> kolumnaCenaD;
	public TableColumn<dostawczy, Double> kolumnaMaxUD;
	public TableColumn<dostawczy, Integer> proponowanaCenaD;
	public TableView<dostawczy> tabelaDostawczy;
	public MenuItem menuZaladujD;
	
	public void wypelnijD() {
		wczytajD();
		kolumnaTypD.setCellValueFactory( new PropertyValueFactory<>("typ"));
		kolumnaMarkaD.setCellValueFactory( new PropertyValueFactory<>("marka"));
		kolumnaModelD.setCellValueFactory( new PropertyValueFactory<>("model"));
		kolumnaRokProdukcjiD.setCellValueFactory( new PropertyValueFactory<>("rokProdukcji"));
		kolumnaPrzebiegD.setCellValueFactory( new PropertyValueFactory<>("przebieg"));
		kolumnaCenaD.setCellValueFactory( new PropertyValueFactory<>("cenaNowego"));
		kolumnaMaxUD.setCellValueFactory( new PropertyValueFactory<>("maxUdzwig"));
		proponowanaCenaD.setCellValueFactory(new PropertyValueFactory<>("obecnaCena"));
		tabelaDostawczy.setItems(tablicaD);
		menuZaladujD.setDisable(true);
	}
	//----------------------------------------------------------------------------------------------------------------------------------------
	// METODA PRZYCISKU DODAJ
	public TextField textTyp;
	public TextField textMarka;
	public TextField textModel;
	public TextField textRokProdukcji;
	public TextField textPrzebieg;
	public TextField textCena;
	public TextField textUdzwig;
	
	public void dodaj() {
		String typ;
		String marka;
		String model;
		int rokProdukcji=0;
		int przebieg=0;
		int cena=0;
		double maxUdzwig = 0.0;
		if (!textTyp.equals("") && !textMarka.equals("") && !textModel.equals("") && !textRokProdukcji.equals("") && !textPrzebieg.equals("") && !textCena.equals("") && textUdzwig.getText().equals("")) {
			//dodaja osobowy do arraylisty
			try {
				typ = textTyp.getText();
				marka = textMarka.getText();
				model = textModel.getText();
				rokProdukcji = Integer.parseInt(textRokProdukcji.getText());
				przebieg = Integer.parseInt(textPrzebieg.getText());
				cena= Integer.parseInt(textCena.getText());
				osobowy nowy = new osobowy(typ, marka, model, rokProdukcji, przebieg, cena);
				tablicaOs.add(nowy);
			}catch(NumberFormatException e) {
				//System.out.println("PODANO Z£E WARTOŒCI");
				//e.printStackTrace();
			} finally {
				textTyp.clear();
				textMarka.clear();
				textModel.clear();
				textRokProdukcji.clear();
				textPrzebieg.clear();
				textCena.clear();
				textUdzwig.clear();
			}
			
		}else if(!textTyp.equals("") && !textMarka.equals("") && !textModel.equals("") && !textRokProdukcji.equals("") && !textPrzebieg.equals("") && !textCena.equals("") && !textUdzwig.equals("")) {
			//wszystkie rozne od "" wiec dodaje dostawczy
			try {
				typ = textTyp.getText();
				marka = textMarka.getText();
				model = textModel.getText();
				rokProdukcji = Integer.parseInt(textRokProdukcji.getText());
				przebieg = Integer.parseInt(textPrzebieg.getText());
				cena= Integer.parseInt(textCena.getText());
				maxUdzwig = Double.parseDouble(textUdzwig.getText());
				dostawczy nowy = new dostawczy(typ, marka, model, rokProdukcji, przebieg, cena, maxUdzwig);
				tablicaD.add(nowy);
			}catch(NumberFormatException e) {
				//System.out.println("PODANO Z£E WARTOŒCI");
				//e.printStackTrace();
			} finally {
				textTyp.clear();
				textMarka.clear();
				textModel.clear();
				textRokProdukcji.clear();
				textPrzebieg.clear();
				textCena.clear();
				textUdzwig.clear();
			}
		}//koniec else if
	}//koniec dodaj
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------------------------
	public void usunOs() {
		osobowy usuwany;
		usuwany = tabelaOsobowy.getSelectionModel().getSelectedItem();
		tablicaOs.remove(usuwany);
	}
		
	public void usunD() {
		dostawczy usuwany;
		usuwany = tabelaDostawczy.getSelectionModel().getSelectedItem();
		tablicaD.remove(usuwany);
	}
	//--------------------------------------------------------------------------------------------------------------
	
	public TextField NowaCenaOs;
	public TextField NowaCenaD;
	
	public void zmienCeneOs() {
		try {
			osobowy zmienna;
			int cena;
			if( ((zmienna = tabelaOsobowy.getSelectionModel().getSelectedItem() ) !=null) && !NowaCenaOs.getText().equals("") ){
			cena = Integer.parseInt(NowaCenaOs.getText());
			
			zmienna.zmienCene(cena);
			
			tabelaOsobowy.refresh();
			
			}//koniec if
			NowaCenaOs.clear();
		}catch (NumberFormatException e) {
		//	e.printStackTrace();
		}finally {
			NowaCenaOs.clear();
		}
	}
	
	public void zmienCeneD() {
		try {
			dostawczy zmienna;
			int cena;
			if( ((zmienna = tabelaDostawczy.getSelectionModel().getSelectedItem() ) !=null) && !NowaCenaD.getText().equals("") ){
			cena = Integer.parseInt(NowaCenaD.getText());
			
			//tablicaD.remove(zmienna);
			zmienna.zmienCene(cena);
			
			//tablicaD.add(zmienna);
			tabelaDostawczy.refresh();
			}//koniec if
		}catch (NumberFormatException e) {
		//	e.printStackTrace();
		}finally {
			NowaCenaD.clear();
		}
	}
	
	// OGARNAC COMBO-BOXA / MA ZMIENIAC CENE NA PODSTAWIE DOSTEPNYCH DANYCH KOZYSTAJAC Z sposobNaGenerowanieCeny
	//PRZY KLIKNIECIU POLA 
	
	//ZMIEN OBECNA CENE NA PODSTAWIE SPOSOBU   cenaNowego		obecnaCena 		comboOs		tabelaOsobowy
	
	public void aktualizujCeneOs() {
		try {
		osobowy nowy= tabelaOsobowy.getSelectionModel().getSelectedItem();
		
		Sposob wybrany;
		if (comboOs.getSelectionModel().getSelectedItem().equals("Dla Samochodu")) {
			wybrany = new sposobDlaSamochodu();
		}else wybrany = new sposobDlaMotoru();
		
		nowy.setSposobNaGenerowanieCeny(wybrany);
		
		nowy.setObecnaCena();
		
		tabelaOsobowy.refresh();
		
		} catch(NullPointerException e) {
		System.out.println("NIE MA ZAZNACZONEGO");
		}
	}
	
	public void aktualizujCeneD() {
		try {
		dostawczy nowy= tabelaDostawczy.getSelectionModel().getSelectedItem();
		Sposob wybrany;
		
		if (comboD.getSelectionModel().getSelectedItem().equals("Dla Ciêzarówki")) {
			wybrany = new sposobDlaCiezarowki();
		}else wybrany = new SposobDlaTira();
		
		nowy.setSposobNaGenerowanieCeny(wybrany);
		
		nowy.setObecnaCena();
		
		tabelaDostawczy.refresh();
		
		} catch(NullPointerException e) {
		System.out.println("NIE MA ZAZNACZONEGO");
		}
	}
		
}// KONIEC KONTROLERA







