package com.lpoo2021g68.bandit.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private int width;
    private int height;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        screen = createScreen(terminal);
    }

    TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        this.height=height+1;
        this.width=width;
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.readInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.W;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a') return ACTION.A;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.S;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'd') return ACTION.D;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawHero(Position position, DIRECTION direction) {

        switch(direction) {
            case RIGHT:
                drawCharacter(position.getX(), position.getY(), 'O', "#FFD700");
                drawCharacter(position.getX()+1, position.getY(), '-', "#FFD700");
                break;
            case LEFT:
                drawCharacter(position.getX(), position.getY(), 'O', "#FFD700");
                drawCharacter(position.getX()-1, position.getY(), '-', "#FFD700");
                break;
            case UP:
                drawCharacter(position.getX(), position.getY(), 'O', "#FFD700");
                drawCharacter(position.getX(), position.getY()-1, '|', "#FFD700");
                break;
            case DOWN:
                drawCharacter(position.getX(), position.getY(), 'O', "#FFD700");
                drawCharacter(position.getX(), position.getY()+1, '|', "#FFD700");
                break;
        }

    }

    @Override
    public void drawOnWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }

    @Override
    public void drawOffWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '.', "#3333FF");
    }

    @Override
    public void drawSwitch(Position position) {
        drawCharacter(position.getX(), position.getY(), '*', "#EE3300");
    }

    @Override
    public void drawNextDoor(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#EE3300");
    }

    @Override
    public void drawLastDoor(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#EE3300");
    }

    @Override
    public void drawMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#CC0000");
    }


    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void changeBackgroundColor(String color) throws IOException {

        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }
}