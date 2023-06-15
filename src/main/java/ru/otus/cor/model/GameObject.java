package ru.otus.cor.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameObject {

    private int x;
    private int y;
    private boolean isNeedToMove;
    private Vicinity currentVicinity;
}
