package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui, DIRECTION dir);
}