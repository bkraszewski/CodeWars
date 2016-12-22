package com.bartek;

import java.util.HashMap;
import java.util.Map;


public class Tour {
    public static int tour(String[] friends1, String[][] fTowns1, Map<String, Double> distTable1) {
        Map<String, String> friendTowns = new HashMap<>();
        for (String[] friendWithTown : fTowns1) {
            if (friendWithTown.length == 2) {
                friendTowns.put(friendWithTown[0], friendWithTown[1]);
            }
        }

        double totalRoute = 0;

        for (int i = 0; i < friends1.length; i++) {
            String currentFriend = friends1[i];
            String currentFriendTown = getFriendTown(currentFriend, friendTowns);

            if (currentFriendTown == null) {
                //friend is unknown, we can't calculate the road
                continue;
            }

            if (i == 0) {
                totalRoute += distTable1.get(currentFriendTown);
            } else {
                String prevFriend = friends1[i - 1];
                String prevFriendTown = getFriendTown(prevFriend, friendTowns);

                double b = calculateDistanceBetweenCities(distTable1, currentFriendTown, prevFriendTown);
                totalRoute += b;
            }
        }

        for (int i = friends1.length - 1; i >= 0; i--) {
            String lastFriend = friends1[i];
            String lastFriendTown = getFriendTown(lastFriend, friendTowns);
            if (lastFriendTown == null) {
                continue;
            }

            totalRoute += distTable1.get(lastFriendTown);
            break;
        }

        return (int) Math.floor(totalRoute);
    }

    private static double calculateDistanceBetweenCities(Map<String, Double> distTable1, String currentFriendTown, String prevFriendTown) {
        // a2 + b2 = c2
        double c = distTable1.get(currentFriendTown);
        double a = distTable1.get(prevFriendTown);

        return Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
    }

    private static String getFriendTown(String currentFriend, Map<String, String> friendTowns) {
        return friendTowns.get(currentFriend);
    }
}
