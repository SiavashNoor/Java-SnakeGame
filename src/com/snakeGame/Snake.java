package com.snakeGame;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Snake {
    final int x, y, width, height ;

    public Snake(int x, int y, int width,int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height ;
    }

    public void drawSnake(Graphics2D g2d) {
        g2d.setColor(Color.green);
        Rectangle2D.Double e = new Rectangle2D.Double(x, y, width, height);
        g2d.fill(e);
    }
}
