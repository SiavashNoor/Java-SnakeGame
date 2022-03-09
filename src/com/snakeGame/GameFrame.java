package com.snakeGame;
import javax.swing.*;


public class GameFrame extends JFrame {
    JFrame gameFrame;
    GamePanel panel;
    JPanel  panel2;


    GameFrame(){
        panel = new GamePanel();
        panel2 = new MyPanel();
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(600,600);
        //gameFrame.getContentPane().setBackground(Color.BLACK);
        gameFrame.setLayout(null);
        gameFrame.add(panel);
        gameFrame.add(panel2);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);




    }
}
