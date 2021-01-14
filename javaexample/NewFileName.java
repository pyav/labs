/**
 * 
 * 
 * Output:
 * ------
 * java NewFileName
 * /tmp/anandf61af96e-2339-4d52-9b6d-6063f2becb48.pyav
 */

import java.io.File;
import java.util.UUID;

public class NewFileName {

	public static void main(String[] args) {

		File tmpFile = new File("/tmp", "anand" + UUID.randomUUID().toString() + ".pyav");

		System.out.println(tmpFile.getAbsolutePath());

	}

}
