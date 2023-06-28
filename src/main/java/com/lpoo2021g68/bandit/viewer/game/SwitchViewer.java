package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.Switch;

public class SwitchViewer implements ElementViewer<Switch> {
    @Override
    public void draw(Switch switche, GUI gui, DIRECTION dir) { gui.drawSwitch(switche.getPosition()); }
}