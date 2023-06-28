package com.lpoo2021g68.bandit.controller.game;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.model.game.elements.Switch;
import com.lpoo2021g68.bandit.model.game.elements.Wall;


public class SwitchController extends GameController{

    public SwitchController(Arena arena) {
        super(arena);
    }

    public void collision(){
        for (int i = 0; i < getModel().getSwitches().size(); i++) {
            if(getModel().getSwitches().get(i).getPosition().equals(getModel().getHero().getPosition().getPositionDirection(getModel().getHero().getDirection()))){
                changeWalls(getModel().getSwitches().get(i));
            }
        }
    }

    public void changeWalls(Switch switched){
        for (Wall wall : switched.getWalls()){
            if (!wall.getOn()) wall.setOn();
            else
                wall.setOff();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        collision();
    }
}