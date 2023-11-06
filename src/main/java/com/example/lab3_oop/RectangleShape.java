package com.example.lab3_oop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends Shape {

    private Rectangle rectangle;
    public RectangleShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            rectangle = new Rectangle();
            rectangle.setX(mouseEvent.getX());
            rectangle.setY(mouseEvent.getY());
            rectangle.setWidth(mouseEvent.getX()-rectangle.getX());
            rectangle.setHeight(mouseEvent.getY()-rectangle.getY());
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(null);
            root.getChildren().add(rectangle);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (rectangle != null) {
                rectangle.setWidth(mouseEvent.getX() - rectangle.getX());
                rectangle.setHeight(mouseEvent.getY() - rectangle.getY());
            }
        });

        root.setOnMouseReleased(mouseEvent -> {
            if (rectangle != null) {
                rectangle.setFill(Color.YELLOW);
                rectangle = null;
            }
        });
    }
}
