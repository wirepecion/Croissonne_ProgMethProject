package gui;

import data.ImageLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import utils.MouseEventHandler;

public class HowToPlayPane extends StackPane {
	
	private Button leftHomeButton;
	private Button rightHomeButton;
	private Button nextPageButton;
	private Button prevPageButton;
	
	private Pane howToPlayPageOne;
	private Pane howToPlayPageTwo;
	private Pane howToPlayPageThree;
	private Pane howToPlayPageFour;
	
	private int currentPage = 1;

	public HowToPlayPane() {
		setPrefHeight(750);
		setPrefWidth(1200);
		
		initializePages();
		showPage(1); // Start with page 1
	}

	private void initializePages() {
		// Initialize all pages
		howToPlayPageOne = createPage(ImageLoader.getHowToPlayPageOneBackground());
		howToPlayPageTwo = createPage(ImageLoader.getHowToPlayPageOneBackground());
		howToPlayPageThree = createPage(ImageLoader.getHowToPlayPageOneBackground());
		howToPlayPageFour = createPage(ImageLoader.getHowToPlayPageOneBackground());

		// Initialize buttons
		initializeHomeButton();
		initializeNextPageButton();
//		initializePrevPageButton();
	}

	private void initializePages() {
		// Initialize all pages
		howToPlayPageOne = createPage(ResourceLoader.getHowToPlayPageOneBackground());
		howToPlayPageTwo = createPage(ResourceLoader.getHowToPlayPageTwoBackground());
		howToPlayPageThree = createPage(ResourceLoader.getHowToPlayPageThreeBackground());
		howToPlayPageFour = createPage(ResourceLoader.getHowToPlayPageFourBackground());

		// Initialize buttons
		initializeLeftHomeButton();
		initializeRightHomeButton();
		initializeNextPageButton();
		initializePrevPageButton();
	}

	private Pane createPage(Image backgroundImage) {
		Pane page = new Pane();
		page.setBackground(new Background(new BackgroundImage(backgroundImage, null, null, null, null)));
		page.setPrefHeight(750);
		page.setPrefWidth(1200);
		return page;
	}

	private void initializeLeftHomeButton() {
		leftHomeButton = new Button();
		leftHomeButton.setPrefHeight(62);
		leftHomeButton.setPrefWidth(62);
		leftHomeButton.setTranslateX(-340);
		leftHomeButton.setTranslateY(-290);
		leftHomeButton.setOpacity(0);
		leftHomeButton.setOnMouseClicked(e -> {
			GameManager.getInstance().setToStartGamePane();
		});
		MouseEventHandler.applyHoverEffect(leftHomeButton);
	}
	
	private void initializeRightHomeButton() {
		rightHomeButton = new Button();
		rightHomeButton.setPrefHeight(62);
		rightHomeButton.setPrefWidth(62);
		rightHomeButton.setTranslateX(380);
		rightHomeButton.setTranslateY(-290);
		rightHomeButton.setOpacity(0);
		rightHomeButton.setOnMouseClicked(e -> {
			GameManager.getInstance().setToStartGamePane();
		});
		MouseEventHandler.applyHoverEffect(rightHomeButton);
	}

	private void initializeNextPageButton() {
		nextPageButton = new Button();
		nextPageButton.setPrefHeight(60);
		nextPageButton.setPrefWidth(60);
		nextPageButton.setTranslateX(400);
		nextPageButton.setTranslateY(-290);
		nextPageButton.setOpacity(0);
		nextPageButton.setOnMouseClicked(e -> showPage(currentPage + 1));
		MouseEventHandler.applyHoverEffect(nextPageButton);
	}

	private void initializePrevPageButton() {
		prevPageButton = new Button();
		prevPageButton.setPrefHeight(60);
		prevPageButton.setPrefWidth(60);
		prevPageButton.setTranslateX(-340);
		prevPageButton.setTranslateY(-290);
		prevPageButton.setOpacity(0);
		prevPageButton.setOnMouseClicked(e -> showPage(currentPage - 1));
		MouseEventHandler.applyHoverEffect(prevPageButton);
	}

	private void showPage(int pageNumber) {
		getChildren().clear();
		currentPage = pageNumber;

		Pane currentPane = switch (pageNumber) {
			case 1 -> howToPlayPageOne;
			case 2 -> howToPlayPageTwo;
			case 3 -> howToPlayPageThree;
			case 4 -> howToPlayPageFour;
			default -> throw new IllegalArgumentException("Invalid page number");
		};

		getChildren().add(currentPane);

		// Add buttons based on the current page
		if (pageNumber == 1) {
			getChildren().addAll(leftHomeButton, nextPageButton);
		} else if (pageNumber == 4){
			getChildren().addAll(prevPageButton, rightHomeButton);
		} else {
			getChildren().addAll(prevPageButton, nextPageButton);
		}
	}
}
