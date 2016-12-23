package com.bartek;

import java.util.Map;
import java.util.HashMap;

import com.bartek.model.Robot;
import org.junit.Test;
import static org.junit.Assert.*;

public class EightiesKids6Test {

    @Test
    public void testFight1() {
        Robot robot1 = new Robot("Rocky", 100, 20, new String[] { "punch", "punch", "laser", "missile" });
        Robot robot2 = new Robot("Missile Bob", 100, 21, new String[] { "missile", "missile", "missile", "missile" });
        Map<String, Integer> tactics = new HashMap<>(3, 1f);
        tactics.put("punch", 20);
        tactics.put("laser", 30);
        tactics.put("missile", 35);
        assertEquals("Missile Bob has won the fight.", EightiesKids6.fight(robot1, robot2, tactics));
    }

    @Test
    public void testFight2() {
        Robot robot1 = new Robot("Rocky", 200, 20, new String[] { "punch", "punch", "laser", "missile" });
        Robot robot2 = new Robot("Missile Bob", 100, 21, new String[] { "missile", "missile", "missile", "missile" });
        Map<String, Integer> tactics = new HashMap<>(3, 1f);
        tactics.put("punch", 20);
        tactics.put("laser", 30);
        tactics.put("missile", 35);
        assertEquals("Rocky has won the fight.", EightiesKids6.fight(robot1, robot2, tactics));
    }

    @Test
    public void shouldDraw() {
        Robot robot1 = new Robot("Rocky", 200, 20, new String[] { "punch" });
        Robot robot2 = new Robot("Missile Bob", 200, 21, new String[] { "punch"});
        Map<String, Integer> tactics = new HashMap<>(3, 1f);
        tactics.put("punch", 20);
        tactics.put("laser", 30);
        tactics.put("missile", 35);
        assertEquals("The fight was a draw.", EightiesKids6.fight(robot1, robot2, tactics));
    }

    @Test
    public void testRandomFromCodewars(){
//        Fighters:
//        { Robot name: C-3PO, speed: 76, hp: 187, tactics: [grenade, laser, grenade, missile, bomb, punch, bomb] }
//        { Robot name: Missile Bob, speed: 5, hp: 476, tactics: [space ray, punch, bomb, space ray, bomb, laser] },
//        tactics: {missile=18, grenade=28, laser=10, bomb=16, space ray=20, punch=25}
//


        Robot robot1 = new Robot("C-3PO", 187, 76, new String[] { "grenade", "laser", "grenade", "missile", "bomb", "punch", "bomb" });
        Robot robot2 = new Robot("Missile Bob", 476, 5, new String[] { "space ray", "punch", "bomb", "space ray", "bomb", "laser"});
        Map<String, Integer> tactics = new HashMap<>(6, 1f);
        tactics.put("missile", 18);
        tactics.put("grenade", 28);
        tactics.put("laser", 10);
        tactics.put("bomb", 16);
        tactics.put("space ray", 20);
        tactics.put("punch", 25);

        assertEquals("Missile Bob has won the fight.", EightiesKids6.fight(robot1, robot2, tactics));

        //        Fighters:
//        { Robot name: C-3PO, speed: 26, hp: 856, tactics: [] }
//        { Robot name: Rocky, speed: 16, hp: 833, tactics: [punch, laser] },
//        tactics: {missile=18, grenade=16, laser=17, bomb=21, space ray=30, punch=17}
//✘ expected:&lt;[Rocky] has won the fight.&gt; but was:&lt;[C-3PO] has won the fight.&gt;

        Robot robot3 = new Robot("C-3PO", 856, 26, new String[] { });
        Robot robot4 = new Robot("Rocky", 833, 16, new String[] {  "punch", "laser"});
        tactics = new HashMap<>(6, 1f);
        tactics.put("missile", 18);
        tactics.put("grenade", 16);
        tactics.put("laser", 17);
        tactics.put("bomb", 21);
        tactics.put("space ray", 30);
        tactics.put("punch", 17);

        assertEquals("Rocky has won the fight.", EightiesKids6.fight(robot3, robot4, tactics));
    }
}
