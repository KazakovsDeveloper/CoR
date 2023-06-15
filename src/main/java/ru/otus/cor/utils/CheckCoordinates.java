package ru.otus.cor.utils;

import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;

public class CheckCoordinates {

    public boolean isInVicinity(int sizeOfVicinity, GameObject object, Vicinity vicinity) {
        int vicinityX = vicinity.getX() * sizeOfVicinity;
        int vicinityY = vicinity.getY() * sizeOfVicinity;

        int objectX = object.getX();
        int objectY = object.getY();

        return objectX >= vicinityX && objectX < vicinityX + sizeOfVicinity &&
                objectY >= vicinityY && objectY < vicinityY + sizeOfVicinity;
    }

}
