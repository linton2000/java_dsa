import java.util.Arrays;

public class SmallestInteger {
    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        for(int i = 0; i < A.length - 1; i++){
            if (A[i+1] != A[i] + 1 && A[i+1] != A[i]){
                return A[i] + 1;
            }
        }
        return A[A.length - 1] + 1;
    }
}
