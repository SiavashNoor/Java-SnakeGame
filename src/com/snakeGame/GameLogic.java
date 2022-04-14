package com.snakeGame;


import java.awt.event.KeyEvent;
import java.util.*;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class GameLogic implements Observer  {

    static private final int GAME_HEIGHT = 20;
    static private final int GAME_WIDTH = 20;
    ControlKeyListener controlKeyListener;
    Direction currentDirection;
    int keyCodeValue;
    public static char[][] gameBoard = new char[GAME_HEIGHT][GAME_WIDTH];
    Random rand;
    boolean gameValid = false;
    boolean appleIsEaten = false;
    int appleXPosition;
    int appleYPosition;
    LinkedList<Integer> snakeXValues = new LinkedList<>();
    LinkedList<Integer> snakeYValues = new LinkedList<>();


    public GameLogic() {
        controlKeyListener = new ControlKeyListener();
        controlKeyListener.addObserver(this);
        gameStart();
        while (gameIsValid()) {
            // System.out.println(keyCodeValue +"   this is keycode value");
            gamePlay();
        }
        gameEnd();
        System.out.println();
    }

    void gameStart() {
        makeGamePlain();
        addApple();
        addSnake();
        paintApple();
        paintBoard();
        while(GameFrame.keyValueInFrame == 0){
            gameValid =false;
            wait(50);
        }
        gameValid=true;
    }

    void gamePlay() {
        getDirection();
        makeGamePlain();
        paintApple();
        updateMovement();
        appleIsEaten();
        paintBoard();
        wait(1000);
    }

    void gameEnd() {
    }

    void makeGamePlain() {
        for (char[] row : gameBoard) {
            Arrays.fill(row, '.');
        }
    }

    void paintBoard() {
        for (char[] i : gameBoard) {
            for (char j : i) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }


    void addApple() {
        rand = new Random();
        appleXPosition = rand.nextInt(GAME_WIDTH);
        appleYPosition = rand.nextInt(GAME_HEIGHT);
        System.out.println(appleXPosition + " " + appleYPosition);
    }

    void paintApple() {
        gameBoard[appleYPosition][appleXPosition] = '@';
    }

    void addSnake() {
        snakeXValues.addFirst(3);
        snakeXValues.addFirst(4);
        snakeXValues.addFirst(5);
        snakeYValues.addFirst(3);
        snakeYValues.addFirst(3);
        snakeYValues.addFirst(3);
        currentDirection = Direction.RIGHT;
        for (int i = 0; i < snakeYValues.size(); i++) {
            gameBoard[snakeYValues.get(i)][snakeXValues.get(i)] = '#';
        }
    }

    void updateMovement() {
        int dx = 0;
        int dy = 0;
        switch (currentDirection) {
            case LEFT -> dx = -1;
            case RIGHT -> dx = 1;
            case UP -> dy = -1;
            case DOWN -> dy = 1;
        }
//the below part of code is for updating movement and also wall transparency.
        int headXPosition = snakeXValues.getFirst() + dx;
        if (headXPosition < 0) {
            snakeXValues.addFirst(GAME_WIDTH - 1);
        } else if (headXPosition > GAME_WIDTH - 1) {
            snakeXValues.addFirst(0);
        } else snakeXValues.addFirst(headXPosition);

        int headYPosition = snakeYValues.getFirst() + dy;
        if (headYPosition < 0) {
            snakeYValues.addFirst(GAME_HEIGHT - 1);
        } else if (headYPosition > GAME_HEIGHT - 1) {
            snakeYValues.addFirst(0);
        } else {
            snakeYValues.addFirst(headYPosition);
        }
        if (!appleIsEaten) {
            snakeYValues.removeLast();
            snakeXValues.removeLast();
        }

        for (int i = 0; i < snakeYValues.size(); i++) {
            gameBoard[snakeYValues.get(i)][snakeXValues.get(i)] = '#';
        }
    }

    boolean gameIsValid() {
        if (snakeSelfCollision()) {
            System.out.println("you lost the game");
            System.exit(1);
        }
        return gameValid;
    }

    void getDirection() {
        keyCodeValue = GameFrame.keyValueInFrame;
        switch (keyCodeValue) {
            case 38:
                if (currentDirection != Direction.DOWN) {
                    currentDirection = Direction.UP;
                }
                break;
            case 40:
                if (currentDirection != Direction.UP) {
                    currentDirection = Direction.DOWN;
                }
                break;
            case 37:
                if (currentDirection != Direction.RIGHT) {
                    currentDirection = Direction.LEFT;
                }
                break;
            case 39:
                if (currentDirection != Direction.LEFT) {
                    currentDirection = Direction.RIGHT;
                }
                break;
            case 555:
                System.exit(0);
            default:
                System.out.println("not a valid command");
        }
        System.out.println(currentDirection);
    }

    void appleIsEaten() {
        if (snakeXValues.getFirst() == appleXPosition && snakeYValues.getFirst() == appleYPosition) {
            appleIsEaten = true;
            addApple();
        } else appleIsEaten = false;
    }

    boolean snakeSelfCollision() {
        boolean collision = false;
        for (int i = 3; i < snakeXValues.size(); i++) {
            if ((Objects.equals(snakeXValues.getFirst(), snakeXValues.get(i))) &&
                    (Objects.equals(snakeYValues.getFirst(), snakeYValues.get(i)))) {
                collision = true;
            }
        }
        return collision;
    }

    void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(KeyEvent keyEvent) {
        keyCodeValue = keyEvent.getKeyCode();
        System.out.println(keyCodeValue + "gamelogic  ");
    }
}


