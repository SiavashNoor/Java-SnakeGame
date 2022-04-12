package com.snakeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ControlKeyListener implements KeyListener, Observable {
    private int keyPressed;
    private ArrayList<Observer> obsList;


    ControlKeyListener() {
        obsList = new ArrayList<>();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        keyPressed = e.getKeyCode();
        System.out.println(keyPressed);
        notifyObserver(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }



    @Override
    public void notifyObserver(KeyEvent keyEvent) {
        for (Observer obs : obsList) {
            obs.update(keyEvent);
        }
    }

    public void addObserver(Observer obs) {
        if (obs != null)
            obsList.add(obs);
        System.out.println(Arrays.deepToString(obsList.toArray()));
    }

}

