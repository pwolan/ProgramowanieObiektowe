package agh.ics.oop;

import java.util.*;


public class MapBoundary implements IPositionChangeObserver {
       Comparator<Vector2d> xComparator = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.x == o2.x)
                return Integer.compare(o1.y, o2.y);
            return Integer.compare(o1.x, o2.x);
        }
    };
    Comparator<Vector2d> yComparator = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o1.y, o2.y);
        }
    };

  private TreeMap<Vector2d, IMapElement> elementsX = new TreeMap<>(xComparator);
    private TreeMap<Vector2d, IMapElement> elementsY = new TreeMap<>(yComparator);
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el1 = elementsX.remove(oldPosition);
        elementsX.put(newPosition, el1);
        IMapElement el2 = elementsY.remove(oldPosition);
        elementsY.put(newPosition, el2);
    }
    public void addElement(IMapElement element){
        elementsX.put(element.getPosition(), element);
        elementsY.put(element.getPosition(), element);
    }
    public Vector2d getBoundaryVector(){
        int x = elementsX.lastEntry().getKey().x;
        int y = elementsY.lastEntry().getKey().y;
        return new Vector2d(x, y);
    }
}
