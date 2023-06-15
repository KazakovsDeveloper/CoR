package ru.otus.cor.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.cor.model.GameField;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;
import ru.otus.cor.utils.CheckCoordinates;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DetectVicinityTest {

    private DetectVicinity detectVicinity;
    private GameField gameField;
    private List<GameObject> allGameObjects;
    private List<Vicinity> vicinities;

    @BeforeEach
    public void init() {
        CheckCoordinates checkCoordinates = mock(CheckCoordinates.class);
        allGameObjects = new ArrayList<>();
        allGameObjects.add(new GameObject(5, 3, false, null));
        List<GameObject> gameObjects = new ArrayList<>();
        vicinities = List.of(new Vicinity(1, 5, gameObjects));
        when(checkCoordinates.isInVicinity(100, allGameObjects.get(0), vicinities.get(0))).thenReturn(true);
        gameField = new GameField(100, vicinities, allGameObjects);
        detectVicinity = new DetectVicinity(checkCoordinates);
    }

    @Test
    @DisplayName("добавить окрестность в объект и обозначить, что он должен быть передвинут")
    public void detectiveVicinityTest() {
        detectVicinity.execute(gameField);
        assertTrue(allGameObjects.get(0).isNeedToMove());
        assertEquals(vicinities.get(0), allGameObjects.get(0).getCurrentVicinity());
    }
}