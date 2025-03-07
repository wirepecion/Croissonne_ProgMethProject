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

    private final Button leftHomeButton, rightHomeButton, nextPageButton, prevPageButton;
    private final Pane[] pages;
    private int currentPage = 1;

    public HowToPlayPane() {
        setPrefSize(1200, 750);

        pages = new Pane[]{
            createPage(ImageLoader.getHowToPlayPageOneBackground()),
            createPage(ImageLoader.getHowToPlayPageTwoBackground()),
            createPage(ImageLoader.getHowToPlayPageThreeBackground()),
            createPage(ImageLoader.getHowToPlayPageFourBackground())
        };

        leftHomeButton = initializeButton(-340, -290, e -> goToHome());
        rightHomeButton = initializeButton(380, -290, e -> goToHome());
        prevPageButton = initializeButton(-340, -290, e -> showPage(currentPage - 1));
        nextPageButton = initializeButton(400, -290, e -> showPage(currentPage + 1));

        showPage(1);
    }

    private Pane createPage(Image backgroundImage) {
        Pane page = new Pane();
        page.setBackground(new Background(new BackgroundImage(backgroundImage, null, null, null, null)));
        page.setPrefSize(1200, 750);
        return page;
    }

    private Button initializeButton(double x, double y, javafx.event.EventHandler<javafx.scene.input.MouseEvent> eventHandler) {
        Button button = new Button();
        button.setPrefSize(60, 60);
        button.setTranslateX(x);
        button.setTranslateY(y);
        button.setOpacity(0);
        button.setOnMouseClicked(eventHandler);
        MouseEventHandler.applyHoverEffect(button);
        return button;
    }

    private void showPage(int pageNumber) {
        if (pageNumber < 1 || pageNumber > pages.length) return;

        getChildren().setAll(pages[pageNumber - 1]); // Set current page
        currentPage = pageNumber;

        // Determine which buttons should be displayed
        if (pageNumber == 1) {
            getChildren().addAll(leftHomeButton, nextPageButton);
        } else if (pageNumber == pages.length) {
            getChildren().addAll(prevPageButton, rightHomeButton);
        } else {
            getChildren().addAll(prevPageButton, nextPageButton);
        }
    }

    private void goToHome() {
        GameManager.getInstance().setToStartGamePane();
    }
}