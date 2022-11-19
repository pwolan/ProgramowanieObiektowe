package agh.ics.oop;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;

import java.util.*;

public class GrassField  extends AbstractWorldMap{
    private final int grassRange;
    private final Map<Vector2d, Grass> grassTufts = new HashMap<>();
//    private final int FIELD_GROW = 20;
    private MapBoundary mapBoundary;
    public GrassField(int n, MapBoundary mapBoundary) {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);

        this.mapBoundary = mapBoundary;
        grassRange = (int) Math.sqrt(n * 10) + 1;
        Set<Vector2d> positions = new HashSet<>();
        while (positions.size() < n) {
            int x = (int) (Math.random() * (grassRange));
            int y = (int) (Math.random() * (grassRange));
            positions.add(new Vector2d(x, y));
        }
        for (Vector2d vec : positions) {
            Grass g = new Grass(vec);
            grassTufts.put(g.getPosition(), g);
            mapBoundary.addElement(g);
        }


    }

    private void randomPlaceGrass(Grass grass){
        int x = (int) (Math.random() * (grassRange));
        int y = (int) (Math.random() * (grassRange));
        Vector2d vec = new Vector2d(x, y);
        if(!grassTufts.containsKey(vec) && !animals.containsKey(vec)){
            grassTufts.put(vec, grass);
        }

    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal result = (Animal) super.objectAt(position);
        if(result == null){
            return grassTufts.get(position);
        } else{
            return result;
        }

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Grass eatenGrass = grassTufts.remove(newPosition);

        super.positionChanged(oldPosition, newPosition);
        if(eatenGrass != null){
            randomPlaceGrass(eatenGrass);
        }
    }

    @Override
    Vector2d calculateMapBounds() {
        return mapBoundary.getBoundaryVector();
    }


}
