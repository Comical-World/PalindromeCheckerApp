import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Two-pointer palindrome check
    public static boolean twoPointerPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Measure Stack algorithm time
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // Measure Two-pointer algorithm time
        long startTwoPointer = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(input);
        long endTwoPointer = System.nanoTime();
        long pointerTime = endTwoPointer - startTwoPointer;

        System.out.println("\nStack Algorithm Result: " + stackResult);
        System.out.println("Stack Execution Time: " + stackTime + " ns");

        System.out.println("\nTwo-Pointer Algorithm Result: " + pointerResult);
        System.out.println("Two-Pointer Execution Time: " + pointerTime + " ns");

        scanner.close();
    }
}