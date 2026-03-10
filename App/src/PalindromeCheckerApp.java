UC12-StrategyPattern
import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

=======
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {

 UC13-PerformanceComparison
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
=======
        // Normalize string: remove spaces and convert to lowercase
 main
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

 UC12-StrategyPattern
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
=======
 main
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
 main
                return false;
            }
        }

        return true;
    }

 UC13-PerformanceComparison
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
=======
 UC12-StrategyPattern
// Palindrome Checker Context
class PalindromeChecker {

    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}

=======
 main
public class PalindromeCheckerApp {
 main

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

 UC13-PerformanceComparison
        // Measure Stack algorithm time
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;
=======
 UC12-StrategyPattern
        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.check(input)) {
=======
        // Create object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();
 main

        // Measure Two-pointer algorithm time
        long startTwoPointer = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(input);
        long endTwoPointer = System.nanoTime();
        long pointerTime = endTwoPointer - startTwoPointer;

 UC13-PerformanceComparison
        System.out.println("\nStack Algorithm Result: " + stackResult);
        System.out.println("Stack Execution Time: " + stackTime + " ns");

        System.out.println("\nTwo-Pointer Algorithm Result: " + pointerResult);
        System.out.println("Two-Pointer Execution Time: " + pointerTime + " ns");
=======
        if (result) {
 main
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }
 main

        scanner.close();
    }
}