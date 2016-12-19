package com.bartek;


public class TheClockwiseSpiral {
    private int xAdder = 0;
    private int yAdder = 0;

    public int[][] createSpiral(int n) {
        if (n < 1) {
            return new int[0][0];
        }

        int rowSize = n;
        int max = (int) Math.pow(n, 2);

        int[][] array = new int[rowSize][rowSize];

        int currentValue = 0;
        int x = 0;
        int y = 0;

        xAdder = 0;
        yAdder = 0;

        // 0 - right, 1 - down, 2, left, 3 up
        int currentDirection = 0;

        while (currentValue < max) {
            x += xAdder;
            y += yAdder;

            if (checkBounds(rowSize, x, y) && isPlaceNotTaken(array, x, y)) {
                array[y][x] = ++currentValue;
                moveByDirection(currentDirection);
            } else {
                x -= xAdder;
                y -= yAdder;
                currentDirection = changeDirection(currentDirection);
                moveByDirection(currentDirection);
            }

        }

        return array;
    }

    private boolean checkBounds(int rowSize, int x, int y) {
        return x > -1 && x < rowSize && y > -1 && y < rowSize;
    }

    private boolean isPlaceNotTaken(int[][] result, int x, int y) {
        return result[y][x] == 0;
    }

    private void moveByDirection(int currentDirection) {
        switch (currentDirection) {
            case 0: {
                xAdder = 1;
                yAdder = 0;
                break;
            }
            case 1: {
                xAdder = 0;
                yAdder = 1;
                break;
            }
            case 2: {
                xAdder = -1;
                yAdder = 0;
                break;
            }
            case 3: {
                xAdder = 0;
                yAdder = -1;
                break;
            }
        }
    }

    private int changeDirection(int currentDirection) {
        return ++currentDirection % 4;
    }
}
