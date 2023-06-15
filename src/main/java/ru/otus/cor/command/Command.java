package ru.otus.cor.command;

import ru.otus.cor.model.GameField;

public interface Command {

    void execute(GameField gameField);

}
