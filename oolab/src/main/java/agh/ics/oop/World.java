// link do repozytorium:
// https://github.com/pwolan/ProgramowanieObiektowe

package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }

    public static MoveDirection[] convert(String[] tab) {
        MoveDirection[] out = Arrays.stream(tab).map(el -> switch (el) {
            case "f" -> MoveDirection.FORWARD;
            case "b" -> MoveDirection.BACKWARD;
            case "r" -> MoveDirection.RIGHT;
            case "l" -> MoveDirection.LEFT;
            default -> null;
        }).filter(el -> el != null).toArray(size -> new MoveDirection[size]);
        return out;
    }

    public static void run(MoveDirection[] tab) {

       Arrays.stream(tab).map(el -> switch (el) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case RIGHT -> "Zwierzak skręca w prawo";
            case LEFT -> "Zwierzak skręca w lewo";
        }).forEach(System.out::println);
    }
}
