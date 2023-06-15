package ru.otus.cor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * игровое поле разбитое на окрестности
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameField {

    private int size;
    private List<Vicinity> vicinities;
    private List<GameObject> gameObjects;

}
