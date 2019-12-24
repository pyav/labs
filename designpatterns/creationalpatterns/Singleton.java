/**
 * Following program shows the Singleton pattern with lazy-initialization.
 * 
 * @author pyav 
 */

package designpatterns.creationalpatterns;

public final class Singleton {
	private static volatile Singleton instance = null;

	private Singleton() {}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
}
