package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);


        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            MapBoundary mapBoundary = new MapBoundary();
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10, mapBoundary);

            Vector2d[] positions = {new Vector2d(5, 2), new Vector2d(2, 2)};
            MapRenderer renderer = new MapRenderer(gridPane, mapBoundary.getBoundaryVector(), map);
            SimulationEngine engine = new SimulationEngine(directions, map, positions, mapBoundary, renderer);
            engine.setMoveDelay(2000);

            Thread engineThread = new Thread(engine);
            engineThread.start();


        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
