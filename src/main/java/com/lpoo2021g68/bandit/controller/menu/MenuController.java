package com.lpoo2021g68.bandit.controller.menu;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.controller.Controller;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.menu.Menu;
import com.lpoo2021g68.bandit.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(game.getArenas().get(0)));
        }
    }
}
