package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameManager {
	
	public static GameManager instance = null;
	
	Stage stage;
	StartGameScene startGameScene;
	InGameScene inGameScene;
	
	Scene scene;
	
	public GameManager(Stage stage) {
		// TODO Auto-generated constructor stub
		instance = this;
		this.stage = stage;
		
		startGameScene = new StartGameScene();
		
		setToStartGameScene();
	}
	
	public void setToStartGameScene() {
		scene = new Scene(startGameScene);
		stage.setScene(scene);
		stage.setTitle("Croissonne");
		stage.show();
	}
	
	public void switchToSelectPlayerScene() {
		startGameScene.removeStartButton();
		startGameScene.addSelectPlayerButton();
	}
	
	public void switchToInGameScene() {
		inGameScene = new InGameScene();
		scene = new Scene(inGameScene);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToEndGameScene() {
		inGameScene.clearControlPane();
		inGameScene.addGameOverText();
		inGameScene.addWinnerText();
		inGameScene.addPlayerStatPane();
		inGameScene.addPlayAgainAndExitButton();
		
	}
	
	public static GameManager getInstance() {
		return instance;
	}

	public StartGameScene getStartGameScene() {
		return startGameScene;
	}

	public InGameScene getInGameScene() {
		return inGameScene;
	}
	
}
