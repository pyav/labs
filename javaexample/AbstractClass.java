/**
 * Following program demonstrates the abstrace class concept.
 * 
 * Output
 * ------
 * This is class B
 * This is abstract class A
 *
 * @author pyav
 */

abstract class Abstract {
	abstract void func();
	void func2() {
		System.out.println("This is abstract class A");
	}
}

class Beta extends Abstract {
	void func() {
		System.out.println("This is class B");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		Beta b = new Beta();
		
		b.func();
		b.func2();
	}

}
