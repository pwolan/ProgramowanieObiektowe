//package agh.ics.oop;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GrassFieldTest {
//    @Test
//    void canMoveToTest(){
//        IWorldMap map = new GrassField(10);
//        Animal an1 = new Animal(map, new Vector2d(2,2));
//        map.place(an1);
//        assertTrue(map.canMoveTo(new Vector2d(2,1)));
//        assertFalse(map.canMoveTo(new Vector2d(2,2)));
//    }
//    @Test
//    void placeTest(){
//        IWorldMap map = new GrassField(10);
//        Animal an1 = new Animal(map, new Vector2d(2,2));
//        Animal an2 = new Animal(map, new Vector2d(2,2));
//        map.place(an1);
//        assertThrows(
//                IllegalArgumentException.class,
//                ()->{map.place(an2);},
//                "Expected map.place(an2) to throw bu didn't"
//        );
//
//    }
//    @Test
//    void placeTest2(){
//        IWorldMap map = new GrassField(10,);
//        Animal an1 = new Animal(map, new Vector2d(2,2));
//        Animal an2 = new Animal(map, new Vector2d(2,3));
//        map.place(an1);
//        Assertions.assertDoesNotThrow(
//                ()->{map.place(an2);},
//                "map.place() has thrown exception but should not have"
//        );
//
//    }
//    @Test
//    void isOccupiedTest(){
//        IWorldMap map = new GrassField(10);
//        Animal an1 = new Animal(map, new Vector2d(2,2));
//        map.place(an1);
//        assertTrue(map.isOccupied(new Vector2d(2,2)));
//        assertFalse(map.isOccupied(new Vector2d(2,4)));
//    }
//    @Test
//    void objectAtTest(){
//        IWorldMap map = new GrassField(10);
//        Animal an1 = new Animal(map, new Vector2d(2,2));
//        map.place(an1);
//        assertEquals(map.objectAt(new Vector2d(2,2)), an1);
//    }
//}