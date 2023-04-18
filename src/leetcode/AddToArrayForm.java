/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/description/
 *
 * Output:
 * ------
 * 2 5 5 
 * 1 0 0 0
 */

import java.util.List;
import java.util.ArrayList;

public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int kLen = 0;
        int i = 0;
        int carry = 0;
        List<Integer> result = new ArrayList<Integer>();
        
        while (k > 0 && i < num.length) {
        	int val = num[num.length-1-i] + (k%10) + carry;
        	result.add(0, val%10);
        	carry = val/10;
        	k = k/10;
        	i++;
        	kLen++;
        }
        
        if (k == 0) {
        	if (i == num.length) {
        		while (carry > 0) {
        			result.add(0, carry%10);
        			carry /= 10;
        		}
        	} else {
        		while (i < num.length) {
        			System.out.println(carry);
        			System.out.println(num[num.length-1-i]);
        			int val = num[num.length-1-i] + carry;
        			result.add(0, val%10);
        			carry = val/10;
        			i++;
        		}
        		while (carry > 0) {
        			result.add(0, carry%10);
        			carry /= 10;
        		}
        	}
        } else {
        	while (k > 0) {
        		int val = (k%10) + carry;
        		result.add(0, val%10);
        		carry = val/10;
        		k /= 10;
        	}
        	while (carry > 0) {
    			result.add(0, carry%10);
    			carry /= 10;
    		}
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] num = {7,4};
        int k = 181;
        List<Integer> result = new AddToArrayForm().addToArrayForm(num, k);
        result.stream().forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] num2 = {7};
        int k2 = 993;
        List<Integer> result2 = new AddToArrayForm().addToArrayForm(num2, k2);
        result2.stream().forEach(e -> System.out.printf("%d ", e));
    }

}

