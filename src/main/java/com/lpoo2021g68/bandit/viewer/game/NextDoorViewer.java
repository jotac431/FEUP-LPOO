package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.NextDoor;

public class NextDoorViewer implements ElementViewer<NextDoor> {
    @Override
    public void draw(NextDoor nextDoor, GUI gui, DIRECTION dir) { gui.drawNextDoor(nextDoor.getPosition()); }
}