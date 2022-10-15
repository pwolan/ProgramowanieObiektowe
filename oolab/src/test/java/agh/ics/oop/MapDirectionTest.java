package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        MapDirection dir = MapDirection.EAST;
        assertEquals(dir.next(), MapDirection.SOUTH);
    }

    @Test
    void previous() {
        MapDirection dir = MapDirection.EAST;
        assertEquals(dir.previous(), MapDirection.NORTH);
    }
}