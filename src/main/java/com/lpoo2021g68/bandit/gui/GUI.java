package com.lpoo2021g68.bandit.gui;

import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position, DIRECTION direction);

    void drawOnWall(Position position);

    void drawOffWall(Position position);

    void drawNextDoor(Position position);

    void drawLastDoor(Position position);

    void drawMonster(Position position);

    void drawSwitch(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void changeBackgroundColor(String color) throws IOException;

    void drawText(Position position, String text, String color);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, W, A, S, D, SELECT}
}