package com.lpoo2021g68.bandit.viewer.game;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.game.arena.Arena;
import com.lpoo2021g68.bandit.model.game.elements.Element;
import com.lpoo2021g68.bandit.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {

        //gui.changeBackgroundColor("#E5E5DF");
        drawElements(gui, getModel().getOnWalls(), new OnWallViewer());
        drawElements(gui, getModel().getOffWalls(), new OffWallViewer());
        drawElements(gui, getModel().getSwitches(), new SwitchViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getNextDoors(), new NextDoorViewer());
        drawElements(gui, getModel().getLastDoors(), new LastDoorViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());

        gui.drawText(new Position(0, 0), "Level: " + getModel().getLevel(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui, element.getDirection());
    }
}
