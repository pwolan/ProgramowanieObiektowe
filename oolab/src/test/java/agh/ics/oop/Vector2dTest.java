package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void precedes() {
        var v1 = new Vector2d(4, 5);
        var v2 = new Vector2d(2, 4);
        assertTrue(v1.precedes(v2));
    }

    @Test
    void follows() {
        var v1 = new Vector2d(2, 4);
        var v2 = new Vector2d(4, 4);
        assertTrue(v1.follows(v2));
    }

    @Test
    void upperRight() {
        var v1 = new Vector2d(3, 4);
        var v2 = new Vector2d(2, 5);
        var v = new Vector2d(3, 5);
        assertEquals(v1.upperRight(v2), v);
    }

    @Test
    void lowerLeft() {
        var v1 = new Vector2d(3, 4);
        var v2 = new Vector2d(2, 5);
        var v = new Vector2d(2, 4);
        assertEquals(v1.lowerLeft(v2), v);
    }

    @Test
    void add() {
        var vec1 = new Vector2d(3, -2);
        var vec2 = new Vector2d(4, 1);
        var sub = new Vector2d(7, -1);
        assertEquals(vec1.add(vec2), sub);
    }

    @Test
    void subtract() {
        var vec1 = new Vector2d(3, -2);
        var vec2 = new Vector2d(4, 1);
        var sub = new Vector2d(-1, -3);
        assertEquals(vec1.subtract(vec2), sub);
    }

    @Test
    void opposite() {
        var vec = new Vector2d(4, -5);
        assertEquals(vec.opposite(), new Vector2d(-4,5));
    }

    @Test
    void testEquals() {
        var vec1 = new Vector2d(4, -5);
        var vec2 = new Vector2d(4, -5);
        var vec3 = new Vector2d(4, 5);
        assertTrue(vec1.equals(vec2));
        assertFalse(vec1.equals(vec3));
    }

   @Test
    void testToString() {
        var vec = new Vector2d(4, -5);
        String msg = "(4,-5)";
        assertEquals(vec.toString(), msg);
    }
}