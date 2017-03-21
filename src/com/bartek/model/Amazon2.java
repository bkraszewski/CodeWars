package com.bartek.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by bartek on 25/12/16.
 */
public class Amazon2 {

    static class Org_Employee {
        final private int id;
        final private String name;
        final private ArrayList<Org_Employee> reports = new ArrayList();

        public Org_Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public ArrayList<Org_Employee> getReports() {
            return reports;
        }
    }

    static class Solution {
        public static List<Org_Employee> getEmployeeManagers(Org_Employee ceo, Org_Employee employee) {
            List<Org_Employee> managers = new LinkedList<>();

            Queue<Org_Employee> queue = new LinkedList<>();
            queue.add(ceo);

            System.out.println(ceo.name);

            while (!queue.isEmpty()) {
                Org_Employee currentLevel = queue.remove();
                managers.add(currentLevel);

                for (Org_Employee reports : currentLevel.reports) {
                    if (reports.getId() == employee.getId()) {
                        return managers;
                    }

                    queue.add(reports);
                    System.out.println(reports.name);
                }
            }

            return managers;
        }

        public static Org_Employee closestCommonManager(Org_Employee ceo, Org_Employee employee1, Org_Employee employee2)
        {
            if(ceo == null ){
                throw new IllegalArgumentException("Ceo cannot be null");
            }

            if(ceo.getReports().isEmpty() ){
                throw new IllegalArgumentException("Ceo must have employees!");
            }

            if(employee1 == null){
                throw new IllegalArgumentException("First employee cannot be null!");
            }

            if(employee2 == null){
                throw new IllegalArgumentException("Second employee cannot be null");
            }


            List<Org_Employee> managersForFirstEmployee = getEmployeeManagers(ceo, employee1);
            List<Org_Employee> managersForSecondEmployee = getEmployeeManagers(ceo, employee2);

            //go from end
            for(int a = managersForFirstEmployee.size() - 1; a >= 0; a--){
                Org_Employee firstManager = managersForFirstEmployee.get(a);

                for(int b = managersForSecondEmployee.size() - 1; b >= 0 ; b--){
                    Org_Employee secondManager = managersForSecondEmployee.get(b);

                    if(secondManager.getId() == firstManager.getId()){
                        return secondManager;
                    }
                }
            }

            //common manager not found
            // throw new IllegalArgumentException("CEO reporting structure must be wrong, common manager not found!");
            return null;
        }
    }


    static class Tests {

        @Test
        public void shouldReturnListOfManagers() {
            Org_Employee ceo = new Org_Employee(1, "Jeff");

            Org_Employee firstLevel1 = new Org_Employee(2, "First Level, Employe 1");
            Org_Employee firstLevel2 = new Org_Employee(3, "First Level, Employe 2");

            ceo.reports.add(firstLevel1);
            ceo.reports.add(firstLevel2);

            Org_Employee secondLevel1 = new Org_Employee(4, "Second Level, Employe 1");
            Org_Employee secondevel2 = new Org_Employee(5, "Second Level, Employe 2");

            firstLevel1.reports.add(secondLevel1);
            firstLevel1.reports.add(secondevel2);

            List<Org_Employee> managers = Solution.getEmployeeManagers(ceo, secondLevel1);

            assertEquals(2, managers.size());
            assertEquals(true, managers.contains(ceo));
            assertEquals(true, managers.contains(firstLevel1));

        }

        @Test
        public void shouldFindCommonManager(){
            Org_Employee ceo = new Org_Employee(1, "Jeff");

            Org_Employee firstLevel1 = new Org_Employee(2, "First Level, Employe 1");
            Org_Employee firstLevel2 = new Org_Employee(3, "First Level, Employe 2");

            ceo.reports.add(firstLevel1);
            ceo.reports.add(firstLevel2);

            Org_Employee secondLevel1 = new Org_Employee(4, "Second Level, Employe 1");
            Org_Employee secondevel2 = new Org_Employee(5, "Second Level, Employe 2");

            firstLevel1.reports.add(secondLevel1);
            firstLevel1.reports.add(secondevel2);

            Org_Employee ret = Solution.closestCommonManager(ceo, secondevel2, secondevel2);
            assertEquals(2, ret.getId());

        }
    }
}
