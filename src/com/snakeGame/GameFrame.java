package com.snakeGame;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    GamePanel panel;
    JPanel panel2;


    GameFrame() {
        panel = new GamePanel();
        panel2 = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.add(panel2);
        this.add(panel);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);


    }
}
