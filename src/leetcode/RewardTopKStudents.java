/**
 * https://leetcode.com/problems/reward-top-k-students/description/
 *
 * Output:
 * ------
 * [1, 2]
 * [2, 1]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class RewardTopKStudents {
    private int matchWords(Set<String> feedbackSet, String report) {
        String[] words = report.split(" ");
        int score = 0;
        for (String word : words) {
            if (feedbackSet.contains(word)) {
                score++;
            }
        }
        return score;
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>(Collections.reverseOrder());

        Set<String> positiveSet = new HashSet<>();
        for (int i = 0; i < positive_feedback.length; i++) {
            positiveSet.add(positive_feedback[i]);
        }

        Set<String> negativeSet = new HashSet<>();
        for (int i = 0; i < negative_feedback.length; i++) {
            negativeSet.add(negative_feedback[i]);
        }

        int score = 0;
        for  (int i = 0; i < student_id.length; i++) {
            score = 3 * matchWords(positiveSet, report[i]) - matchWords(negativeSet, report[i]);
            map.computeIfAbsent(score, s -> new PriorityQueue<>()).add(student_id[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (PriorityQueue<Integer> pq : map.values()) {
            if (k <= 0) {
                break;
            }
            while (!pq.isEmpty() && k > 0) {
                result.add(pq.poll());
                k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new RewardTopKStudents().topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is studious","the student is smart"},
                new int[]{1,2},
                2);
        System.out.println(result);
        List<Integer> result2 = new RewardTopKStudents().topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1,2},
                2);
        System.out.println(result2);
    }
}