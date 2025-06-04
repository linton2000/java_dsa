// Codility problem (given in Thales interview)
package otherproblems;

import java.util.HashMap;

public class PalindromeMinDeletions {

    public static int solution(String palindrome) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < palindrome.length(); i++){
            String currentChar = Character.toString(palindrome.charAt(i));
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);  // Increase char freq. by 1
        }

        int oddCount = 0;
        for (String key : map.keySet()){
            if (map.get(key) % 2 != 0) {  // Odd frequency
                oddCount += 1;
            }
        }

        return Math.max(0, oddCount - 1); // If already palindrome - 0 deletions
    }

    public static void testSolution() {
        HashMap<String, Integer> testCases = new HashMap<>();
        testCases.put("ervervige", 2);
        testCases.put("aaabab", 0);
        testCases.put("x", 0);

        int i = 1;
        for (String input : testCases.keySet()){
            int output = PalindromeMinDeletions.solution(input);
            int correctOutput = testCases.get(input);
            if (output == correctOutput) {
                System.out.printf("Test %d passed!\n", i);
            } else {
                System.out.printf("Test %d failed. Input: %s; Output: %d; Correct Output: %d\n",
                i, input, output, correctOutput);            
            }
            i += 1;
        }
    }
}