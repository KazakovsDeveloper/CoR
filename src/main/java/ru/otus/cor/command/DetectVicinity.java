package ru.otus.cor.command;

import ru.otus.cor.model.GameField;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;
import ru.otus.cor.utils.CheckCoordinates;

import java.util.List;
import java.util.Optional;

/**
 * определяет окрестность, в которой присутствует игровой объект
 */
public class DetectVicinity implements Command {

    private final CheckCoordinates checkCoordinates;

    public DetectVicinity(CheckCoordinates checkCoordinates) {
        this.checkCoordinates = checkCoordinates;
    }

    @Override
    public void execute(GameField gameField) {
        List<Vicinity> vicinities = gameField.getVicinities();
        List<GameObject> gameObjects = gameField.getAllGameObjects();

        for (GameObject gameObject : gameObjects) {
            // находим область, в которой находится объект
            Optional<Vicinity> first = vicinities.stream()
                    .filter(vicinity -> checkCoordinates.isInVicinity(gameField.getSize(), gameObject, vicinity))
                    .findFirst();

            // проверяем, лежит ли объект в данной области
            if (first.isPresent()) {
                Vicinity vicinity = first.get();
                if (!vicinity.getGameObjects().contains(gameObject)) {
                    // добавляем флаг, что объект нужно переместить
                    gameObject.setNeedToMove(true);
                    gameObject.setCurrentVicinity(vicinity);
                }
            }
        }
    }
}
