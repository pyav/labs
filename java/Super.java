/**
 * Following program demonstrated constructor overloading. It also shows that
 * the references of a subclass object can be assigned to a super class object.
 * 
 * Output
 * ------
 * 
 * Volume of first box = 0.0, it's weight = 0.0
 * Volume of second box = 6.0, it's weight = 4.0
 * Volume of third box = 6.0, it's weight = 4.0
 * 
 * 
 * @author pyav
 * 
 */

class Box {
    private double length;
    private double width;
    private double depth;

    Box(double l, double w, double d) {
	length = l;
	width = w;
	depth = d;
    }

    Box() {
	length = 0;
	width = 0;
	depth = 0;
    }

    Box(Box obj) {
	length = obj.length;
	width = obj.width;
	depth = obj.depth;
    }

    double volume() {
	return length * width * depth;
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(double l, double w, double d, double wt) {
	super(l, w, d);
	weight = wt;
    }

    BoxWeight() {
	super();
	weight = 0;
    }

    BoxWeight(BoxWeight obj) {
	super(obj);
	weight = obj.weight;
    }
}

public class Super {

    public static void main(String[] args) {
	BoxWeight obj1 = new BoxWeight();
	BoxWeight obj2 = new BoxWeight(1, 2, 3, 4);
	BoxWeight obj3 = new BoxWeight(obj2);

	System.out.println("Volume of first box = " + obj1.volume()
		+ ", it's weight = " + obj1.weight);
	System.out.println("Volume of second box = " + obj2.volume()
		+ ", it's weight = " + obj2.weight);
	System.out.println("Volume of third box = " + obj3.volume()
		+ ", it's weight = " + obj3.weight);
    }

}
