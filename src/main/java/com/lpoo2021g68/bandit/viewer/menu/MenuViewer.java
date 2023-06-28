package com.lpoo2021g68.bandit.viewer.menu;

import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.Position;
import com.lpoo2021g68.bandit.model.menu.Menu;
import com.lpoo2021g68.bandit.viewer.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        //gui.changeBackgroundColor("#E5E5DF");
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
