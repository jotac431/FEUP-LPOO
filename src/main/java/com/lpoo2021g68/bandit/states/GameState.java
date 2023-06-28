package com.lpoo2021g68.bandit.states;

import com.lpoo2021g68.bandit.controller.Controller;
import com.lpoo2021g68.bandit.controller.game.ArenaController;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.viewer.Viewer;
import com.lpoo2021g68.bandit.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
