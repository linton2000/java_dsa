import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {3,2,4};
        int target = 6;

        int[] answer = TwoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(answer));
    }
}