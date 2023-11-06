package com.example.lab3_oop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Shape {
public Scene scene;
public Pane root;

    public Shape(Scene scene, Pane root) {
        this.scene = scene;
        this.root = root;
    }

    public abstract void editShape();

}