package com.lpoo2021g68.bandit.model;

import java.util.Objects;
import java.util.HashMap;

public class Position {
    private final int x;
    private final int y;
    private static HashMap<DIRECTION, Position> directionIncrements;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        if(directionIncrements == null) {
            directionIncrements = new HashMap<>();
            directionIncrements.put(DIRECTION.UP, new Position(0,-1));
            directionIncrements.put(DIRECTION.DOWN, new Position(0,1));
            directionIncrements.put(DIRECTION.RIGHT, new Position(1,0));
            directionIncrements.put(DIRECTION.LEFT, new Position(-1,0));
        }
    }

    //Vê a direção no HashMap e adiciona o valor à nova posição
    public Position getPositionDirection(DIRECTION direction) { return this.add(directionIncrements.get(direction));
    }

    //Retorna a posição dependendo da direção do HashMap
    public Position add(Position pos) {
        return new Position(this.x + pos.getX(), this.y + pos.getY());
    }

    public int getManhattanDistance(Position pos) {
        return Math.abs(y - pos.getY()) + Math.abs(x - pos.getX());
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
