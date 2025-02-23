package application;

import component.Board;
import component.ControlPane;
import component.StartGamePane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefHeight(750);
		root.setPrefWidth(1200);
		root.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Board board = new Board();
		ControlPane controlPane = new ControlPane();
		
		root.getChildren().addAll(board, controlPane);
		
		StartGamePane startGamePane = new StartGamePane();	

		
		//==============================================================//
		//This one use for test In-Game GUI		
		Scene scene = new Scene(root);
		
		//This one use for test Start-Game GUI	
//		Scene scene = new Scene(startGamePane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Croissonne");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
