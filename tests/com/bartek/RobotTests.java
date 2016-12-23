package com.bartek;

import com.bartek.model.Robot;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bartek on 23/12/16.
 */
public class RobotTests {

    @Test
    public void shouldTestIfRobotIsAlive() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));

        Assert.assertTrue(robot1.isAlive());

        FightingRobot robot2 = new FightingRobot(new Robot("Rocky", 0, 20, new String[]{"punch", "punch", "laser", "missile"}));
        Assert.assertFalse(robot2.isAlive());
    }

    @Test
    public void shouldTestIfRobotCanHit() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));
        Assert.assertTrue(robot1.canHit());

        FightingRobot robot2 = new FightingRobot(new Robot("Rocky", 0, 20, new String[]{}));
        Assert.assertFalse(robot2.canHit());
    }

    @Test
    public void shouldReturnNextHitName() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));
        Assert.assertEquals("punch", robot1.getNextHitName());

        FightingRobot robot2 = new FightingRobot(new Robot("Rocky", 0, 20, new String[]{}));
        Assert.assertEquals(null, robot2.getNextHitName());
    }

    @Test
    public void shouldTestIfRobotUsesHisTackticsWhenPerformingHit() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));

        Assert.assertTrue(robot1.canHit());
        Assert.assertEquals("punch", robot1.getNextHitName());

        robot1 = robot1.performHit();
        Assert.assertTrue(robot1.canHit());
        Assert.assertEquals("punch", robot1.getNextHitName());

        robot1 = robot1.performHit();
        Assert.assertTrue(robot1.canHit());
        Assert.assertEquals("laser", robot1.getNextHitName());

        robot1 = robot1.performHit();
        Assert.assertTrue(robot1.canHit());
        Assert.assertEquals("missile", robot1.getNextHitName());

        robot1 = robot1.performHit();
        Assert.assertFalse(robot1.canHit());
        Assert.assertNull(robot1.getNextHitName());

    }

    @Test
    public void shouldDecreaseHpWHenReceiveHit() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));

        robot1 = robot1.receiveHit(20);

        Assert.assertTrue(robot1.isAlive());
        Assert.assertEquals(80, robot1.getHealth());

        robot1 = robot1.receiveHit(30);

        Assert.assertTrue(robot1.isAlive());
        Assert.assertEquals(50, robot1.getHealth());
    }

    @Test
    public void shouldDieWhenLessThanZeroHpLeft() {
        FightingRobot robot1 = new FightingRobot(new Robot("Rocky", 100, 20, new String[]{"punch", "punch", "laser", "missile"}));

        robot1 = robot1.receiveHit(120);
        Assert.assertFalse(robot1.isAlive());
    }
}
