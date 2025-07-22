/**
 * Output:
 * ------
 * 4 5 7 9
 * 1 3 9
 * 1 1 24 24
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class RemoveDuplicateLines {

    public int[][] removeDuplicateLines(int[][] inputLines) {
        Set<Map<Integer, Integer>> set = new HashSet<>();

        for (int i = 0; i < inputLines.length; i++) {
            Map<Integer, Integer> countMap = new TreeMap<Integer, Integer>();

            for (int j = 0; j < inputLines[i].length; j++) {
                countMap.put(inputLines[i][j], countMap.getOrDefault(inputLines[i][j], 0)+1);
            }
            set.add(countMap);
        }

        int[][] resultLines = new int[set.size()][];
        int i = 0;
        for (Map<Integer, Integer> map : set) {
            int totalCount = map.values().stream().mapToInt(Integer::intValue).sum();
            resultLines[i] = new int[totalCount];
            int j = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                for (int k = 0; k < entry.getValue(); k++) {
                    resultLines[i][j++] = entry.getKey();
                }
            }
            i++;
        }
        // This changes the order in each line
        return resultLines;
    }

    public static void main(String[] args) {
        int[][] inputLines = {
            {1,24,1,24},
            {24,1,24,1},
            {1,3,9},
            {7,9,4,5}
        };
        int[][] resultLines = new RemoveDuplicateLines().removeDuplicateLines(inputLines);
        Arrays.stream(resultLines).forEach(line -> {
            Arrays.stream(line).forEach(number -> System.out.printf("%d ", number));
            System.out.println();
            });
    }
}

