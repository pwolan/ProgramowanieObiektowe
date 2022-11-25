package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /**
         * Każde wcisniecie start powoduje chodzenie animali na zmianę z poprzednio uzyskanej pozycji
         */

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Button btn = new Button();
        btn.setText("Start");

        final TextField textField = new TextField();
        HBox hBox = new HBox();
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        VBox vBox = new VBox();
        vBox.getChildren().add(gridPane);
        vBox.getChildren().add(hBox);

        Scene scene = new Scene(vBox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            MapBoundary mapBoundary = new MapBoundary();

            IWorldMap map = new GrassField(10, mapBoundary);

            Vector2d[] positions = {new Vector2d(5, 2), new Vector2d(2, 2)};
            MapRenderer renderer = new MapRenderer(gridPane, mapBoundary.getBoundaryVector(), map);
            final SimulationEngine engine = new SimulationEngine( map, positions, mapBoundary, renderer);
            engine.setMoveDelay(2000);
            Thread startThread = new Thread(engine);
            startThread.start(); // tylko po to aby na start pojawiła się plansza

            btn.setOnAction((e)->{
                Thread engineThread = new Thread(engine);
                String textFieldText = textField.getText();
                String[] args = textFieldText.split(" ");
                MoveDirection[] directions = new OptionsParser().parse(args);
                engine.setMoves(directions);
                engineThread.start();

            });


        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
