/**
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 *
 * Output:
 * ------
 * 1
 * 3
 * 0
 */

public class FindValue {

    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++")) {
                val++;
            } else if (operations[i].equals("--X") || operations[i].equals("X--")) {
                val--;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};
        System.out.println(new FindValue().finalValueAfterOperations(operations));
        String[] operations2 = {"++X","X++","X++"};
        System.out.println(new FindValue().finalValueAfterOperations(operations2));
        String[] operations3 = {"++X","X++","--X","X--"};
        System.out.println(new FindValue().finalValueAfterOperations(operations3));
    }

}

