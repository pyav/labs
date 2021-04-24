/**
 * Following program shows how we can add an object of a subclass type to a list of a super class type.
 * 
 * Output
 * ------
 * In FirstToPrint
 * In SecondToPrint
 *
 * @author pyav
 */

import java.util.ArrayList;
import java.util.List;

class FirstToPrint {

	void printClass() {
		System.out.println("In " + this.getClass().getSimpleName());
	}
}

class SecondToPrint extends FirstToPrint {

	@Override
	void printClass() {
		System.out.println("In " + this.getClass().getSimpleName());
	}
}

public class ListAddSubclass {

	public static void main(String[] args) {

		List<FirstToPrint> objList = new ArrayList<FirstToPrint>();
		objList.add(new FirstToPrint());
		objList.add(new SecondToPrint());

		for (FirstToPrint obj : objList) {
			obj.printClass();
		}
	}

}
