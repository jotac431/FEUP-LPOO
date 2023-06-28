package com.lpoo2021g68.bandit;

import com.lpoo2021g68.bandit.gui.LanternaGUI;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.model.game.arena.LoaderArenaBuilder;
import com.lpoo2021g68.bandit.model.menu.Menu;
import com.lpoo2021g68.bandit.states.MenuState;
import com.lpoo2021g68.bandit.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private final LanternaGUI gui;
    private State state;
    private List<Arena> arenas = new ArrayList<>();

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(40, 40);
        this.state = new MenuState(new Menu());
        for (int i = 1; i < 6; i++) {
            this.arenas.add(new LoaderArenaBuilder(i).createArena());
        }
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setArenas() throws IOException {
        List<Arena> arenas2 = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            arenas2.add(new LoaderArenaBuilder(i).createArena());
        }
        this.arenas = arenas2;
    }

    public List<Arena> getArenas(){
        return this.arenas;
    }

    private void start() throws IOException {
        long startTime = System.currentTimeMillis();
        while (this.state != null) {

            state.step(this, gui);

        }
        long elapsedTime = System.currentTimeMillis() - startTime;

        gui.close();
    }
}