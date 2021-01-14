import java.util.ArrayList;
import java.util.List;

class A1 extends NewThis {

	int a1 = 1;

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	protected void caller1() throws ClassNotFoundException, CloneNotSupportedException {
		caller();
	}

	@Override
	protected void printData() {
		System.out.println(getA1());
	}

}

class B1 extends NewThis {

	int a1 = 2;

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	protected void caller1() throws ClassNotFoundException, CloneNotSupportedException {
		caller();
	}

	@Override
	protected void printData() {
		System.out.println(getA1());
	}

}

public abstract class NewThis {

	int a1 = 0;

	protected abstract void printData();

	private void printAll(List<NewThis> listObj) {

		for (NewThis obj : listObj) {
			obj.printData();
		}
	}

	protected void caller() throws ClassNotFoundException, CloneNotSupportedException {

		System.out.println("In " + this.getClass().getName());
		// System.out.println(Class.forName(this.getClass().getName()).getName());
		// NewThis a = new NewThis();
		// System.out.println(this.clone().getClass().getName());
		// System.out.println(a.a1);
		// NewThis a = this.clone();

		// Object newObj = Class.forName(this.getClass().getName()).cast(this);

		// new this.getClass().getName();
		// newThis = (NewThis) Class.forName(this.getClass().getName()).cast(this);

		NewThis obj;
		List<NewThis> listObj = new ArrayList<>();
		if (this instanceof A1) {
			obj = new A1();
		} else {
			obj = new B1();
		}
		listObj.add(obj);
		printAll(listObj);
	}

	public static void main(String[] args) throws ClassNotFoundException, CloneNotSupportedException {

		A1 a = new A1();
		B1 b = new B1();

		a.caller1();
		System.out.println();
		b.caller1();

	}

}
