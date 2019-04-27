/**
 * This program demonstrates the functionality of bounded wildcard.
 *
 * Output
 * ------
 * Showing two dimensions:
 * 1, 2
 * 3, 4
 * Showing three dimensions:
 * -1, -2, -3
 * -4, -5, -6
 * -7, -8, -9
 * Showing four dimensions:
 * 11, 12, 13, 14
 * 15, 16, 17, 18
 * 9, 10, 11, 12
 * 13, 14, 15, 16
 * Showing three dimensions:
 * 11, 12, 13
 * 15, 16, 17
 * 9, 10, 11
 * 13, 14, 15
 * Showing till three dimensions:
 * 1, 2
 * 3, 4
 * 
 * 
 * @author pyav
 */

package javaPrograms;

import javaPrograms.Dimensions.TwoD;
import javaPrograms.Dimensions.ThreeD;
import javaPrograms.Dimensions.FourD;

class CoOrdinates<T extends TwoD> {
	
	T[] coOrdinates;
	
	CoOrdinates(T[] objArr) {
		coOrdinates = objArr;
	}
}

public class BoundedWildcardDemo {

	public static void main(String[] args) {
		
		TwoD[] twoDArr = {
							new Dimensions().new TwoD(1, 2),
							new Dimensions().new TwoD(3, 4)
						 };
		ThreeD[] threeDArr = {
								new Dimensions().new ThreeD(-1, -2, -3),
								new Dimensions().new ThreeD(-4, -5, -6),
								new Dimensions().new ThreeD(-7, -8, -9)
							 };
		FourD[] fourDArr = {
							new Dimensions().new FourD(11, 12, 13, 14),
							new Dimensions().new FourD(15, 16, 17, 18),
							new Dimensions().new FourD(9, 10, 11, 12),
							new Dimensions().new FourD(13, 14, 15, 16)
						   };
		
		CoOrdinates<TwoD> twoD = new CoOrdinates<TwoD>(twoDArr);
		CoOrdinates<ThreeD> threeD = new CoOrdinates<ThreeD>(threeDArr);
		CoOrdinates<FourD> fourD = new CoOrdinates<FourD>(fourDArr);
		
		Dimensions.showTwoDimensions(twoD);
		Dimensions.showThreeDimensions(threeD);
		Dimensions.showFourDimensions(fourD);
		Dimensions.showThreeDimensions(fourD);
		// Below method call with the object of TwoD is not allowed.
		// Dimensions.showThreeDimensions(twoD);
		Dimensions.showTillThreeDimesions(twoD);
	}

}
