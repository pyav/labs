import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/
 *
 * Output:
 * ------
 * 3
 * 0
 */

public class EmployeesMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(e -> e >= target).count();
    }

    public static void main(String[] args) {
        int[] hours = {0, 1, 2, 3, 4};
        System.out.println(new EmployeesMetTarget().numberOfEmployeesWhoMetTarget(hours, 2));
        int[] hours2 = {5, 1, 4, 2, 2};
        System.out.println(new EmployeesMetTarget().numberOfEmployeesWhoMetTarget(hours2, 6));

    }
}

