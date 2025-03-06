package gui;

import java.util.ArrayList;

import data.ResourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.MouseEventHandler;
import utils.PlayerColor;

public class SelectColorPane extends Pane {

    private static final int GRID_COLS = 3; // Number of columns
    private static final int PADDING = 63; // Space between colors
    private static final int COLOR_SIZE = 70;

    private GridPane colorPane;

    private int chosenPlayerColor = 0;

    public SelectColorPane() {
    	
    	colorPane = new GridPane();
    	colorPane.setLayoutX(280);
    	colorPane.setLayoutY(330);
    	colorPane.setHgap(PADDING);
    	colorPane.setVgap(PADDING);
    	
        initializeColor();

        setPrefHeight(750);
        setPrefWidth(1200);


        // Add the colorPane to this pane
        getChildren().add(colorPane);

        setBackground(new Background(new BackgroundImage(ResourceLoader.getSelectColorBackgroundImage(), null, null, null, null)));
    }

    private void initializeColor() {

        int col = 0, row = 0;

        for (PlayerColor playerColor : PlayerColor.values()) {
            Canvas canvas = new Canvas(COLOR_SIZE, COLOR_SIZE);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.valueOf(playerColor.name()));
            gc.fillOval(0, 0, COLOR_SIZE, COLOR_SIZE);

            // Set event handlers
            canvas.setOnMouseClicked(event -> chooseColor(playerColor));
            MouseEventHandler.applyHoverEffect(canvas);

            // Add canvas to the GridPane (colorPane) at (col, row)
            colorPane.add(canvas, col, row);

            // Update column and row for next item
            col++;
            if (col == GRID_COLS) { // Reset column and move to next row after 3 items
                col = 0;
                row++;
            }
        }
    }

    private void chooseColor(PlayerColor playerColor) {
        System.out.println(playerColor.name());
        GameLogic.addPlayerColor(playerColor);
        chosenPlayerColor++;
        if (chosenPlayerColor == GameLogic.getNumberOfPlayer())
            GameManager.getInstance().switchToInGameScene();
    }

    private void MouseEnteredHandler() {
        setCursor(Cursor.HAND);
    }

    private void MouseExitedHandler() {
        setCursor(Cursor.DEFAULT);
    }
}
