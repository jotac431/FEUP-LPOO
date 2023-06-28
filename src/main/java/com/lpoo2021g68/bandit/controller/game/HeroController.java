package com.lpoo2021g68.bandit.controller.game;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.game.arena.Arena;

public class HeroController extends GameController{
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getPositionDirection(DIRECTION.LEFT));
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getPositionDirection(DIRECTION.RIGHT));
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getPositionDirection(DIRECTION.UP));
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getPositionDirection(DIRECTION.DOWN));
    }

    public void dirSwordUp() { getModel().getHero().setDirection(DIRECTION.UP); }

    public void dirSwordLeft() {
        getModel().getHero().setDirection(DIRECTION.LEFT);
    }

    public void dirSwordRight() {
        getModel().getHero().setDirection(DIRECTION.RIGHT);
    }

    public void dirSwordDown() { getModel().getHero().setDirection(DIRECTION.DOWN); }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) {
                getModel().getHero().decreaseEnergy();
            }
        }
    }

    public boolean isNextDoor() {
        return getModel().isNextDoor(getModel().getHero().getPosition());
    }

    public boolean isLastDoor() {
        return getModel().isLastDoor(getModel().getHero().getPosition());
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.W) dirSwordUp();
        if (action == GUI.ACTION.A) dirSwordLeft();
        if (action == GUI.ACTION.S) dirSwordDown();
        if (action == GUI.ACTION.D) dirSwordRight();
    }
}
