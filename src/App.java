import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] answer = TwoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(answer));
    }
}