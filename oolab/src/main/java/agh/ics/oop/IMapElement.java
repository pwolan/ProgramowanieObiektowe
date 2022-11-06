package agh.ics.oop;

public interface IMapElement {

    Vector2d getPosition();
}

/*
* Animal i Grass nie mają dużo takich samych metod, w zasadzie głównie getPosition.
* Myślałem o tym aby trzymać wszystkie elementy w jednej tablicy zamiast w dwóch (animals, grassTufts), ale tworzyło by to problemy w niektórych metodach, gdzie i tak musiałbym sprawdzać czy obiekt jest Animalem czy Grassem. Możliwe że w przyszłości będzie to lepsze, ale na ten moment nie jest.
* Nie sądzę żeby był on bardzo potrzebny w tym momencie, być może jeśli pojawi się więcej elementów mapy będzie bardziej potrzebny
* AbstractWorldMapElement wydaje się tu póki co także niezbyt potrzebny z podobnych powodów.
*
* */