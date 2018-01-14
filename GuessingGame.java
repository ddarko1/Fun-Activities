// Name: Derek Darko
// Email: ddarko365@gmail.com
// Date: 3 Nov 2016
// Bugs: None

import java.util.*;

public class GuessingGame {
    //Created class constant to be changed for any range
    public static final int SIZE = 100;
    public static void main(String [] args) {
      Scanner console = new Scanner(System.in);
      System.out.println();
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("Think of a number between 1 and 100");
      System.out.println("and I will guess until I get it.");
      System.out.println("For each guess, tell me if the");
      System.out.println("right answer is higher or lower than your guess, or if it is correct.");
      System.out.println();
      int guesses = 0;
      //Was able to initialize to count for the number of guesses per game
      //as well calling the method for the first game
      int firstGame = guessGame();
      //Created variable to determine the greatest number of guesses
      guesses += firstGame;
      //initialized counter for number of games played
      int maxGuess = firstGame;
      int games = 1;
      System.out.println("Would you like to play again? ");
      String rematch = console.next();
      //Created an if statement to check that user inputs yes or no
      if (!(rematch.equals("yes") || rematch.equals("Yes") || rematch.equals("no") || rematch.equals("No"))) {
          System.out.println("Please enter yes or no");
      }
      //Created a do while statement nested in the if statement to determine
      //whether or not to start a new game
      if (rematch.equals("yes") || rematch.equals("Yes")) {
        //The while condition is dependent on user saying yes
        do {
        int newGame = guessGame();
        //Guesses accumulate after each new game
        guesses += newGame;
        //The highest number of guesses is determined here
        if (newGame > maxGuess) {
          maxGuess = newGame;
        }
        //After each rematch, the number of games gets accumulated
        games++;
        System.out.println("Would you like to play again? ");
        //The while statement can get updated by a change in the user's response
        rematch = console.next();
        } while (rematch.equals("yes") || rematch.equals("Yes"));
      }
      //Print statistics of games if the user does not want to play again
      if (rematch.equals("no") || rematch.equals("No")) {
        System.out.println();
        System.out.println("Overall Results: ");
        System.out.println("  total games:    " + games);
        System.out.println("  total guesses:  " + guesses);
        System.out.printf("  guesses/game:   %.2f\n", (double) guesses/games);
        System.out.println("  max guesses:    " + maxGuess);
      }
    }

    public static int guessGame() {
      Scanner console = new Scanner(System.in);
      //Used Math random class to determine maximum number of options to choose from
      int guess = (int)(Math.random()*SIZE)+1;
      System.out.println("Think of a number... ");
      System.out.println("My guess: " + guess);
      //Created a user input to response to the CPU's guess
      String reply = console.next();
      //Created max and min variables to be updated after each guess
      int max = SIZE;
      int min = 1;
      //The variable count gets accumulated after each guess
      int count = 0;
      //Created an if statement nested in a while loop to continue running until the CPU's guess is correct
      while (!(reply.equals("correct"))) {
        //If the user's reply is lower than previous guess, the new max to guess from is changed to the last guess
        //The new guess's range as a result gets reduced due the smaller difference between min and max
        if (reply.equals("lower")) {
          max = (guess-1);
          guess = min + (int)(Math.random() * ((max - min) + 1));

          System.out.println("\nMy guess: " + guess);
          //The if condition can be updated here if its not lower
          reply = console.next();
          count++;
          //If the user's reply is higher than previous guess, the new min to guess from is changed to the last guess
          //The new guess's range as a result gets reduced due the smaller difference between min and max
        } else if (reply.equals("higher")) {
          min = (guess+1);
          guess = min + (int)(Math.random() * ((max - min) + 1));
          System.out.println("\nMy guess: " + guess);
          //The if condition can be updated here if its not higher
          reply = console.next();
          count++;
        }
      }
      //Displays the number of guesses the CPU had until it reached the correct answer
      if (reply.equals("correct")) {
        System.out.println("\nI got it right in " + (count + 1) + " guesses!");
      }
      //Returns int to add the number of guesses
    return (count+1);
  }
}
