package com.bartek;

import java.util.ArrayList;
import java.util.List;

public class StreetFighter2CharacterSelection {

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        if (position.length != 2 || position[0] >= fighters.length || position[1] >= fighters[0].length) {
            throw new IllegalArgumentException("Wrong position argument, please check!");
        }

        int x = position[0];
        int y = position[1];

        List<String> selectedFigters = new ArrayList<>();

        for (String move : moves) {
            switch (move) {
                case "up":
                    y = Math.max(0, y - 1);
                    break;
                case "down":
                    y++;
                    y = y == fighters.length  ? y - 1 : y;
                    break;
                case "left":
                    x--;
                    x = x >= 0 ? x : fighters[0].length - 1;
                    break;

                case "right":
                    x++;
                    x = x == fighters[0].length ? 0 : x ;
                    break;
            }

            selectedFigters.add(fighters[y][x]);
        }

        return selectedFigters.toArray(new String[selectedFigters.size()]);
    }
}
