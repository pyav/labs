package javaPrograms;

/**
 * Following program is a simple example to show the functionality of Generics. 
 * 
 * 
 * Output
 * ------
 * intOb.data = 10
 * strOb.data = pyav testing
 *
 * 
 * @author pyav
 */

class Gen<T> {
	
	T data;
	
	Gen(T ob) {
		data = ob;
	}
	
	T getData() {
		return data;
	}
}

public class Generics {

	public static void main(String[] args) {
		
		Gen<Integer> intOb = new Gen<Integer>(10);
		System.out.println("intOb.data = " + Integer.toString(intOb.getData()));
		Gen<String> strObj = new Gen<String>("pyav testing");
		System.out.println("strOb.data = " + strObj.getData());
	}

}
