package ru.otus.cor.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.cor.model.GameField;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveVicinityTest {

    private MoveVicinity moveVicinity;
    private GameField gameField;
    private Vicinity vicinity1;
    private GameObject gameObject;

    @BeforeEach
    public void init() {
        moveVicinity = new MoveVicinity();
        List<GameObject> allObjects = new ArrayList<>();
        List<GameObject> vicinityObjects = new ArrayList<>();
        Vicinity vicinity = new Vicinity(1, 2, vicinityObjects);
        gameObject = new GameObject(4, 7, true, vicinity);
        GameObject gameObject2 = new GameObject(4, 7, false, null);
        allObjects.add(gameObject);
        allObjects.add(gameObject2);
        List<Vicinity> vicinities = new ArrayList<>();
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(gameObject);
        vicinity1 = new Vicinity(5, 10, gameObjects);
        vicinities.add(vicinity1);
        gameField = new GameField(100, vicinities, allObjects);
    }


    @Test
    @DisplayName("переместить объект в новую окрестность и удалить из старой")
    public void moveVicinityTest() {
        moveVicinity.execute(gameField);
        assertTrue(vicinity1.getGameObjects().isEmpty());
        assertFalse(gameObject.isNeedToMove());
    }

}