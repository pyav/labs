/**
 * Output:
 * ------
 * SUCCESS
 * FAILURE
 * WARNING
 * WARNING
 */

package javaexample;

public class EnumTest {

	public enum RetVal {
		SUCCESS, FAILURE, WARNING
	};

	public static void main(String[] args) {

		System.out.println(RetVal.SUCCESS);
		System.out.println(RetVal.FAILURE);
		System.out.println(RetVal.WARNING);

		System.out.println(RetVal.WARNING.toString());

	}

}
