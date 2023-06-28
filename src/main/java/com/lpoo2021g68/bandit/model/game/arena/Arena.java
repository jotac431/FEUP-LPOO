package com.lpoo2021g68.bandit.model.game.arena;

import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private int level;

    private List<Monster> monsters;
    private List<Wall> walls;
    private List<NextDoor> nextDoors;
    private List<LastDoor> lastDoors;
    private List<Switch> switches;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void removeMonster(int index) {
        monsters.remove(index);
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getOnWalls() {
        List<Wall> onWalls = new ArrayList<>();
        for (Wall wall : walls){
            if (wall.getOn()) onWalls.add(wall);
        }
        return onWalls;
    }

    public List<Wall> getOffWalls() {
        List<Wall> offWalls = new ArrayList<>();
        for (Wall wall : walls){
            if (!wall.getOn()) offWalls.add(wall);
        }
        return offWalls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void addWalls(List<Wall> walls) {
        this.walls.addAll(walls);
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                if(wall.getOn())
                    return false;
        return true;
    }

    public boolean isEmptyMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public List<NextDoor> getNextDoors() {
        return nextDoors;
    }

    public void setNextDoors(List<NextDoor> nextDoors) {
        this.nextDoors = nextDoors;
    }

    public boolean isNextDoor(Position position) {
        for (NextDoor nextDoor : nextDoors)
            if (nextDoor.getPosition().equals(position))
                return true;
        return false;
    }

    public List<LastDoor> getLastDoors() {
        return lastDoors;
    }

    public void setLastDoors(List<LastDoor> lastDoors) {
        this.lastDoors = lastDoors;
    }

    public boolean isLastDoor(Position position) {
        for (LastDoor lastDoor : lastDoors)
            if (lastDoor.getPosition().equals(position))
                return true;
        return false;
    }

    public List<Switch> getSwitches() {
        return switches;
    }

    public void setSwitches(List<Switch> switches) {
        this.switches = switches;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }
}
