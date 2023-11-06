package com.example.lab3_oop;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {

        String path = "D:\\JavaProjects\\Lab3_OOP\\src\\main\\java\\com\\example\\lab3_oop\\";

        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 600);
        stage.setTitle("Lab3");
        borderPane.setCenter(root);
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("Файл");
        Menu shapes = new Menu("Фігури");
        Menu info = new Menu("Довідка");

        menuBar.getMenus().addAll(file, shapes, info);

        Image pointImage = new Image(path+ "point.png");
        Image lineImage = new Image(path + "line.png");
        Image rectImage = new Image(path + "rectangle.png");
        Image ellipseImage = new Image(path + "ellipse.png");


        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem point = new RadioMenuItem("Крапка");
        RadioMenuItem line = new RadioMenuItem("Лінія");
        RadioMenuItem rectangle = new RadioMenuItem("Прямокутник");
        RadioMenuItem ellipse = new RadioMenuItem("Еліпс");
        point.setToggleGroup(toggleGroup);
        line.setToggleGroup(toggleGroup);
        rectangle.setToggleGroup(toggleGroup);
        ellipse.setToggleGroup(toggleGroup);


        ToolBar toolBar = new ToolBar();
        ToolBarButton pointButton = new ToolBarButton(pointImage);
        ToolBarButton lineButton = new ToolBarButton(lineImage);
        ToolBarButton rectButton = new ToolBarButton(rectImage);
        ToolBarButton ellipseButton = new ToolBarButton(ellipseImage);
        //ToolBarButton button2 = new ToolBarButton();
        toolBar.getItems().addAll(pointButton, lineButton, rectButton, ellipseButton);
        toolBar.setOrientation(Orientation.VERTICAL);

        shapes.getItems().addAll(point, line, rectangle, ellipse);
        borderPane.setTop(menuBar);
        borderPane.setLeft(toolBar);

        point.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startPointEditor(scene, root);
        });

        line.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startLineEditor(scene, root);
        });

        rectangle.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startRectEditor(scene, root);
        });

        ellipse.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startEllipseEditor(scene, root);
        });

        pointButton.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startPointEditor(scene, root);
            point.setSelected(true);
        });

        lineButton.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startLineEditor(scene, root);
            line.setSelected(true);
        });

        rectButton.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startRectEditor(scene, root);
            rectangle.setSelected(true);
        });

        ellipseButton.setOnAction(actionEvent -> {
            ShapeObjectsEditor.startEllipseEditor(scene, root);
            ellipse.setSelected(true);
        });

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

