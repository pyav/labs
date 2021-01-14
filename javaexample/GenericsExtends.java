/**
 * Following program demonstrated the bounded types concept in Generics.
 * 
 * Output
 * ------
 * Average of numbers in int array = 3.0
 * Average of number in double array = 3.3
 *
 *
 * @author pyav
 */

class GenArr<T extends Number> {
	
	T[] numbers;
	
	GenArr(T[] obj) {
		numbers = obj;
	}
	
	double getAverage() {
		double sum = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i].doubleValue();
		}
		
		return sum/ numbers.length;
	}
}

public class GenericsExtends {

	public static void main(String[] args) {
		
		Integer[] intArr = {1, 2, 3, 4, 5};
		GenArr<Integer> intGenObj = new GenArr<Integer>(intArr);
		System.out.println("Average of numbers in int array = " + intGenObj.getAverage());
		
		Double[] doubArr = {1.1, 2.2, 3.3, 4.4, 5.5};
		GenArr<Double> doubGenObj = new GenArr<Double>(doubArr);
		System.out.println("Average of number in double array = " + doubGenObj.getAverage());
	}

}
