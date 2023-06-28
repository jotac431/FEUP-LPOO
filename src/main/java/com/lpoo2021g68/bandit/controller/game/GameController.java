package com.lpoo2021g68.bandit.controller.game;

import com.lpoo2021g68.bandit.controller.Controller;
import com.lpoo2021g68.bandit.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
