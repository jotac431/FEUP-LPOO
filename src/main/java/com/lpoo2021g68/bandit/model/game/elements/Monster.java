package com.lpoo2021g68.bandit.model.game.elements;

import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.game.arena.Arena;

public class Monster extends Element {
    public Monster(int x, int y, DIRECTION direction) {
        super(x, y, direction);
    }

    public Position GetMonsterNextPosition(Arena arena) {
        Position heroPosition = arena.getHero().getPosition();
        DIRECTION bestDirection = DIRECTION.UP;
        int bestDistance = Integer.MAX_VALUE;
        for (DIRECTION dir : DIRECTION.values()) {
            if(this.getPosition().getPositionDirection(dir).getManhattanDistance(heroPosition) < bestDistance) {
                bestDistance = this.getPosition().getPositionDirection(dir).getManhattanDistance(heroPosition);
                bestDirection = dir;
            }
        }
        return this.getPosition().getPositionDirection(bestDirection);

    }
}