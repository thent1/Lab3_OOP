package com.example.lab3_oop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PointShape extends Shape {
    private Line point;
    public PointShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            point = new Line();
            point.setStartX(mouseEvent.getX());
            point.setStartY(mouseEvent.getY());
            point.setEndX(mouseEvent.getX());
            point.setEndY(mouseEvent.getY());
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
            root.getChildren().add(point);
        });

        root.setOnMouseReleased(mouseEvent -> {
            if (point != null) {
                point = null;
            }
        });
    }
}
