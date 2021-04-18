package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class T5 {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String filename;
		filename = scan.nextLine();

		File file = new File(filename);
		File fileNew = new File("figs_" + filename);

		if (fileNew.createNewFile()) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] arr = line.split(" ");
				String filePath = "";
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].contains(".GIF") || arr[i].contains(".gif")) {
						filePath = arr[i];
						break;
					}
				}
				String[] splits = filePath.split("/");
				String fileName = splits[splits.length - 1];
				map.put(fileName, 1);
			}

			scanner.close();
			FileWriter writer = new FileWriter(fileNew);
			for (Entry<String, Integer> entry : map.entrySet()) {
				writer.write(entry.getKey());
				writer.write("\r\n");
			}
			writer.close();

			FileReader reader = new FileReader(fileNew);
			BufferedReader bfReader = new BufferedReader(reader);
			String line;
			while ((line = bfReader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		}

	}

}
