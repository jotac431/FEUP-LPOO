package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.Wall;

public class OnWallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui, DIRECTION dir) { gui.drawOnWall(wall.getPosition()); }
}