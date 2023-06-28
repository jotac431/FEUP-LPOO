package com.lpoo2021g68.bandit.model.game.arena;

import com.lpoo2021g68.bandit.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setSwitches(createSwitches());
        arena.setNextDoors(createNextDoors());
        arena.setLastDoors(createLastDoors());
        arena.setLevel(getLevel());
        if (arena.getSwitches().size() > 0)
            arena.addWalls(arena.getSwitches().get(0).getWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract int getLevel();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Hero createHero();

    protected abstract List<NextDoor> createNextDoors();

    protected abstract List<LastDoor> createLastDoors();

    protected abstract List<Switch> createSwitches();

    protected abstract List<Wall> createSwitchWalls();

}