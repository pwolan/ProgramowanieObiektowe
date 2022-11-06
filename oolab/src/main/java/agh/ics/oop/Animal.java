package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.add(vec);
                if(map.canMoveTo(newPosition)){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.subtract(vec);
                if(map.canMoveTo(newPosition)){
                    if(map instanceof GrassField grassMap){
                        grassMap.removeGrass(newPosition);
                    }
                    position = newPosition;
                }
            }
        }

    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
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
}
