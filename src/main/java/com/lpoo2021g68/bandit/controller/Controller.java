package com.lpoo2021g68.bandit.controller;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action) throws IOException;
}
