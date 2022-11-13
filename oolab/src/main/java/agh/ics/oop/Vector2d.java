package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    final public int x;
    final public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    boolean precedes(Vector2d other){
        return other.x <= x && other.y <= y;
    }
    boolean follows(Vector2d other){
        return other.x >= x && other.y >= y;
    }
    Vector2d upperRight(Vector2d other){
        int xx = Math.max(other.x, x);
        int yy = Math.max(other.y, y);
        Vector2d out = new Vector2d(xx, yy);
        return out;
    }
    Vector2d lowerLeft(Vector2d other){
        int xx = Math.min(other.x, x);
        int yy = Math.min(other.y, y);
        Vector2d out = new Vector2d(xx, yy);
        return out;
    }
    Vector2d add(Vector2d other){
        int xx = other.x + x;
        int yy = other.y + y;
        return new Vector2d(xx, yy);
    }
    Vector2d subtract(Vector2d other){
        int xx =  x - other.x;
        int yy = y - other.y;
        return new Vector2d(xx, yy);
    }
    Vector2d opposite(){
        return new Vector2d(-x, -y);
    }
    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return that.x == x && that.y == y;
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
