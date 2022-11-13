package agh.ics.oop;

import java.util.Map;

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
            animal.addObserver((IPositionChangeObserver) map);
        }

    }

    @Override
    public void run() {
        Map<Vector2d,Animal> animals = map.getAnimals();
        Animal[] animalsArray = animals.values().toArray(new Animal[0]);
        int animalsLength = animals.size();

        for(int i=0; i< moves.length; i++){
            Animal an =  animalsArray[(i % animalsLength)];
            an.move(moves[i]);
        }
        System.out.println(map);
        
    }
}
