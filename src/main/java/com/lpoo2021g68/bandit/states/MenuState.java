package com.lpoo2021g68.bandit.states;

import com.lpoo2021g68.bandit.controller.Controller;
import com.lpoo2021g68.bandit.controller.menu.MenuController;
import com.lpoo2021g68.bandit.model.menu.Menu;
import com.lpoo2021g68.bandit.viewer.Viewer;
import com.lpoo2021g68.bandit.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
