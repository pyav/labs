import java.util.Scanner;

public class FibonacciWordReverse {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		in.close();
		
		//System.out.println("name = " + name.split(" ").length);
		
		String[] nameArr = name.split(" ");
		
		for (int i = 0; i < nameArr.length; i++) {
			System.out.println(nameArr[i]);
		}
		//System.out.println(nameArr.length);
		boolean printed = false;
		int i;
		int a = 0;
		int b = 1;
		int c=0;

		for (i = 0; i < nameArr.length; i++) {
			
			if (a == 0) {
				System.out.println(reverseStr(nameArr[i]));
			} else if (b == 1 && !printed) {
				printed = true;
				System.out.println(nameArr[i]);
			} else if (i == a) {
				System.out.println(reverseStr(nameArr[i]));
			} else {
				System.out.printf("%d %d %d %d", a,b,c,i);
				System.out.println(nameArr[i]);
			}

			c = a+b;
			a=b;
			b = c;
			
		}
	}

	private static String reverseStr(String name) {

		String reverse = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			reverse = reverse + name.charAt(i);
		}
		return reverse;
	}

}
