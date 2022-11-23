package agh.ics.oop;

public class Grass implements IMapElement{
    Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getFileName() {
        return "grass";
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getLabelText() {
        return "Trawa";
    }
}
