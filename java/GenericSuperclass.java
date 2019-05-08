/**
 * Following program demonstrates generic superclass.
 * 
 * Output
 * ------
 * 100
 * Hundred
 *
 * @author pyav
 */

package javaPrograms;

class Gen1<T> {
	
	T ob;
	
	Gen1(T o) {
		ob = o;
	}
	
	T getData() {
		return this.ob;
	}
}

class Gen2<T, V> extends Gen1<T> {

	V s;
	
	Gen2(T o, V t) {
		super(o);
		s = t;
	}
	
	V getData2() {
		return this.s;
	}
}


public class GenericSuperclass {

	public static void main(String[] args) {
		
		Gen2<Integer, String> x = new Gen2<Integer, String>(100, "Hundred");
		System.out.println(x.getData());
		System.out.println(x.getData2());
	}

}
