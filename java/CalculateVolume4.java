/**
 * This program demonstrates parameterized constructor and the use of 'this' 
 * keyword. It returns the volume of a box. 
 * 
 * Output
 * ------
 * 
 * The volume is: 6000.0
 *
 *
 * @author pyav
 *
 */


class Box4 {
	double length;
	double breadth;
	double height;
	
	Box4(double length, double breadth, double height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	double getVolume() { 
		return this.length * this.breadth * this.height;
	}
}

public class CalculateVolume4 {

	public static void main(String[] args) {
		
		Box4 box4 = new Box4(10, 20, 30);
		
		System.out.println("The volume is: " + box4.getVolume());

	}

}
