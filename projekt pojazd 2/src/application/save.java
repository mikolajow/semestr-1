package application;

import javafx.stage.Modality;
import javafx.stage.Stage;
import pojazdy.dostawczy;
import pojazdy.osobowy;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.collections.ObservableList;


public class save {
	
	public static void zapisz() {
		Font wielkosc= new Font(18);
		Stage window = new Stage();
		window.setMinHeight(200);
		window.setMinWidth(400);
		window.setTitle("Zapisz Zmiany");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label label = new Label("Czy chcesz zapisaæ zmiany?");
		label.setFont(wielkosc);
		Button tak = new Button("Tak");
		tak.setMinHeight(20);
		tak.setMinWidth(60);
		Button nie = new Button("Nie");
		nie.setMinHeight(20);
		nie.setMinWidth(60);
		
		nie.setOnAction(e-> window.close());
		
		tak.setOnAction(e-> {
			zapiszZmiany();
			window.close();
		});

		
		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		layout.setSpacing(30);
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(tak,nie);
		hbox.setSpacing(50);
		layout.getChildren().addAll(label,hbox);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}//koniec zapisz
	
	
	public static void zapiszZmiany() {
		ObservableList<osobowy> tablicaOs = kontroler.getTablicaOs();
		ObservableList<dostawczy> tablicaD = kontroler.getTablicaD();
		
		try {
			FileWriter pisa = new FileWriter("osoboweZapis.txt");
			BufferedWriter pisarz = new BufferedWriter(pisa);
			//pisarz.write("wesfgsefef");
			for ( osobowy i : tablicaOs ) {
				pisarz.write(i.getTyp()  +"/"+ i.getMarka()  +"/"+i.getModel()  +"/"+i.getRokProdukcji()  +"/"+i.getPrzebieg() +"/"+i.getCenaNowego() );
				pisarz.write(System.lineSeparator());
			}//koniec for
			pisarz.close();
		}catch(Exception e) {
			System.out.println("COS SIE POPSULO I NIE BYLO MNIE SLYCHAC");
		}// koniec zapisu dla osobowy
		
		try {
			FileWriter pisa = new FileWriter("dostawczeZapis.txt");
			BufferedWriter pisarz = new BufferedWriter(pisa);
			//pisarz.write("wesfgsefef");
			for ( dostawczy i : tablicaD ) {
				pisarz.write(i.getTyp()  +"/"+ i.getMarka()  +"/"+i.getModel()  +"/"+i.getRokProdukcji()  +"/"+i.getPrzebieg() +"/"+i.getCenaNowego() + "/" + i.getMaxUdzwig() );
				pisarz.write(System.lineSeparator());
			}//koniec for
			pisarz.close();
		}catch(Exception e) {
			System.out.println("COS SIE POPSULO I NIE BYLO MNIE SLYCHAC");
		}
	}//koniec zapisz zmiany
	
}//koniec klasy



