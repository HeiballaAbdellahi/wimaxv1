package wimax;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	
	Stage s;
	BorderPane b;
	

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		
		this.s=primaryStage;
		this.s.setTitle("WIMAX Project");
		
		showMainview();
		
		
	}

	public void showMainview() throws IOException {
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/wim.fxml"));
		b=loader.load();
		Scene ss=new Scene(b);
		s.setScene(ss);
		
		s.show();
//		CategoryAxis x=new CategoryAxis();
//		x.setLabel("cycles");
//		NumberAxis y=new NumberAxis();
//		y.setLabel("users");
//		
		

	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
