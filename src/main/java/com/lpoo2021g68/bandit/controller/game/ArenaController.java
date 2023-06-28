package com.lpoo2021g68.bandit.controller.game;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.model.menu.Menu;
import com.lpoo2021g68.bandit.states.GameState;
import com.lpoo2021g68.bandit.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {

    private final HeroController heroController;
    private final MonsterController monsterController;
    private final SwitchController switchController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.switchController = new SwitchController(arena);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0 || getModel().getLevel() == 5) {
            game.setArenas();
            game.setState(new MenuState(new Menu()));
        }
        else {
            heroController.step(game, action);
            monsterController.step(game, action);
            switchController.step(game, action);
            if (heroController.isNextDoor()) game.setState(new GameState(game.getArenas().get(getModel().getLevel())));
            if (heroController.isLastDoor()) game.setState(new GameState(game.getArenas().get(getModel().getLevel()-2)));
        }
    }
}
