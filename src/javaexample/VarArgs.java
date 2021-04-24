/**
 * Following program shows the use of variable arguments and the way to pass
 * them between different methods.
 * 
 * Output
 * ------
 * First total = 6
 * Second total = 15
 * 
 * 
 * @author pyav
 *
 */

public class VarArgs {

	static int sum(int... nums) {
		int total = 0;

		for (int i = 0; i < nums.length; i++) {
			total = total + nums[i];
		}

		return total;
	}

	static int func(int... nums) {
		return VarArgs.sum(nums.clone());
	}

	public static void main(String[] args) {
		int a = func(1, 2, 3);
		int b = func(5, 10);

		System.out.println("First total = " + a);
		System.out.println("Second total = " + b);
	}

}
