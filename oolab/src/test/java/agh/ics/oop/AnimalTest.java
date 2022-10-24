//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import static agh.ics.oop.MapDirection.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class AnimalTest {
//
//    @Test
//    void orientationAndPositionTest() {
//        Animal animal = new Animal();
//        String[] input = new String[]{"r", "f", "f", "f"};
//        var parser = new OptionsParser();
//        MoveDirection[] parsedInput = parser.parse(input);
//        for(MoveDirection dir : parsedInput){
//            animal.move(dir);
//        }
//        assertTrue(animal.isAt(new Vector2d(4,2))); // test właściwej pozycji
//        assertEquals(animal.getOrientation(), EAST); // test właściwej orientacji
//    }
//
//    @Test
//    void outsideMapTest(){
//        Animal animal = new Animal();
//        String[] input = new String[]{"r", "f", "f", "f", "f",};
//        var parser = new OptionsParser();
//        MoveDirection[] parsedInput = parser.parse(input);
//        for(MoveDirection dir : parsedInput){
//            animal.move(dir);
//        }
//        assertTrue(animal.isAt(new Vector2d(4,2))); // test czy nie wyszedł poza mape
//    }
//
//    @Test
//    void inputInterpretationTest(){
//        Animal animal = new Animal();
//        String[] input = new String[]{"r","x","l", "b", "f", "f"};
//        var parser = new OptionsParser();
//        MoveDirection[] parsedInput = parser.parse(input);
//        for(MoveDirection dir : parsedInput){
//            animal.move(dir);
//        }
//        assertTrue(animal.isAt(new Vector2d(2,3)));
//        assertEquals(animal.getOrientation(), NORTH);
//
//    }
//
//}