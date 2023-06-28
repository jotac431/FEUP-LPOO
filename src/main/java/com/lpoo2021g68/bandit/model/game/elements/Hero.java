package com.lpoo2021g68.bandit.model.game.elements;

import com.lpoo2021g68.bandit.model.DIRECTION;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y, DIRECTION direction) {
        super(x, y, direction);
        this.energy = 1;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }

    public void restartLevel() {

    }
}