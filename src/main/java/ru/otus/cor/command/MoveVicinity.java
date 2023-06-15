package ru.otus.cor.command;

import ru.otus.cor.model.GameField;
import ru.otus.cor.model.GameObject;
import ru.otus.cor.model.Vicinity;

import java.util.List;

/**
 * если объект попал в новую окрестность, то удаляет его из списка объектов старой окрестности и добавляет список
 * объектов новой окрестности
 */
public class MoveVicinity implements Command {

    @Override
    public void execute(GameField gameField) {
        // фильтруем те объекты, которые нужно переместить
        List<GameObject> filteredGameObjects = gameField.getAllGameObjects()
                .stream()
                .filter(GameObject::isNeedToMove)
                .toList();
        // добавляем объекты в новые окрестности
        filteredGameObjects.forEach(this::addObjectToVicinity);
        // удаляем объекты из предыдущих окрестностей
        List<Vicinity> vicinities = gameField.getVicinities();
        this.deleteObjectFromVicinity(vicinities, filteredGameObjects);
        // меняем флаг необходимости перемещения
        filteredGameObjects.forEach(gameObject -> gameObject.setNeedToMove(false));
    }

    private void addObjectToVicinity(GameObject gameObject) {
        Vicinity currentVicinity = gameObject.getCurrentVicinity();
        currentVicinity.getGameObjects().add(gameObject);
    }

    private void deleteObjectFromVicinity(List<Vicinity> vicinities, List<GameObject> gameObjects) {
        for (Vicinity vicinity : vicinities) {
            gameObjects
                    .forEach(gameObject -> {
                        if (!gameObject.getCurrentVicinity().equals(vicinity)) {
                            vicinity.getGameObjects().remove(gameObject);
                        }
                    });
        }
    }
}
