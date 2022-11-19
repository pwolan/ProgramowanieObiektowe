package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {

    @Test
    void parseTest1(){
        OptionsParser parser = new OptionsParser();
        String[] moves = new String[]{"r","f","f","b","l","forward","b"};
        MoveDirection[] parsedMoves = parser.parse(moves);
        int k = 0;
        for (String s : moves) {
            MoveDirection move = switch (s) {
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "f", "forward" -> MoveDirection.FORWARD;
                default -> null;
            };
            if (move != null) {
                assertEquals(move, parsedMoves[k]);
            } else {
                k -= 1;
            }
            k += 1;
        }
    }
    @Test
    void parseTest2(){
        OptionsParser parser = new OptionsParser();
        assertThrows(IllegalArgumentException.class,() -> {parser.parse(new String[]{"f", "b", "po"});});
    }
}