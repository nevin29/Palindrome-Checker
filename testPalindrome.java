// Name: <Nevin Gutta>
// Class: CS 3305/Section#
// Term:
// Instructor: Umama Tasnim
// Assignment: 3

import java.util.*;
public class testPalindrome {

    //This method tests to see whether a inputted string is a character palindrome
    public static void CharacterPalindrome(Scanner scanner) {
        //asks the user to enter a string
        System.out.print("Enter a string: ");
        //this line makes all the words lower case and removes spaces from the inputted String
        String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z]", "");

        //passes string to the isPalindrome method to judge.
        if (isPalindrome(input))
            System.out.println("Judgment: Palindrome");
        else
            System.out.println("Judgment: Not Palindrome");
    }

    //this method tests to see if sentences are palindromes
    public static void WordPalindrome(Scanner scanner) {
        //asks the user to enter a string
        System.out.print("Enter a string: ");
        //this line makes all the words lower case and removes spaces from the inputted String
        String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z ]", "");
        //splits strings into seperate words using spaces
        String[] words = input.split("\\s+");
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        //adding each word to the queue and stack
        for (String word : words) {
            queue.offer(word);
            stack.push(word);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Judgment: Palindrome");
        else
            System.out.println("Judgment: Not Palindrome");
    }

    //method to check if a sequence of strings is a palindrome
    //returns true if string is palindrome and false if string is not a palindrome
    public static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(c);
                queue.offer(c);
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //repeating while loop that does not stop until users exits the menu by pressing 3
        while (true){
            System.out.println();
            System.out.println("-----MAIN MENU-----");
            System.out.println("1. Test character-by-character palindrome");
            System.out.println("2. Test word-by-word palindrome");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter an option: ");
            int option = input.nextInt();
            input.nextLine();

            //for options 1 and 2 the program immediately passes the user ono the method they chose
            if (option == 1){
                CharacterPalindrome(input);

            }
            else if (option == 2){
                WordPalindrome(input);

            }
            //exits the program
            else if (option ==3){
                System.out.println("Exiting program...");
                System.exit(0);

            }
            //if the user does not choose a menu option
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}