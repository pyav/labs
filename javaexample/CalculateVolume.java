/**
 * Following program calculates the volume.
 * 
 * Output
 * ------
 * 
 * Volume = 6000.0
 * 
 * 
 * @author pyav
 *
 */

class Box {
	double width;
	double length;
	double depth;
}

public class CalculateVolume {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box mybox = new Box();
		double vol; 
		
		mybox.width = 10;
		mybox.depth = 20;
		mybox.length = 30;
		
		vol = mybox.width * mybox.depth * mybox.length;
		
		System.out.println("Volume = " + vol);

	}

}
