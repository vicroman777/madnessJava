package Snowman;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Snowman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snowman");
    Group root = new Group();
    Canvas canvas = new Canvas(500, 400);
    GraphicsContext g = canvas.getGraphicsContext2D();
    draw(g);
    root.getChildren().add(canvas);


    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    }

    private void draw(GraphicsContext g) {
        g.setFill(Color.BLUE);
        g.fillRect(0,0 ,500,400);
    g.setFill(Color.WHITE);
    g.fillRect(0,250,500,150);
    g.fillOval(200,180, 80, 80);
    g.fillOval(210,130 ,60,60);
    g.setFill(Color.BLACK);
    g.fillOval(237, 155, 5, 5);
    g.fillOval(237, 140, 5, 5);
    g.fillOval(237, 170, 5, 5);
    g.setFill(Color.WHITE);
    g.fillOval(220,95 , 40,40);
    g.setFill(Color.BLACK);
    g.fillOval(245, 105, 4, 4);
    g.fillOval(230, 105, 4, 4);
    g.fillArc(232, 115, 15, 15, 180 , 180, ArcType.OPEN);
    g.setFill(Color.YELLOW);
    g.fillOval(350, 20, 80, 80);

    }

}
