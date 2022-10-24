package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private final List<Animal> animals = new ArrayList<>();
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.x <= width &&
                position.y <=height &&
                position.x >= 0 &&
                position.y >= 0
                && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        };
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.stream().anyMatch(a -> a.isAt(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
       return animals.stream()
               .filter(a->a.isAt(position))
               .findFirst()
               .orElse(null);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this)
                .draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
