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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MacroCommandTest {

    private MacroCommand macroCommand;
    private GameField gameField;

    @BeforeEach
    public void init() {
        List<Command> commands = new ArrayList<>();
        CheckCoordinates checkCoordinates = mock(CheckCoordinates.class);
        Command detect = new DetectVicinity(checkCoordinates);
        when(checkCoordinates.isInVicinity(anyInt(), any(), any())).thenReturn(true);
        Command move = new MoveVicinity();
        Command createCheckCollision = new CreateCheckCollision();
        // складываем команды по цепочке обязанностей
        commands.add(detect);
        commands.add(move);
        commands.add(createCheckCollision);
        macroCommand = new MacroCommand(commands);


        List<Vicinity> allVicinities = new ArrayList<>();
        List<GameObject> gameObjects = new ArrayList<>();
        Vicinity vicinity = new Vicinity(1, 10, gameObjects);
        allVicinities.add(vicinity);
        List<GameObject> allObjects = new ArrayList<>();
        GameObject gameObject = new GameObject(1, 2, true, vicinity);
        allObjects.add(gameObject);
        gameField = new GameField(100, allVicinities, allObjects);
    }

    @Test
    @DisplayName("проверяем, что команды выполнились")
    public void macroCommandTest() {
        macroCommand.execute(gameField);
        assertFalse(gameField.getVicinities().get(0).getGameObjects().isEmpty());
        assertFalse(gameField.getVicinities().get(0).getGameObjects().get(0).isNeedToMove());
    }
}