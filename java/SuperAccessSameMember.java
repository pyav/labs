/**
 * This program shows how to access a member in super class from a sub class
 * having a member with the same name.
 * 
 * Output
 * ------
 * 
 * i in super class = 1
 * i in sub class = 2
 * 
 * 
 * @author pyav
 * 
 */

class First {
	int i;
}

class Second extends First {
	int i;

	void setData(int a, int b) {
		super.i = a;
		i = b;
	}

	void printData() {
		System.out.printf("i in super class = %d", super.i);
		System.out.printf("\ni in sub class = %d", i);
	}
}

public class SuperAccessSameMember {

	public static void main(String[] args) {
		Second obj = new Second();
		obj.setData(1, 2);
		obj.printData();
	}

}
