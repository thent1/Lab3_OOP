package com.example.lab3_oop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Shape {
    private Ellipse ellipse;

    public EllipseShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            ellipse = new Ellipse();
            ellipse.setCenterX(mouseEvent.getX());
            ellipse.setCenterY(mouseEvent.getY());
            ellipse.setFill(null);
            ellipse.setStroke(Color.BLACK);
            root.getChildren().add(ellipse);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (ellipse != null) {
                ellipse.setRadiusX(mouseEvent.getX()-ellipse.getCenterX());
                ellipse.setRadiusY(mouseEvent.getY()-ellipse.getCenterY());
            }

        });

        root.setOnMouseReleased(mouseEvent -> {
            if (ellipse != null){
                ellipse = null;
            }

        });
    }
}
