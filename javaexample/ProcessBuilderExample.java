/**
 * Output:
 * ------
 * cat /tmp/outputLogFile11.txt 
 *      62
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ProcessBuilderExample {

	public static void main(String[] args) {

		// ProcessBuilder pb = new ProcessBuilder("java", "-version");
		// ProcessBuilder pb = new ProcessBuilder("ls", "-l", "-t");
		// ProcessBuilder pb = new ProcessBuilder(Arrays.asList("ls", "-l", "-t"));
		// ProcessBuilder pb = new ProcessBuilder(Arrays.asList(new String[] { "ls", "-l", "-t" }));
		// String cmd = "ls -lt | wc -l";
		// ProcessBuilder pb = new ProcessBuilder(Arrays.asList(new String[] { "/bin/sh", "-c", cmd }));
		ProcessBuilder pb = new ProcessBuilder(Arrays.asList(new String[] { "/bin/sh", "-c", "ls -lt | wc -l" }));
		// ProcessBuilder pb = new ProcessBuilder(Arrays.asList(new String[] { "/bin/sh", "-c", "ls -lt", "|", "wc -l" }));
		// ProcessBuilder pb = new ProcessBuilder(Arrays.asList(new String[] { "ls", "-lt", "|", "wc -l" }));
		// pb.inheritIO();
		pb.redirectErrorStream(true);
		File outputLogFile = new File("/tmp/outputLogFile12.txt");
		pb.redirectOutput(outputLogFile);

		Process process;
		try {
			process = pb.start();
			int status = process.waitFor();
			if (status != 0) {
				System.out.println("process return not zero!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
