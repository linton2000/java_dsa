public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        while (x > 0){
            x /= 10;
        }
        return true;
    }
}
