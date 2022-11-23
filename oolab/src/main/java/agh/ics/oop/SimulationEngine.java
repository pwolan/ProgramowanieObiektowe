package agh.ics.oop;

import agh.ics.oop.gui.MapRenderer;

import java.util.Map;

public class SimulationEngine implements IEngine, Runnable {
    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;
    private MapRenderer renderer;
    private int moveDelay = 1000;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions, MapBoundary mapBoundary, MapRenderer mapRenderer) {
        this.renderer = mapRenderer;
        this.moves = moves;
        this.map = map;
        this.startPositions = startPositions;


        for (Vector2d pos : startPositions) {
            Animal animal = new Animal(map, pos);
            map.place(animal);
            animal.addObserver((IPositionChangeObserver) map);
            animal.addObserver(mapBoundary);
            animal.addObserver(mapRenderer);
            mapBoundary.addElement(animal);

        }

    }

    @Override
    public void run() {
        this.renderer.render();

        Map<Vector2d,Animal> animals = map.getAnimals();
        Animal[] animalsArray = animals.values().toArray(new Animal[0]);
        int animalsLength = animals.size();
        System.out.println(moves.length);
        for(int i=0; i< moves.length; i++){
            Animal an = animalsArray[(i % animalsLength)];

            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException e) {
                System.out.println("Error: Przerwano symulacje!");
                throw new RuntimeException(e);
            }

            an.move(moves[i]);
        }

    }

    public void setMoveDelay(int moveDelay) {
        this.moveDelay = moveDelay;
    }
}
