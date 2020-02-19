import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class CompoundInterest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage stage = primaryStage;
        try {
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\src\\button.png");
            Image im = new Image(in);
            ImageView iv = new ImageView(im);
            Button exit = new Button("", iv);

            exit.setLayoutY(3);
            exit.setLayoutX(175);
            exit.setMaxHeight(11);
            exit.setMaxWidth(11);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(30);
            line.setEndX(210);
            line.setEndY(30);
            Label title = new Label("Compound Interest");
            title.setLayoutX(50);
            title.setLayoutY(5);

            AnchorPane a = new AnchorPane();
            a.prefHeight(245);
            a.prefWidth(201);
            Label subtitle = new Label("Compound Interest");
            subtitle.setFont(Font.font("Castellar", 17));
            subtitle.setLayoutY(45);
            subtitle.setLayoutX(2);
            a.getChildren().add(subtitle);
            GridPane g = new GridPane();
            g.setLayoutX(3);
            g.setLayoutY(81);
            g.prefHeight(118);
            g.prefWidth(200);

            ColumnConstraints c1 = new ColumnConstraints();
            c1.setHgrow(Priority.SOMETIMES);
            c1.setMinWidth(10);
            c1.setPrefWidth(100);
            RowConstraints r1 = new RowConstraints();
            r1.setPrefHeight(30);
            r1.setMinHeight(10);
            r1.setVgrow(Priority.SOMETIMES);
            g.getColumnConstraints().add(c1);

            g.getColumnConstraints().add(c1);
            g.getRowConstraints().add(r1);
            g.getRowConstraints().add(r1);
            g.getRowConstraints().add(r1);

            Label l1 = new Label("Start amount:");
            Label l2 = new Label("Interest: ");
            Label l3 = new Label("Number of years:");
            TextField t1 = new TextField();
            TextField t2 = new TextField();
            TextField t3 = new TextField();
            g.add(l1, 0, 0);
            g.add(l2, 0, 1);
            g.add(l3, 0, 2);

            g.add(t1, 1, 0);
            g.add(t2, 1, 1);
            g.add(t3, 1, 2);
            a.getChildren().add(g);

            Button b1 = new Button("Calculate");
            b1.setLayoutX(8);
            b1.setLayoutY(172);
            a.getChildren().add(b1);
            a.getChildren().add(exit);

            Label l4 = new Label("");
            l4.setLayoutX(6);
            l4.setLayoutY(206);
            a.getChildren().add(l4);

            stage.initStyle(StageStyle.UNDECORATED);
            setUserAgentStylesheet(STYLESHEET_MODENA);



            Group root = new Group(line);
            root.getChildren().add(title);
            root.getChildren().add(a);
            Scene s = new Scene(root, 210, 230);
            stage.setScene(s);
            stage.show();

            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String t1s = t1.getCharacters().toString();
                    String t2s = t2.getCharacters().toString();
                    String t3s = t3.getCharacters().toString();
                    try {
                    double start = Double.parseDouble(t1s);
                    double interest = Double.parseDouble(t2s);
                    double years = Double.parseDouble(t3s);

                        l4.setText(calculate(start, interest, years));
                    }
                    catch (Exception e) {
                        l4.setText("You've done something wrong!");
                    }
                    }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String calculate(double start, double interest, double years) {
        double n = 0;
        interest = interest /100;
        System.out.println(start);

        System.out.println(interest);

        System.out.println(years);
        n = Math.pow(1+interest,years);

        System.out.println(n);
        n = n*start;
        n = Math.floor(n);
        System.out.println(n);
        String l = new String(Integer.toString((int)n));
        return l;
    }
}

