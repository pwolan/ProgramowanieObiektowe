package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(convert(args));
        System.out.println("Stop");
    }

    public static Direction[] convert(String[] tab) {
        Direction[] out = Arrays.stream(tab).map(el -> switch (el) {
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            default -> null;
        }).filter(el -> el != null).toArray(size -> new Direction[size]);
        return out;
    }

    public static void run(Direction[] tab) {
//        for(int i=0; i<tab.length; i++){
//            System.out.print(tab[i]);
//            if(i != tab.length -1){
//                System.out.print(", ");
//            }
//        }
       Arrays.stream(tab).map(el -> switch (el) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case RIGHT -> "Zwierzak skręca w prawo";
            case LEFT -> "Zwierzak skręca w lewo";
        }).forEach(System.out::println);
    }
}
