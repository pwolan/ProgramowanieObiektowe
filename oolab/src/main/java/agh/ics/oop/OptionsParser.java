package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public MoveDirection[] parse(String[] input){
        MoveDirection[] out = Arrays.stream(input).map(el -> switch (el) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> null;
        }).filter(Objects::nonNull).toArray(MoveDirection[]::new);
        return out;
    }

}
