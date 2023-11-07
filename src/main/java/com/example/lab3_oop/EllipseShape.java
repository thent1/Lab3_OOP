package com.example.lab3_oop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Shape {
    private Ellipse ellipse;
    double x;
    double y;

    public EllipseShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
            ellipse = new Ellipse();
            ellipse.setFill(null);
            ellipse.setStroke(Color.RED);

            root.getChildren().add(ellipse);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (ellipse != null) {
                ellipse.setCenterX(x+(mouseEvent.getX()-x)/2);
                ellipse.setCenterY(y+(mouseEvent.getY()-y)/2);

                ellipse.setRadiusX(mouseEvent.getX()-ellipse.getCenterX());
                ellipse.setRadiusY(mouseEvent.getY()-ellipse.getCenterY());
            }

        });

        root.setOnMouseReleased(mouseEvent -> {
            if (ellipse != null){
                ellipse.setFill(Color.YELLOW);
                ellipse.setStroke(Color.BLACK);
                ellipse = null;
            }

        });
    }
}
