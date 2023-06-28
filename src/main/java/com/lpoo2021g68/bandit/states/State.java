package com.lpoo2021g68.bandit.states;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.controller.Controller;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui) throws IOException {
        viewer.draw(gui);
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action);
    }
}