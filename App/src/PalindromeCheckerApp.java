import java.util.Scanner;
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Text: ");

        // Hardcoded string (String Literal)
        String word = "madam";

        // Variable to store reversed string
        String reversed = "";

        // Reverse the string
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if palindrome using if-else
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
        sc.close();
    }
}