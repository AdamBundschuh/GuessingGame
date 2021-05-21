/*
Build the application in the following small iterations.
It should function at completion of each iteration!

1. When the user guesses 7, the game announces they have won. All other numbers lose.
2. When the user guesses 0, the game provides instructions for the user.
3. After guessing, the user can take one more guess (unless they won!)
4. When the user guesses -1, the application should exit.
5. The game should provide feedback that the secret number is > or < any incorrect guesses.
6. The number should be random, instead of always 7.
7. Stretch task: Give the user 3 tries before announcing they have lost.
 */

import java.util.Scanner;

public class GuessingGameApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int randomNum = (int) Math.floor((Math.random() * 10) + 1);
        String lineBreak = "===============================";

        // System.out.println("Random number is: " + randomNum);
        System.out.println(lineBreak);
        System.out.println("Welcome to the WCCI Guessing Game!");
        System.out.println("A number between 1 and 10 has been randomly generated.");
        System.out.println("Please guess the number now:");

        int userGuess;
        boolean guessIsValid = false;

        for (int i = 0; i < 3; i++) {

            do {
                userGuess = input.nextInt();

                if (userGuess == -1) {
                    break;
                } else if (userGuess < -1 || userGuess > 10) {
                    System.out.println(lineBreak);
                    System.out.println("\"" + userGuess + "\"" + " is not between 1 and 10!");
                    System.out.println("Enter \"0\" for instructions.");
                    System.out.println("Please enter a valid number:");
                } else if (userGuess == 0) {
                    System.out.println(lineBreak);
                    System.out.println("Game Instructions:");
                    System.out.println("You must guess a random number between 1 and 10.");
                    System.out.println("Entering \"-1\" will exit the game.");
                    System.out.println("You have 3 tries total, please enter a valid guess:");

                } else {
                    guessIsValid = true;
                    break;
                }
            } while (!guessIsValid);


            boolean isGuessCorrect = (userGuess == randomNum);
            String highOrLow = userGuess < randomNum ? "low" : "high";

            if (userGuess == -1) {
                System.out.println("Game is exiting...\nGoodbye! *AOL Close Door Noise*");
                break;
            } else if (isGuessCorrect) {
                System.out.println("Congrats! You guessed correctly on try number " + (i + 1) + "!");
                break;
            } else if (i < 2) {
                System.out.println(lineBreak);
                System.out.println("Wrong, try again!");
                System.out.println("Attempts left: " + (2 - i));
                System.out.println("Hint: Your guess was too " + highOrLow + "!");
            } else {
                System.out.println(lineBreak);
                System.out.println("You failed to guess \"" + randomNum + "\" correctly!");
                System.out.println("GAME OVER! Sucks to suck, nerd.");
            }


        }
    }
}