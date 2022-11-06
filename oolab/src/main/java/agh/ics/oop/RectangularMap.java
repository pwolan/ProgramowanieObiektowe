package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {


    private final List<Animal> animals = new ArrayList<>();
    public RectangularMap(int width, int height) {
       super(width,height);
    }

    @Override
    Vector2d calculateMapBounds() {
        return new Vector2d(width, height);
    }
}
