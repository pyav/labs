
public class ThrowSequence {

	public static void main(String[] args) {

		System.out.println(throwSequence());

	}

	private static int throwSequence() {
		try {
			System.out.println("pyav try...");
			throw new InterruptedException("pyav Interrupted Exception...");
		} catch (InterruptedException iex) {
			System.out.println("pyav iex..." + iex);
			return 1;
		} finally {
			System.out.println("pyav finally...");
			return -1;
		}
	}

}
