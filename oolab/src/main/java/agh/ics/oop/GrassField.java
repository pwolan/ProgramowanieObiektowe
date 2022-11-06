package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrassField  extends AbstractWorldMap{
    List<Grass> grassTufts = new ArrayList<>();
    private final int grassRange;
    public GrassField(int n) {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);

        grassRange = (int) Math.sqrt(n * 10) + 1;
        Set<Vector2d> positions = new HashSet<>();
        while(positions.size() < n){
            int x = (int) (Math.random() * (grassRange));
            int y = (int) (Math.random() * (grassRange));
            positions.add(new Vector2d(x, y));
        }
        for(Vector2d vec : positions){
            Grass g = new Grass(vec);
            grassTufts.add(g);
        }

    }

    public void removeGrass(Vector2d position){
        boolean removed = grassTufts.removeIf(t -> t.getPosition().equals(position));
        if(removed){
            int x,y;
            boolean match;
            Vector2d vecout;
            do{
                x = (int) (Math.random() * (grassRange));
                y = (int) (Math.random() * (grassRange));
                final Vector2d vec = new Vector2d(x, y);
                match = grassTufts.stream().noneMatch(g -> g.getPosition().equals(vec));
                vecout = vec;
            } while (!match);
            Grass g = new Grass(vecout);
            grassTufts.add(g);

        }

    }
    @Override
    public Object objectAt(Vector2d position) {
        Animal result = (Animal) super.objectAt(position);
        if(result == null){
            return grassTufts.stream()
                    .filter(a -> a.getPosition().equals(position))
                    .findFirst().orElse(null);
        } else{
            return result;
        }

    }

    @Override
    Vector2d calculateMapBounds() {
        int maxW = animals.stream().mapToInt(a -> a.getPosition().x).max().orElse(0);
        maxW = Math.max(maxW, grassRange);
        int maxH = animals.stream().mapToInt(a -> a.getPosition().y).max().orElse(0);
        maxH = Math.max(maxH, grassRange);
        return new Vector2d(maxW, maxH);
    }

}
