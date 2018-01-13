/**
 * Following program demonstrates simple inheritance.
 * 
 * Output
 * ------
 * 
 * In B:
 * i = 3, j = 4 and k = 5
 * 
 * In A:
 * i = 1 and j = 2
 * 
 * 
 * 
 * @author pyav
 *
 */

class A {
    int i;
    int j;
    
    void printA() {
	System.out.println("\nIn A:");
	System.out.println("i = " + i + " and j = " + j);
    }
}

class B extends A {
    int k;
    
    void printB() {
	System.out.println("\nIn B:");
	System.out.println("i = " + i + ", j = " + j + " and k = " + k);
    }
}

public class SimpleInheritance {

    public static void main(String[] args) {
	A objA = new A();
	B objB = new B();
	
	objA.i = 1;
	objA.j = 2;
	objB.i = 3;
	objB.j = 4;
	objB.k = 5;
	
	objB.printB();
	objA.printA();
    }

}
