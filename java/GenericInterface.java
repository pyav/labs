/**
 * Following program demonstrates the use of generic interface.
 * 
 * Output
 * ------
 * Min in Integers: -2
 * Max in Integers: 3
 * Min in Characters: a
 * Max in Characters: z
 * 
 * 
 * @author pyav
 */

package javaPrograms;

interface MinMax<T extends Comparable<T>> {
	T getMin();

	T getMax();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {

	T[] values;

	MyClass(T[] o) {
		values = o;
	}

	public T getMin() {

		T min = values[0];

		for (int i = 1; i < values.length; i++) {
			if (values[i].compareTo(min) < 0) {
				min = values[i];
			}
		}

		return min;
	}

	public T getMax() {

		T max = values[0];

		for (int i = 1; i < values.length; i++) {
			if (values[i].compareTo(max) > 0) {
				max = values[i];
			}
		}

		return max;
	}

}

public class GenericInterface {

	public static void main(String[] args) {
		Integer[] valsInt = { 1, 2, 3, -1, -2 };
		Character[] valsChar = { 'a', 'e', 'r', 'z' };

		MyClass<Integer> intObj = new MyClass<Integer>(valsInt);
		MyClass<Character> charObj = new MyClass<Character>(valsChar);

		System.out.println("Min in Integers: " + intObj.getMin());
		System.out.println("Max in Integers: " + intObj.getMax());
		System.out.println("Min in Characters: " + charObj.getMin());
		System.out.println("Max in Characters: " + charObj.getMax());
	}

}
