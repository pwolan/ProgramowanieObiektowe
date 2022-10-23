// link do repozytorium:
// https://github.com/pwolan/ProgramowanieObiektowe

package agh.ics.oop;

/*
* Zadanie 10
* a) trzymanie reprezentacji mapy w jakiejś strukturze danych. Metoda Animal.move sprawdza czy można wykonać ruch, następnie zmienia informacjie o danym obiekcie w reprezentacji mapy
* b) metoda Animal.move sprawdza rozmieszczenie wszystkich innych zwierząt przed decyzją czy może wykonać dany ruch. Wtedy wszystkie zwierzęta muszą być trzymane w jednej tablicy.
* */
public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        String[] input = new String[]{"r", "f", "f", "f"};
        var parser = new OptionsParser();
        var parsedInput = parser.parse(input);
        for(MoveDirection dir : parsedInput){
            animal.move(dir);
        }
        System.out.println(animal);
    }

}