package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.LastDoor;

public class LastDoorViewer implements ElementViewer<LastDoor> {
    @Override
    public void draw(LastDoor lastDoor, GUI gui, DIRECTION dir) { gui.drawLastDoor(lastDoor.getPosition()); }
}