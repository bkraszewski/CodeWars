package com.bartek;

import com.bartek.model.Robot;

import java.util.*;


public class EightiesKids6 {


    private static final String DRAW_MESSAGE = "The fight was a draw.";
    private static final String WINNER_MESSAGE = "%s has won the fight.";

    public static String fight(Robot robot1, Robot robot2, Map<String, Integer> tactics) {
        List<FightingRobot> fighters = setupFighters(robot1, robot2);
        int currentRobot = 0;
        int nextRobot = 1;

        while (bothAlive(fighters) && anyHasHit(fighters)) {
            FightingRobot current = fighters.get(currentRobot);
            FightingRobot next = fighters.get(nextRobot);

            if (current.canHit()) {
                String hitName = current.getNextHitName();
                int power = tactics.get(hitName);

                fighters.set(currentRobot, current.performHit());
                fighters.set(nextRobot, next.receiveHit(power));
            }

            int temp = currentRobot;
            currentRobot = nextRobot;
            nextRobot = temp;
        }

        String winnerName = detectWinner(fighters.get(currentRobot), fighters.get(nextRobot));
        if (winnerName == null) {
            return DRAW_MESSAGE;
        }
        return String.format(WINNER_MESSAGE, winnerName);

    }

    private static String detectWinner(FightingRobot robot1, FightingRobot robot2) {
        if (robot1.isAlive() && robot2.isAlive()) {
            if (robot1.getHealth() == robot2.getHealth()) {
                return null;
            } else if (robot1.getHealth() > robot2.getHealth()) {
                return robot1.getName();
            } else {
                return robot2.getName();
            }
        }

        return robot1.isAlive() ? robot1.getName() : robot2.getName();
    }

    private static boolean anyHasHit(List<FightingRobot> figters) {
        return figters.stream().anyMatch(FightingRobot::canHit);
    }

    private static boolean bothAlive(List<FightingRobot> figters) {
        return figters.stream().allMatch(FightingRobot::isAlive);
    }

    private static List<FightingRobot> setupFighters(Robot robot1, Robot robot2) {
        List<FightingRobot> fighters = new ArrayList<>(2);
        fighters.add(new FightingRobot(robot1));
        fighters.add(new FightingRobot(robot2));
        Collections.sort(fighters, (o1, o2) -> o2.getSpeed() - o1.getSpeed());
        return fighters;
    }
}

class FightingRobot {
    private Robot robot;

    public FightingRobot(Robot robot) {
        this.robot = robot;
    }

    public boolean canHit() {
        return robot.getTactics().length > 0;
    }

    public boolean isAlive() {
        return robot.getHealth() > 0;
    }

    public FightingRobot performHit() {
        if (!canHit()) {
            return this;
        }

        String[] hits = Arrays.copyOfRange(robot.getTactics(), 1, robot.getTactics().length);
        robot = (new Robot(robot.getName(), robot.getHealth(), robot.getSpeed(), hits));
        return this;
    }

    public FightingRobot receiveHit(int power) {
        robot = (new Robot(robot.getName(), robot.getHealth() - power, robot.getSpeed(), robot.getTactics()));
        return this;
    }

    public int getSpeed() {
        return robot.getSpeed();
    }

    public String getNextHitName() {
        return robot.getTactics().length == 0 ? null : robot.getTactics()[0];
    }

    public String getName() {
        return robot.getName();
    }

    public int getHealth() {
        return robot.getHealth();
    }
}
