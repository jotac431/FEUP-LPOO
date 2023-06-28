package com.lpoo2021g68.bandit.controller.game;

import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.model.game.elements.Monster;

public class MonsterController extends GameController{

    public MonsterController(Arena arena) {
        super(arena);
    }

    public void collision(){
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            if(getModel().getMonsters().get(i).getPosition().equals(getModel().getHero().getPosition().getPositionDirection(getModel().getHero().getDirection()))){
                //System.out.println("");
                getModel().removeMonster(i);
                //System.out.print("die");
                i--;
            }
        }
    }

    private void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position) && getModel().isEmptyMonster(position)) {
            monster.setPosition(position);
            if (getModel().getHero().getPosition().equals(position))
                getModel().getHero().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action){
        for (Monster monster : getModel().getMonsters())
            moveMonster(monster, monster.GetMonsterNextPosition(getModel()));
        collision();
    }
}