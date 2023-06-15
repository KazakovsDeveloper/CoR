package ru.otus.cor.command;

import ru.otus.cor.model.GameField;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;

import java.util.List;

/**
 * команда отправляет на проверку объекты в окрестностях
 */
public class CreateCheckCollision implements Command {

    @Override
    public void execute(GameField gameField) {
        // находим окрестности, в которых больше 1 объекта
        List<Vicinity> vicinities = gameField.getVicinities().stream()
                .filter(vicinity -> vicinity.getGameObjects().size() > 1)
                .toList();

        // проверка коллизий
        vicinities.forEach(vicinity -> checkCollision(vicinity.getGameObjects()));
    }

    private void checkCollision(List<GameObject> gameObjects) {
        // не нужно реализовывать по ТЗ
    }
}
