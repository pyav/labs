/**
 * This file provides the classes for the required dimensions and methods to print their data.
 * Please check the file BoundedWildcardDemo.java for the usage of the classes and methods defined below.
 * 
 *  @author pyav
 */

package javaPrograms;

public class Dimensions {

	class TwoD {
		int x;
		int y;

		TwoD(int a, int b) {
			x = a;
			y = b;
		}
	}

	class ThreeD extends TwoD {
		int z;

		ThreeD(int a, int b, int c) {
			super(a, b);
			z = c;
		}
	}

	class FourD extends ThreeD {
		int t;

		FourD(int a, int b, int c, int d) {
			super(a, b, c);
			t = d;
		}
	}

	static void showTwoDimensions(CoOrdinates<?> obj) {

		System.out.println("Showing two dimensions:");

		for (int i = 0; i < obj.coOrdinates.length; i++) {
			System.out.println(obj.coOrdinates[i].x + ", " + obj.coOrdinates[i].y);
		}
	}

	static void showThreeDimensions(CoOrdinates<? extends ThreeD> obj) {

		System.out.println("Showing three dimensions:");

		for (int i = 0; i < obj.coOrdinates.length; i++) {
			System.out.println(obj.coOrdinates[i].x + ", " + obj.coOrdinates[i].y + ", " + obj.coOrdinates[i].z);
		}
	}

	static void showFourDimensions(CoOrdinates<? extends FourD> obj) {

		System.out.println("Showing four dimensions:");

		for (int i = 0; i < obj.coOrdinates.length; i++) {
			System.out.println(obj.coOrdinates[i].x + ", " + obj.coOrdinates[i].y + ", " + obj.coOrdinates[i].z + ", "
					+ obj.coOrdinates[i].t);
		}
	}
	
	static void showTillThreeDimesions(CoOrdinates<? super FourD> obj) {
		
		System.out.println("Showing till three dimensions:");
		
		for (int i = 0; i < obj.coOrdinates.length; i++) {
			System.out.println(obj.coOrdinates[i].x + ", " + obj.coOrdinates[i].y);
		}
	}

}
