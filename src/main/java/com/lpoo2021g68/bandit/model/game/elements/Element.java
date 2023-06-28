package com.lpoo2021g68.bandit.model.game.elements;

import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;

public class Element {
    private Position position;
    private DIRECTION direction;

    public Element(int x, int y, DIRECTION direction) {

        this.position = new Position(x, y);
        this.direction = direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
}