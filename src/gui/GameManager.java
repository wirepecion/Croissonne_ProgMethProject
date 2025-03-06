package gui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameManager {
	
	public static GameManager instance = null;
	
	Stage stage;
	
	StartGamePane startGamePane;
	SelectPlayerPane selectPlayerPane;
	SelectColorPane selectColorPane;
	HowToPlayPane howToPlayPane;
	
	InGameScene inGameScene;
	
	Scene scene;
	
	public GameManager(Stage stage) {
		// TODO Auto-generated constructor stub
		instance = this;
		this.stage = stage;
		startGamePane = new StartGamePane();
		setToStartGamePane();
	}
	
	public void setToStartGamePane() {
		startGamePane = new StartGamePane();
		scene = new Scene(startGamePane);
		showStage();
	}
	
	public void switchToSelectPlayerPane() {
		selectPlayerPane = new SelectPlayerPane();
		scene = new Scene(selectPlayerPane);
		showStage();
	}
	
	public void switchToSelectColorPane() {
		selectColorPane = new SelectColorPane();
		scene = new Scene(selectColorPane);
		showStage();
	}
	
	public void switchToHowToPlayScene() {
		howToPlayPane = new HowToPlayPane();
		scene = new Scene(howToPlayPane);
		showStage();
	}
	
	
	public void switchToInGameScene() {
		inGameScene = new InGameScene();
		scene = new Scene(inGameScene);
		showStage();
	}
	public void switchToEndGameScene() {
		inGameScene.clearControlPane();
		inGameScene.addGameOverText();
		inGameScene.addWinnerText();
		inGameScene.addPlayerStatPane();
		inGameScene.addExitOption();
		
	}
	
	private void showStage() {
		stage.setScene(scene);
		stage.setTitle(scene.toString());
		stage.show();
	}
	
	public static GameManager getInstance() {
		return instance;
	}
	
	public InGameScene getInGameScene() {
		return inGameScene;
	}
}
