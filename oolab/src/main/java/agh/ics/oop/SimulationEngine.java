package agh.ics.oop;

import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions) {
        this.moves = moves;
        this.map = map;
        this.startPositions = startPositions;
        
        for(Vector2d pos : startPositions){
            Animal animal = new Animal(map, pos);
            map.place(animal);
        }

    }

    @Override
    public void run() {
        List<Animal> animals = map.getAnimals();
        int animalsLength = animals.size();
        for(int i=0; i< moves.length; i++){
            Animal an = animals.get(i % animalsLength);
            an.move(moves[i]);
        }
        System.out.println(map);
        
    }
}
