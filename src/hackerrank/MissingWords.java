import java.util.*;

public class MissingWords {

	public static List<String> missingWords(String s, String t) {

		List<String> missing = new ArrayList<String>();
		List<String> sList = Arrays.asList(s.split(" "));
		String[] tArr = t.split(" ");

		int idxPreFound = -1;

		for (int i = 0; i < tArr.length && idxPreFound < sList.size(); i++) {
			System.out.println(tArr[i]);
			System.out.println(sList.subList(idxPreFound + 1, sList.size()));
			
			
			
			int idxNextFound = sList.subList(idxPreFound + 1, sList.size()).indexOf(tArr[i]);
			System.out.printf("idxPreFound=%d, idxNextFound=%d",idxPreFound,idxNextFound);
			System.out.println();
			if (idxNextFound != (idxPreFound + 1)) {
				missing.addAll(sList.subList(idxPreFound + 1, idxNextFound));
				System.out.println(missing.toString());
			}
			idxPreFound = idxNextFound;
		}

		if (idxPreFound < sList.size() - 1) {
			missing.addAll(sList.subList(idxPreFound + 1, sList.size()));
		}

		return missing;
	}

	public static void main(String[] args) {
		String s = "Python is an easy to learn powerful programming language It has efficient high-level data structures and a simple but effective approach to objectoriented programming Python elegant syntax and dynamic typing";
		String t = "programming Python elegant syntax and dynamic typing";
		System.out.println(TwilioMissingWords.missingWords(s, t));
	}

}
