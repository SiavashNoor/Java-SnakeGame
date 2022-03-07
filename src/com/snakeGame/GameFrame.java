package com.snakeGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JFrame gameFrame;
    GameFrame(){
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(null);
        gameFrame.setSize(new Dimension(600,600));
        gameFrame.setVisible(true);
        gameFrame.getContentPane().setBackground(Color.BLACK);

    }



}
