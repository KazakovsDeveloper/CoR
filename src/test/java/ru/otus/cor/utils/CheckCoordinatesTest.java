package ru.otus.cor.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckCoordinatesTest {

    private CheckCoordinates checkCoordinates;
    private GameObject gameObject;
    private Vicinity vicinity;
    private GameObject gameObject2;
    private Vicinity vicinity2;

    @BeforeEach
    public void init() {
        checkCoordinates = new CheckCoordinates();
        gameObject = new GameObject(5, 5, false, null);
        List<GameObject> gameObjects = new ArrayList<>();
        vicinity = new Vicinity(0, 0, gameObjects);
        gameObject2 = new GameObject(1, 3, false, null);
        vicinity2 = new Vicinity(4, 6, gameObjects);
    }

    @Test
    @DisplayName("вернуть true, если объект находится в окрестности")
    public void checkCoordinatesTestTrue() {
        boolean inVicinity = checkCoordinates.isInVicinity(10, gameObject, vicinity);
        assertTrue(inVicinity);
    }

    @Test
    @DisplayName("вернуть false, если объект не находится в окрестности")
    public void checkCoordinatesTestFalse() {
        boolean inVicinity = checkCoordinates.isInVicinity(10, gameObject2, vicinity2);
        assertFalse(inVicinity);
    }

}