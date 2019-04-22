package javaPrograms;

/**
 * Demonstration of 'static' block. 
 * 
 * 
 * Output
 * ------
 * 
 * x = 10
 * y = 20
 * z = 30
 * 
 * 
 * @author pyav
 *
 */

public class StaticBlockDemo {
	
	static int y = 20;
	static int z;
	
	// Static method accessing static variables
	static void stats(int x) {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
	}
	
	// The Static block
	static {
		z = 30;
	}
	
	public static void main(String[] args) {
		stats(10);
	}

}
