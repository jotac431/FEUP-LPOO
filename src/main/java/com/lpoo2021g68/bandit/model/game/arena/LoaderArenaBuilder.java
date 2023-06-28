package com.lpoo2021g68.bandit.model.game.arena;

import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') walls.add(new Wall(x, y, DIRECTION.RIGHT, true));
            }
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y, DIRECTION.RIGHT));
        }

        return monsters;
    }

    @Override
    protected Hero createHero() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Hero(x, y, DIRECTION.RIGHT);
        }
        return null;
    }

    @Override
    protected List<NextDoor> createNextDoors() {
        List<NextDoor> nextDoors = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '+') nextDoors.add(new NextDoor(x, y, DIRECTION.RIGHT));
        }

        return nextDoors;
    }

    @Override
    protected List<LastDoor> createLastDoors() {
        List<LastDoor> lastDoors = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '%') lastDoors.add(new LastDoor(x, y, DIRECTION.RIGHT));
        }

        return lastDoors;
    }

    @Override
    protected List<Switch> createSwitches() {
        List<Switch> switches = new ArrayList<>();
        List<Wall> walls = createSwitchWalls();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '*') switches.add(new Switch(x, y, DIRECTION.RIGHT, walls));
            }
        }
        return switches;
    }

    @Override
    protected List<Wall> createSwitchWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '1') walls.add(new Wall(x, y, DIRECTION.RIGHT, true));
                if (line.charAt(x) == '0') walls.add(new Wall(x, y, DIRECTION.RIGHT, false));
            }
        }
        return walls;
    }

    @Override
    protected int getLevel() {
        return this.level;
    }
}