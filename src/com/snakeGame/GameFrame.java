package com.snakeGame;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    GamePanel panel;
    JPanel panel2;
    JLayeredPane layeredPane ;


    GameFrame() {
        panel = new GamePanel();
        panel2 = new MyPanel();
        layeredPane = new JLayeredPane();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);

        this.add(panel);
        this.add(panel2);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);


    }
}
