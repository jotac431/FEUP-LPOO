package com.lpoo2021g68.bandit.model.game.elements;

import com.lpoo2021g68.bandit.model.DIRECTION;

public class Wall extends Element {
    private boolean on;
    public Wall(int x, int y, DIRECTION direction, boolean on) {
        super(x, y, direction);
        this.on = on;
    }
    public boolean getOn(){
        return on;
    }

    public void setOn(){
        this.on = true;
    }

    public void setOff(){
        this.on = false;
    }
}