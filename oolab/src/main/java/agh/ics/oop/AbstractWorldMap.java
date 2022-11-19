package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    //    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected final int width;
    protected final int height;

    public AbstractWorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal an = animals.remove(oldPosition);
        animals.put(newPosition, an);
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
    public void place(Animal animal) throws IllegalArgumentException{
        if(!isOccupied(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
        } else {
            throw new IllegalArgumentException("To pole jest niedostępne: " + animal.getPosition().toString());
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    abstract Vector2d calculateMapBounds();


    @Override
    public String toString() {
        return new MapVisualizer(this)
                .draw(new Vector2d(0, 0), calculateMapBounds());
    }

    @Override
    public Map<Vector2d,Animal> getAnimals() {
        return animals;
    }
}
