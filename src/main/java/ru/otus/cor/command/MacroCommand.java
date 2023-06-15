package ru.otus.cor.command;

import ru.otus.cor.model.GameField;

import java.util.List;

/**
 * Все эти команды помещает в макрокоманду и эту макрокоманду записывает
 * на место аналогичной макрокоманды для предыдущей окрестности.
 */
public class MacroCommand {

    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute(GameField gameField) {
        for (Command command : commands) {
            command.execute(gameField);
        }
    }
}
