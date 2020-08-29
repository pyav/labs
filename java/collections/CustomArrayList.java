/**
 * Output
 * ------
 * 1 pyav 1 1
 * 2 github 2 2
 * 3 commit 3 3
 * 4 push 4 4 
 */

package collections;

import java.util.ArrayList;

public class CustomArrayList {

	private int size;

	public int getSizeList() {
		return this.size;
	}

	public void setSizeList(int n) {
		this.size = n;
	}

	class Data {
		int roll;
		String name;
		int marks;
		int phone;

		Data(int roll, String name, int marks, int phone) {
			this.roll = roll;
			this.name = name;
			this.marks = marks;
			this.phone = phone;
		}
	}

	public void addData(int roll[], String name[], int marks[], int phone[]) {

		ArrayList<Data> dataArrayList = new ArrayList<Data>();

		for (int i = 0; i < this.getSizeList(); i++) {
			dataArrayList.add(new Data(roll[i], name[i], marks[i], phone[i]));
		}

		printList(dataArrayList);
	}

	public void printList(ArrayList<Data> dataArrayList) {

		for (int i = 0; i < this.getSizeList(); i++) {
			System.out.printf("%d %s %d %d", dataArrayList.get(i).roll, dataArrayList.get(i).name,
					dataArrayList.get(i).marks, dataArrayList.get(i).phone);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int roll[] = { 1, 2, 3, 4 };
		String name[] = { "pyav", "github", "commit", "push" };
		int marks[] = { 1, 2, 3, 4 };
		int phone[] = { 1, 2, 3, 4 };

		CustomArrayList customList = new CustomArrayList();
		customList.setSizeList(roll.length);
		customList.addData(roll, name, marks, phone);
	}

}
