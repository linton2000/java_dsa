import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {1, 3, 6, 4, 1, 2};

        int answer = SmallestInteger.solution(nums);
        System.out.println(Integer.toString(answer));

        int[] nums2 = {-10, -1, -4, -6, 1};
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
