package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui, DIRECTION dir) { gui.drawMonster(monster.getPosition()); }
}