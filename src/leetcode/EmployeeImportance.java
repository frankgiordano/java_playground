package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/employee-importance/
690. Employee Importance

You are given a data structure of employee information, which includes the employee's
unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader
of employee 3. They have importance value 15, 10 and 5, respectively. Then employee
1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and
employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of
employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to
return the total importance value of this employee and all his subordinates.

Note:
One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.

author francesco giordano

This is a classic DFS solution.
*/
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class EmployeeImportance {

    private Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int id) {

        // dont need to use 'visited' here as subordinates wont have duplicates...

        emap = new HashMap<Integer, Employee>();
        for (Employee e : employees)
            emap.put(e.id, e);

        int result = emap.get(id).importance;

        Stack<Integer> stack = new Stack<Integer>();
        for (Integer i : emap.get(id).subordinates)
            stack.push(i);

        while (!stack.empty()) {
            id = stack.pop();

            result += emap.get(id).importance;

            for (Integer i : emap.get(id).subordinates) {
                stack.push(i);
            }
        }

        return result;
    }

    public int getImportance2(List<Employee> employees, int id) {
        emap = new HashMap<Integer, Employee>();
        for (Employee e : employees)
            emap.put(e.id, e);
        int result = dfs(id);
        return result;
    }

    public int dfs(int id) {
        int result = emap.get(id).importance;
        for (Integer i : emap.get(id).subordinates)
            result += dfs(i);
        return result;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 10;
        e1.subordinates = Arrays.asList(2, 3, 4);
        employees.add(e1);
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = -1;
        e2.subordinates = Arrays.asList();
        employees.add(e2);
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = -2;
        e3.subordinates = Arrays.asList();
        employees.add(e3);
        Employee e4 = new Employee();
        e4.id = 3;
        e4.importance = -2;
        e4.subordinates = Arrays.asList();
        employees.add(e3);

        EmployeeImportance importance = new EmployeeImportance();
        System.out.println((importance.getImportance(employees, 2)));
        System.out.println((importance.getImportance2(employees, 2)));
    }

}
