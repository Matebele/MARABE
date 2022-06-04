package com.example.aircraft;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {


    VBox vBox = new VBox();
    Label labelScore;
    Label instructions;


    Duration duration_1 = Duration.millis(6000);
    Duration duration_2 = Duration.millis(7000);
    Duration duration_3 = Duration.millis(8000);
    Duration duration_4 = Duration.millis(9000);

    Duration duration1 = Duration.millis(14000);
    Duration duration2 = Duration.millis(18000);
    Duration duration3 = Duration.millis(11000);
    Duration duration4 = Duration.millis(20000);



    TranslateTransition point_1 = new TranslateTransition(duration1);
    TranslateTransition point_2 = new TranslateTransition(duration2);
    TranslateTransition point_3 = new TranslateTransition(duration3);
    TranslateTransition point_4 = new TranslateTransition(duration4);



    TranslateTransition translate1 = new TranslateTransition(duration_1);
    TranslateTransition translate2 = new TranslateTransition(duration_2);
    TranslateTransition translate3 = new TranslateTransition(duration_3);
    TranslateTransition translate4 = new TranslateTransition(duration_4);

    SequentialTransition sequantial1;
    SequentialTransition sequantial2;
    SequentialTransition sequantial3;
    SequentialTransition sequantial4;


    SequentialTransition seqT1;
    SequentialTransition seqT2;
    SequentialTransition seqT3;
    SequentialTransition seqT4;


    Rectangle shape1 = new Rectangle(180,100);
    String source = getClass().getResource("/ship.png").toExternalForm();
    Image image = new Image(source);
    ImageView imageView = new ImageView(image);


    Rectangle shape2 = new Rectangle(35,20);
    String source1 = getClass().getResource("/cash3.jpg").toExternalForm();
    Image point1 = new Image(source1);

    Rectangle shape3 = new Rectangle(35,20);
    String source2 = getClass().getResource("/cash3.jpg").toExternalForm();
    Image point2 = new Image(source2);

    Rectangle shape4 = new Rectangle(35,20);
    String source3 = getClass().getResource("/cash3.jpg").toExternalForm();
    Image point3 = new Image(source3);

    Rectangle shape5 = new Rectangle(35,20);
    String source4 = getClass().getResource("/cash3.jpg").toExternalForm();
    Image point4 = new Image(source4);

    //Creating images clouds
    Rectangle shape_1 = new Rectangle(180,100);
    String source_1 = getClass().getResource("/cloud.png").toExternalForm();
    Image image1 = new Image(source_1);


    Rectangle shape_2 = new Rectangle(180,100);
    String source_2 = getClass().getResource("/cloud.png").toExternalForm();
    Image image2 = new Image(source_2);


    Rectangle shape_3 = new Rectangle(480,230);
    String source_3 = getClass().getResource("/cloud.png").toExternalForm();
    Image image3 = new Image(source_3);

    Rectangle shape_4 = new Rectangle(480,230);
    String source_4 = getClass().getResource("/cloud.png").toExternalForm();
    Image image4 = new Image(source_4);

    //Creating score
    int score;
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        //setting clouds images


        shape_1.setFill(new ImagePattern(image1));
        shape_2.setFill(new ImagePattern(image2));
        shape_3.setFill(new ImagePattern(image3));
        shape_4.setFill(new ImagePattern(image4));

        //setting points images

        shape2.setFill(new ImagePattern(point1));
        shape3.setFill(new ImagePattern(point2));
        shape4.setFill(new ImagePattern(point3));
        shape5.setFill(new ImagePattern(point4));

        //getting points


        point_1.setToY(1950f);
        point_1.setCycleCount(200);
        point_1.setAutoReverse(false);

        sequantial1 = new SequentialTransition (shape2, point_1);


        point_2.setToY(1950f);
        point_2.setCycleCount(200);
        point_2.setAutoReverse(false);

        sequantial2 = new SequentialTransition (shape3, point_2);


        point_3.setToY(1950f);
        point_3.setCycleCount(200);
        point_3.setAutoReverse(false);

        sequantial3 = new SequentialTransition (shape4, point_3);


        point_4.setToY(1950f);
        point_4.setCycleCount(200);
        point_4.setAutoReverse(false);

        sequantial4 = new SequentialTransition (shape5, point_4);


        translate1.setToX(-1950f);
        translate1.setCycleCount(200);
        translate1.setAutoReverse(false);

        seqT1 = new SequentialTransition (shape_1, translate1);



        translate2.setToX(-1950f);
        translate2.setCycleCount(200);
        translate2.setAutoReverse(false);

        seqT2 = new SequentialTransition (shape_2, translate2);



        translate3.setToX(-1950f);
        translate3.setCycleCount(200);
        translate3.setAutoReverse(false);

        seqT3 = new SequentialTransition (shape_3, translate3);

        translate4.setToX(-1950f);
        translate4.setCycleCount(200);
        translate4.setAutoReverse(false);

        seqT4 = new SequentialTransition (shape_4, translate4);


        final Group group = new Group(createInstructions(),createScore(),vBox,shape_2,shape_3,shape_4,shape2,shape3,shape4,root);


        shape_1.setX(1400);
        shape_1.setY(50);
        shape_2.setX(1400);
        shape_2.setY(400);
        shape_3.setX(1400);
        shape_3.setY(800);
        shape_4.setX(1400);
        shape_4.setY(500);


        shape2.setX(400);
        shape2.setY(-50);
        shape3.setX(600);
        shape3.setY(-50);
        shape4.setX(700);
        shape4.setY(-50);

        final Scene scene = new Scene(group,800,600);
        ImageView ship = createShip(scene);

        root.getChildren().addAll(shape1,shape_1,shape_2,shape_3,shape_4,labelScore);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = shape1.getX();
            double y = shape1.getY();

            if(event.getCode()== KeyCode.UP){
                shape1.setY(y-10);
            }
            else if(event.getCode()==KeyCode.DOWN){
                shape1.setY(y+10);
            }
            else if(event.getCode()==KeyCode.RIGHT){
                shape1.setX(x+10);
            }
            else if(event.getCode()==KeyCode.LEFT){
                shape1.setX(x-10);
            }
            else if(event.getCode()==KeyCode.ENTER){
                Play();
            }
            if(event.getCode() == KeyCode.SPACE){
               Pause();

            }
        });

        stage.setTitle("AIRCRAFT GAME");
        stage.setScene(scene);
        stage.show();
    }
    public void Play(){
        sequantial1.play();
        sequantial2.play();
        sequantial3.play();
        sequantial4.play();
        seqT1.play();
        seqT2.play();
        seqT2.play();
        seqT3.play();
        seqT4.play();
    }
    public void Pause(){
        sequantial1.pause();
        sequantial2.pause();
        sequantial3.pause();
        sequantial4.pause();
        seqT1.pause();
        seqT2.pause();
        seqT2.pause();
        seqT3.pause();
        seqT4.pause();
    }
    private ImageView createShip(Scene scene){
        shape1.setFill(new ImagePattern(image));
        shape1.setX(100);
        shape1.setY(200);
        imageView.setFitWidth(130);
        imageView.setFitHeight(80);
        imageView.setY(scene.getHeight() - imageView.getFitHeight());

        return imageView;
    }
    private Label createInstructions(){
        instructions = new Label(
                "\n\tPRESS ENTER TO START\n\tSCORE:"
        );

        //LABEL.getChildren().add(instructions);

        instructions.setTextFill(Color.BLUEVIOLET);
        instructions.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        return instructions;
    }
    private Label createScore(){
        score = 0;

        labelScore = new Label();
        labelScore.setText(score+"");
        labelScore.setLayoutX(200);
        labelScore.setLayoutY(47);
        vBox.getChildren().add(labelScore);

        labelScore.setTextFill(Color.BLUEVIOLET);
        labelScore.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        shape1.translateXProperty().addListener(observable -> {

        });
        shape_1.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (shape1.getBoundsInParent().intersects(shape_1.getBoundsInParent())){
                    String icon= getClass().getResource("/collision.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape_1.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape_2.getBoundsInParent())) {
                    String icon= getClass().getResource("/collision.png").toExternalForm();
                    Image imageJet= new Image(icon);
                    shape1.setFill(new ImagePattern(imageJet));
                    Pause();
                    shape_2.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape_3.getBoundsInParent())) {
                    String icon= getClass().getResource("/collision.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape_3.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape_4.getBoundsInParent())) {
                    String icon= getClass().getResource("/collision.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape_4.setOpacity(0.1);
                }
                else if (shape1.getBoundsInParent().intersects(shape2.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape3.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape4.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape5.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
            }
        });
        return labelScore;
    }
    public static void main(String[] args) {
        launch();
    }
}