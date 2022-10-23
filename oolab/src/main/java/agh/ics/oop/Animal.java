package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.add(vec);
                if(newPosition.x <= 4 && newPosition.y <=4 && newPosition.x >= 0 && newPosition.y >= 0){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d vec = orientation.toUnitVector();
                Vector2d newPosition = position.subtract(vec);
                if(newPosition.x <= 4 && newPosition.y <=4 && newPosition.x >= 0 && newPosition.y >= 0){
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
        return "Animal{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }

    public MapDirection getOrientation() {
        return orientation;
    }
}
