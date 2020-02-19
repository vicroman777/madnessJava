package Yahzee;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Yahtzee extends Application {
    int rolls = 0;
    public Label result = new Label("result");

    ArrayList<Integer> numbers = new ArrayList<>(5);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        for (int i = 0; i < 5; i++) {
            numbers.add(0);
        }

        AnchorPane a = new AnchorPane();
        a.setPrefHeight(245);
        a.setPrefWidth(570);
        HBox b = new HBox();
        b.setLayoutX(1);
        b.setLayoutY(72);
        // b.setSpacing(10);
        b.setPrefSize(100, 564);
        a.getChildren().add(b);
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\src\\Yahzee\\d0.png");
        Image d1i = new Image(in);
        ImageView d1 = new ImageView(d1i);
        d1.setFitHeight(102);
        d1.setFitWidth(115);
        b.getChildren().add(d1);
        for (int i = 1; i < 5; i++) {
            in = new FileInputStream(System.getProperty("user.dir") + "\\src\\Yahzee\\d" + i + ".png");
            d1i = new Image(in);
            d1 = new ImageView(d1i);
            d1.setFitHeight(102);
            d1.setFitWidth(115);
            b.getChildren().add(d1);
        }
        for (int i = 0; i < 5; i++) {
            int y = 174;
            CheckBox c1 = new CheckBox();
            c1.setLayoutX(115 * i + 115 / 2);
            c1.setLayoutY(y);
            c1.setDisable(true);
            a.getChildren().add(c1);

        }
        Label title = new Label("Yahtzee!");
        title.setFont(Font.font("Bodoni MT", 31));
        title.setLayoutX(223);
        title.setLayoutY(33);
        a.getChildren().add(title);


        Button game = new Button("Roll!");
        game.setLayoutX(14);
        game.setLayoutY(206);
        a.getChildren().add(game);

        game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random r = new Random();


                ArrayList<CheckBox> ab = getStuff(a);
                if (rolls == 0) {
                    for (int i = 0; i < 6; i++) {
                        a.getChildren().get(i).setDisable(false);
                    }
                }
                if (rolls == 2) {
                    for (int i = 0; i < 6; i++) {
                        // a.getChildren().get(i).setDisable(true);
                        // game.setDisable(true);
                    }
                }

                for (int i = 0; i < 5; i++) {
                    if (!ab.get(i).isSelected()) {
                        int j = r.nextInt(6);
                        ((ImageView) b.getChildren().get(i)).setImage(new Image(getClass().getResource("d" + j + ".png").toExternalForm()));
                        System.out.println(numbers);
                        numbers.set(i, j + 1);
                        System.out.println(j);
                    } else {
                        numbers.set(i, numbers.get(i));
                    }
                }
                rolls++;
                count(numbers);
            }
        });


        result.setLayoutY(210);
        result.setLayoutX(89);
        a.getChildren().add(result);

        Group g = new Group();
        g.getChildren().add(a);
        Scene s = new Scene(g, 575, 245);
        primaryStage.setScene(s);
        primaryStage.show();


    }

    private ArrayList<CheckBox> getStuff(AnchorPane parent) {
        ArrayList<CheckBox> a = new ArrayList<CheckBox>();
        for (Node n : parent.getChildren()) {
            if (CheckBox.class.equals(n.getClass())) {
                a.add((CheckBox) n);
                System.out.println(a);
            }
        }
        return a;
    }

    private void count(ArrayList<Integer> n) {

        HashMap<Integer, Integer> ha = new HashMap<>();
        System.out.println(n);
        for (int i : n) {
            int count = ha.containsKey(i) ? ha.get(i) : 0;
            ha.put(i, count + 1);
        }
        ha.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        setScore(ha);


    }

    private void setScore(HashMap<Integer, Integer> n) {
        int largestraight = 0;
        int smallstraight = 0;
        int yahtzee = 0;
        int onekind = 0;
        int fourkind = 0;
        int threekind = 0;
        int pair = 0;
        int fullhouse = 0;

        for (int i : n.keySet()) {
            switch (n.get(i)) {
                case 1:
                    if (onekind < i) {
                        onekind = i;
                    }
                    break;
                case 2:
                    if (pair < i * 2) {
                        pair = i * 2;
                    }
                    break;
                case 3:
                    threekind = i * 3;
                    break;
                case 4:
                    fourkind = i * 4;
                    break;
                case 5:
                    yahtzee = 50;
                    break;
            }
        }
        if (threekind > 0 && pair > 0) {
            fullhouse = threekind + pair;
        }
        if (n.keySet().size() == 5) {
            int sum = 0;
            for (int j : n.keySet()) {
                sum += j;
            }
            if (sum == 15) {
                smallstraight = sum;
            } else if (sum == 20) {
                largestraight = sum;
            }
        }
        HashMap<String, Integer> mywilltoliveisgone = new HashMap<>();
        mywilltoliveisgone.put("large Straight", largestraight);
        mywilltoliveisgone.put("small straight", smallstraight);
        mywilltoliveisgone.put("yahtzee", yahtzee);
        mywilltoliveisgone.put("one kind", onekind);
        mywilltoliveisgone.put("four kind", fourkind);
        mywilltoliveisgone.put("three kind", threekind);
        mywilltoliveisgone.put("pair", pair);
        mywilltoliveisgone.put("full house", fullhouse);

        mywilltoliveisgone.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        String lastKey = "god forgive me for i have sinned";


        //prints result
        result.setText("You got a " + mywilltoliveisgone.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey() + " which has value of " + mywilltoliveisgone.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue());
    }
}



