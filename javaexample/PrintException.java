
public class PrintException {

	public static void main(String[] args) {

		try {
			throw new NullPointerException();
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
	}

}
