/**
 * Following program shows method overriding via inheritance and run-time polymorphism. 
 * 
 * Output
 * ------
 * Area of rectangle = 12.0
 * Area of triangle = 15.0
 * Base class zero area
 * Area of base figure = 0.0
 * 
 * @author pyav
 */

class BaseFigure {
	double len;
	double wid;
	
	BaseFigure(double a, double b) {
		len = a;
		wid = b;
	}
	
	double area() {
		System.out.println("Base class zero area");
		return 0;
	}
}

class Rectangle extends BaseFigure {
	Rectangle(double a, double b) {
		super(a, b);
	}
	
	double area() {
		return len * wid;
	}
}

class Triangle extends BaseFigure {
	Triangle(double a, double b) {
		super(a, b);
	}
	
	double area() {
		return len * wid / 2;
	}
}

public class CalculateAreas {

	public static void main(String[] args) {
		BaseFigure b = new BaseFigure(1, 2);
		Rectangle r = new Rectangle(3, 4);
		Triangle t = new Triangle(5, 6);
		BaseFigure gen;

		gen = r;
		System.out.println("Area of rectangle = " + gen.area());
		gen = t;
		System.out.println("Area of triangle = " + gen.area());
		gen = b;
		System.out.println("Area of base figure = " + b.area());
	}

}
