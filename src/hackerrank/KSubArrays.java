import java.util.*;

public class KSubArrays {

	public static long kSub(int k, List<Integer> nums) {

		int count = 0;
		if ((nums.get(0) % 100) % k == 0) {
			count++;
		}

		for (int i = 1; i < nums.size(); i++) {
			if (((nums.get(i) % 100) % k) == 0) {
				count++;
			}

			int sum = nums.get(i) + nums.get(i - 1);
			nums.remove(i);
			nums.add(i, sum);

			if ((nums.get(i) % 100) % k == 0) {
				count++;
			}
		}

		for (int i = 1; i <= nums.size() - 2; i++) {
			for (int j = i + 1; j <= nums.size() - 1; j++) {
				if (((nums.get(j) - nums.get(i - 1)) % 100) % k == 0) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		/*nums.add(5);
		nums.add(10);
		nums.add(11);
		nums.add(9);
		nums.add(5);*/
        nums.add(4);
        nums.add(5);
        nums.add(0);
        nums.add(-2);
        nums.add(-3);
        nums.add(1);
		System.out.println(KSubArrays.kSub(5, nums));

	}

}
