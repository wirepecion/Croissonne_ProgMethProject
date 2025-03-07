package utils;

import javafx.scene.Cursor;
import javafx.scene.Node;

public class MouseEventHandler {

    public static void applyHoverEffect(Node node) {
        node.setOnMouseEntered(event -> node.getScene().setCursor(Cursor.HAND));
        node.setOnMouseExited(event -> node.getScene().setCursor(Cursor.DEFAULT));
    }
}
