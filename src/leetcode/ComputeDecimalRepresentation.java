/**
 * https://leetcode.com/problems/compute-decimal-representation/description/
 * 
 * Output:
 * ------
 * 500 30 7 
 * 100 2 
 * 6 
 * 6000000 1000 1 
 */

import java.util.ArrayList;
import java.util.List;

public class ComputeDecimalRepresentation {

	public int[] decimalRepresentation(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int pow = 0;
        
        while(n>0) {
        	if (n%10 != 0) {
        		result.add(0, (int) ((n%10) * Math.pow(10, pow)));
        	}
        	n = n/10;
        	pow++;
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }

	public static void main(String[] args) {
		int[] result = new ComputeDecimalRepresentation().decimalRepresentation(537);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%d ", result[i]);
		}
		System.out.println();
		int[] result2 = new ComputeDecimalRepresentation().decimalRepresentation(102);
		for (int i = 0; i < result2.length; i++) {
			System.out.printf("%d ", result2[i]);
		}
		System.out.println();
		int[] result3 = new ComputeDecimalRepresentation().decimalRepresentation(6);
		for (int i = 0; i < result3.length; i++) {
			System.out.printf("%d ", result3[i]);
		}
		System.out.println();
		int[] result4 = new ComputeDecimalRepresentation().decimalRepresentation(6001001);
		for (int i = 0; i < result4.length; i++) {
			System.out.printf("%d ", result4[i]);
		}
		System.out.println();
	}

}
