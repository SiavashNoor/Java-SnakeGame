package com.snakeGame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel  {

    GamePanel(){

        this.setSize(new Dimension(400,600));
        this.setBackground(Color.black);
        

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.black);
        g2D.fillRect(100,100,40,40);



    }



}
