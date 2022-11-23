package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    List<IPositionChangeObserver> observersList = new ArrayList<>();
    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }
    public void move(MoveDirection direction){
        System.out.println(direction);
        switch (direction){
            case LEFT -> {
                orientation = orientation.previous();
                positionChanged(position,position);
            }
            case RIGHT -> {

                orientation = orientation.next();
                positionChanged(position, position);
            }
            case FORWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.add(vec);
                if(map.canMoveTo(newPosition)){
                    positionChanged(position, newPosition);
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.subtract(vec);
                if(map.canMoveTo(newPosition)){

                    positionChanged(position,newPosition);
                    position = newPosition;
                }
            }
        }

    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }
    public void addObserver(IPositionChangeObserver observer){
        observersList.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observersList.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observersList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public String toString() {
        return switch (orientation){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }

    public MapDirection getOrientation() {
        return orientation;
    }
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getFileName() {
         return switch (orientation){
            case NORTH -> "down";
            case EAST -> "right";
            case WEST -> "left";
            case SOUTH -> "up";
        };
    }

    @Override
    public String getLabelText() {
        return toString() + " " + getPosition().toString();
    }
}
