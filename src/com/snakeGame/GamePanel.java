package com.snakeGame;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    int gameWidth;
    int gameHeight;


    GamePanel(int gameWidth, int gameHeight) {

        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        this.setBounds(0, 0, gameWidth, gameHeight);
        this.setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
       paintGameBoard(GameLogic.gameBoard,g2d);
    }

    public  void paintGameBoard(char[][] gameBoard,Graphics2D g2d) {
        int unitWidth = gameWidth /gameBoard[0].length ;
        int unitHeight = gameHeight /gameBoard.length;

        for (int i = 0; i<20;i++ ) {
            for (int j = 0;j<20;j++) {
                switch (gameBoard[i][j]) {
                    case '#' -> {
                        Snake snake = new Snake(j*unitWidth, i*unitHeight, unitWidth,unitHeight);
                        snake.drawSnake(g2d);
                    }
                    case '@' -> {
                        Apple apple = new Apple(j*unitWidth, i*unitHeight, unitWidth,unitHeight);
                        apple.drawApple(g2d);

                    }
                }
            }
        }
        repaint();
    }

}
