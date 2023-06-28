package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui, DIRECTION dir) { gui.drawHero(hero.getPosition(), dir); }
}
