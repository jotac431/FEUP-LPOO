package com.lpoo2021g68.bandit.model.game.elements;

import com.lpoo2021g68.bandit.model.DIRECTION;

import java.util.List;

public class Switch extends Element {
    private List<Wall> walls;
    public Switch(int x, int y, DIRECTION direction, List<Wall> walls) {
        super(x, y, direction);
        this.walls = walls;
    }

    public List<Wall> getWalls(){
        return walls;
    }
}