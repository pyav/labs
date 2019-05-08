/**
 * Following program shows how we can add an object of a subclass type to a list of a super class type.
 * 
 * Output
 * ------
 * In the First class.
 * In the Second class.
 *
 * @author pyav
 */

package javaPrograms;

import java.util.ArrayList;
import java.util.List;

class FirstToPrint {

	void printSomething() {
		System.out.println("In the First class.");
	}
}

class SecondtoPrint extends FirstToPrint {

	@Override
	void printSomething() {
		System.out.println("In the Second class.");
	}
}

public class ListAddSubclass {

	public static void main(String[] args) {

		List<FirstToPrint> objList = new ArrayList<FirstToPrint>();
		objList.add(new FirstToPrint());
		objList.add(new SecondtoPrint());

		for (FirstToPrint obj : objList) {
			obj.printSomething();
		}
	}

}
