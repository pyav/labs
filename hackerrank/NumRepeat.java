import java.util.Scanner;

public class NumRepeat {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String num = in.next();
		int iter = in.nextInt();
		String newNum = num;

		for (int i = 0; i < iter - 1; i++) {

			int count = 1;
			String num2 = newNum;
			newNum = "";

			for (int j = 0; j < num2.length() - 1; j++) {
				if (num2.charAt(j) == num2.charAt(j + 1)) {
					count += 1;
					continue;
				}

				newNum = newNum + num2.charAt(j) + String.valueOf(count);
				count = 1;
			}

			newNum = newNum + num2.charAt(num2.length() - 1) + String.valueOf(count);
		}

		System.out.println(newNum);
		in.close();
	}
}
