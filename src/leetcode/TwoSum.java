// https://leetcode.com/problems/two-sum/description/
package leetcode;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Initialise hashmap with values & their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Calculate complement & perform hashmap lookup
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {  // Avoid returning true for same element
                return new int[] { map.get(complement), i };
            }
        }
        return null;
    }
    
}
