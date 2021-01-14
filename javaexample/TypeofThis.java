
public class TypeofThis {

	public static void main(String[] args) {
		TypeofThis tot = new TypeofThis();
		tot.print();
	}

	private void print() {
		if (this instanceof TypeofThis) {
			System.out.println("this instanceof TypeofThis");
		} else {
			System.out.println("else section");
		}
		
		System.out.println(this.getClass().getSimpleName());
		
	}

}
