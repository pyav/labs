import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * 
 *  Output:
 *  ------
 *  0 0 1 1 2 2 
 */

public class SortColors {
	
	public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		countZero++;
        	} else if (nums[i] == 1) {
        		countOne++;
        	} else {
        		countTwo++;
        	}
        }
        int i = 0;
        for (; i < countZero; i++) {
        	nums[i] = 0;
        }
        for (; i < countZero+countOne; i++) {
        	nums[i] = 1;
        }
        for (; i < nums.length; i++) {
        	nums[i] = 2;
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		new SortColors().sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}
		System.out.println();
	}

}
