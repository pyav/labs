/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * 
 * Output:
 * ------
 * 3
 * 8
 * 9
 */

package leetcode;

public class PartitionNumber {

	public int minPartitions(String n) {
		int max = 0;
		int len = n.length();
		for (int i = 0; i < len; i++) {
			if (n.charAt(i) > max) {
				max = n.charAt(i);
			}
		}

		return max - 48;
	}

	public static void main(String[] args) {
		System.out.println(new PartitionNumber().minPartitions("32"));
		System.out.println(new PartitionNumber().minPartitions("82734"));
		System.out.println(new PartitionNumber().minPartitions("27346209830709182346"));
	}

}

