package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public MoveDirection[] parse(String[] input) {

        MoveDirection[] out = Arrays.stream(input).map(this::parseMove)
                .filter(Objects::nonNull).toArray(MoveDirection[]::new);
        return out;
    }
    MoveDirection parseMove(String mv) throws IllegalArgumentException {
        switch (mv) {
            case "f", "forward" -> {
                return MoveDirection.FORWARD;
            }
            case "b", "backward" -> {return MoveDirection.BACKWARD;}
            case "r", "right" -> {return  MoveDirection.RIGHT;}
            case "l", "left" -> {return MoveDirection.LEFT;}
            default -> {
                throw new IllegalArgumentException(mv + " is not legal move specification");
            }
        }
    }
}
