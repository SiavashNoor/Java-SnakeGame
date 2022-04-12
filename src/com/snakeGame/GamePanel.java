package com.snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    int gameWidth;
    int gameHeight;
    Rectangle2D.Double rec;

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

        g2d.setColor(Color.blue);
        for (int i = 0; i < 6; i++) {
            rec = new Rectangle2D.Double(i * 100, i * 100, 100, 100);
            g2d.fill(rec);

        }
    }



    public void paintGameBoard(char[][] gameBoard, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (char[] row : gameBoard){
            for(char pixel : row){
               switch (pixel){
                   case '.' -> g2d.setColor(Color.black);
               }
            }
        }

    }
}
