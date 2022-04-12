package com.snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class GameFrame extends JFrame implements Observer{

    GamePanel gamePanel;

    ControlKeyListener keyListener ;
static int keyValueInFrame;
    GameFrame() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int GAME_WIDTH = 600;
        int GAME_HEIGHT = 600;
        gamePanel = new GamePanel(GAME_WIDTH, GAME_HEIGHT);
        keyListener = new ControlKeyListener();
        keyListener.addObserver(this);
        this.addKeyListener(keyListener);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.add(gamePanel);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);




    }

    @Override
    public void update(KeyEvent keyEvent) {
        keyValueInFrame = keyEvent.getKeyCode();
        System.out.println(keyValueInFrame+"this is inside the frame");
    }
}
