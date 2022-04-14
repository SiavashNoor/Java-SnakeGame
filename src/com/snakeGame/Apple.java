package com.snakeGame;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Apple{

    final int x, y, width,height;

    public Apple(int x, int y, int width,int height) {
        this.x = x;
        this.y = y;
        this.width= width;
        this.height = height;
    }

    public void drawApple(Graphics2D g2d) {
        g2d.setColor(Color.red);
        Ellipse2D.Double e = new Ellipse2D.Double(x, y, width, height);
        g2d.fill(e);

    }
}
