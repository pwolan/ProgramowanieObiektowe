package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import agh.ics.oop.IPositionChangeObserver;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.Vector2d;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class MapRenderer implements IPositionChangeObserver {
    private GridPane rootPane;
    private Vector2d lowerLeft = new Vector2d(0, 0);
    private Vector2d upperRight;
    private IWorldMap map;
    private final int FIELD_GROW = 40;
    public MapRenderer(GridPane rootPane,  Vector2d upperRight, IWorldMap map) {
        this.rootPane = rootPane;
        this.upperRight = upperRight;
        this.map = map;
    }

    public void render(){
        Platform.runLater(() -> {
            rootPane.getColumnConstraints().clear();
            rootPane.getRowConstraints().clear();
            Node gr = rootPane.getChildren().get(0);

            rootPane.getChildren().clear();
            rootPane.add(gr,0,0);
            rootPane.setGridLinesVisible(true);

            for (int i = upperRight.y + 1; i >= lowerLeft.y; i--) {

                if (i == upperRight.y + 1) {
                    rootPane.getColumnConstraints().add(new ColumnConstraints(FIELD_GROW));
                    Label label = new Label("y/x");
                    rootPane.add(label, 0, 0);
                    renderHeader();

                } else {
                    Label label = new Label(String.valueOf(upperRight.y - i));
                    rootPane.add(label, lowerLeft.y, i + 1);

                    GridPane.setHalignment(label, HPos.CENTER);
                    GridPane.setValignment(label, VPos.CENTER);
                    renderRow(i);
                }
            }
            rootPane.setGridLinesVisible(true);
        });
    }

    public void renderHeader(){

        rootPane.getRowConstraints().add(new RowConstraints(FIELD_GROW));
        for (int j = lowerLeft.x; j < upperRight.x + 1; j++) {
            rootPane.getColumnConstraints().add(new ColumnConstraints(FIELD_GROW));
            Label label = new Label(String.valueOf(j));
            GridPane.setHalignment(label, HPos.CENTER);
            rootPane.add(label, j+1, 0);
        }
    }
    public void renderRow( int i){

        rootPane.getRowConstraints().add(new RowConstraints(FIELD_GROW));
        for (int j = lowerLeft.x ; j < upperRight.x + 1; j++) {
            IMapElement object = (IMapElement) this.map.objectAt(new Vector2d(j, i));
            GuiElementBox elementBox = new GuiElementBox(object);
            elementBox.renderElement(rootPane, j+1, upperRight.y-i+1);

        }


    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
            render();
    }
}
