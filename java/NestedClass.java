/**
 * Following program demonstrates nested class support.
 * 
 *  Output
 *  ------
 *  
 *  Value = 10
 *
 *  
 *  @author pyav
 *  
 */

class Outer {

	private int val = 10;
	
	void test() {
		Inner inner = new Inner();
		inner.prnt();
	}
	
	class Inner {	// Nested class can also be written inside a block 
		void prnt() {
			System.out.println("Value = " + val);
		}
	}
}

public class NestedClass {

	public static void main(String[] args) {
		Outer obj = new Outer();
		obj.test();
	}

}
