/**
 * Following code shows a sample example of AbstractCollection.
 * 
 * Output
 * ------
 * [First, Second, Third]
 * [First, Second, Third]
 * absCol = [].
 */

package collections;

import java.util.AbstractCollection;
import java.util.TreeSet;

public class AbstractCollectionExample {

	public static void main(String[] args) {

		AbstractCollection<String> absCol = new TreeSet<String>();
		absCol.add("First");
		absCol.add("Third");
		absCol.add("Second");
		absCol.add("First");
		
		System.out.println(absCol);
		
		AbstractCollection<String> absCol2 = new TreeSet<String>();
		absCol2.addAll(absCol);
		System.out.println(absCol2);
		
		absCol.clear();
		System.out.println("absCol = "+absCol.toString()+".");
	}

}
