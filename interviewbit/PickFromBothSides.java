package interviewbit;

import java.util.List;
import java.util.ArrayList;


public class PickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= B; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += A.get(j);
            }
            for (int j = ((A.size()-1) - (B-i) +1); j<A.size(); j++) {
                sum += A.get(j);
            }
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(-2);
        A.add(3);
        A.add(1);
        A.add(2);

        System.out.println(new PickFromBothSides().solve(A, 3));
    }
}
