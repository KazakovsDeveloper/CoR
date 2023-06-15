package ru.otus.cor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * окрестность содержит лист игровых объектов
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vicinity {

    private int x;
    private int y;
    private List<GameObject> gameObjects;

}
