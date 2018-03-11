package application;
	
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static Date aktualnaData;
	
	@Override
	public void start(Stage window) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root);
			
			window.setOnCloseRequest(e-> {
				
				save.zapisz();
				
			});
			
			window.setMinHeight(800);
			window.setMinWidth(1200);
			window.setTitle("Miko³aj Kasperek Informatyka W8");
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}//koniec main
}//koniec klasy

	

