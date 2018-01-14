// Name: Derek Darko
// Email: ddarko365@gmail.com
// Date: 3 Nov 2016
// Bugs: None

import java.util.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    System.out.println("Would you like to play? ");
    //Main game in static method
    rpsGame();
    System.out.println("Maybe next time!");
  }

  public static void rpsGame() {
    //User will have to input yes fo game to begin
    Scanner console = new Scanner(System.in);
    String nswer;
    //A do while loop is necessary for game to be played at least once
    //The condition for the for loop is the user continues to input yes to play again.
    do {
      System.out.println("This will be fun");
      System.out.println("Rock, Paper, Scissors SHOOT!");
      String rps = console.next();
      Random rand = new Random();
      //Create random object to use pseudorandom numbers
      int r = rand.nextInt(3);
      int newr = rand.nextInt(2);
      //Method calls in the print statement
      //Created cpuPlay to determine the CPU's choice
      //Created winner to determine winner between user and CPU
      if (winner(rps,cpuPlay(r)).equals("Invalid option")) {
        System.out.println("Invalid game");
      } else {
        System.out.println("CPU chose " + cpuPlay(r));
        System.out.println(winner(rps,cpuPlay(r)) + " won");
      }
      System.out.println("Would you like to play again? ");
      //User input gets updated here for rematch
      nswer = console.next();
      //Created if statement to check user input was either yes or no
      if (!(nswer.equals("yes") || nswer.equals("Yes") || nswer.equals("no") || nswer.equals("No"))) {
          System.out.println("Please enter yes or no");
      }
      if ((nswer.equals("yes") || nswer.equals("Yes"))) {
        System.out.println("Would you want to reveal which choice you made last game? ");
        //Are able to access other strategy in the rematch
        String round2 = console.next();
        if (!(round2.equals("yes") || round2.equals("Yes") || round2.equals("no") || round2.equals("No"))) {
            System.out.println("Please enter yes or no");
        } else if ((round2.equals("yes") || round2.equals("Yes"))) {
          System.out.println("Which one did you choose? ");
          String newnswer = console.next();
          if (!(newnswer.equals("Rock") || newnswer.equals("rock") || newnswer.equals("Paper") || newnswer.equals("paper") || newnswer.equals("Scissors") || newnswer.equals("scissors"))) {
              System.out.println("Invalid option");
          }
          if (newnswer.equals("Rock") || newnswer.equals("rock")) {
            System.out.println("Rock, Paper, Scissors SHOOT!");
            //Created new user input for rematch
            String rps1 = console.next();
            //Created new method call for rematch if the previous choice was rock
            if (winner(rps1,rematchr(newr,newnswer)).equals("Invalid option")) {
              System.out.println("Invalid game");
            } else {
              System.out.println("CPU chose " + rematchr(newr,newnswer));
              System.out.println(winner(rps1,rematchr(newr,newnswer)) + " won");
            }
            System.out.println("Would you like to play again? ");
            //Able to update answer again after rematch
            nswer = console.next();
          } else if (newnswer.equals("Paper") || newnswer.equals("paper")) {
            System.out.println("Rock, Paper, Scissors SHOOT!");
            String rps1 = console.next();
            //Created new method call for rematch if the previous choice was paper
            if (winner(rps1,rematchp(newr,newnswer)).equals("Invalid option")) {
              System.out.println("Invalid game");
            } else {
              System.out.println("CPU chose " + rematchp(newr,newnswer));
              System.out.println(winner(rps1,rematchp(newr,newnswer)) + " won");
            }
            System.out.println("Would you like to play again? ");
            //Able to update answer again after rematch
            nswer = console.next();
          } else {
            System.out.println("Rock, Paper, Scissors SHOOT!");
            String rps1 = console.next();
            //Created new method call for rematch if the previous choice was scissors
            if (winner(rps1,rematchs(newr,newnswer)).equals("Invalid option")) {
              System.out.println("Invalid game");
            } else {
              System.out.println("CPU chose " + rematchs(newr,newnswer));
              System.out.println(winner(rps1,rematchs(newr,newnswer)) + " won");
            }
            System.out.println("Would you like to play again? ");
            //Able to update answer again after rematch
            nswer = console.next();
          }
        }
      }
    } while (nswer.equals("yes") || nswer.equals("Yes")); //Returns to main method after while condition is false
  }

  public static String winner(String user, String cpu) {
    //Created if statement to check user input was either rock, paper, or scissors
    if (!(user.equals("Rock") || user.equals("rock") || user.equals("Paper") || user.equals("paper") || user.equals("Scissors") || user.equals("scissors"))) {
        return "Invalid option";
    } else if (user.equals("Rock")|| user.equals("rock")) {
      if (cpu.equals("Paper")) {
        return "CPU";
      } else if (cpu.equals("Scissors")) {
        return "Player";
      } else {
        return "No one";
      }
    } else if (user.equals("Scissors") || user.equals("scissors")) {
      if (cpu.equals("Rock")) {
        return "CPU";
      } else if (cpu.equals("Paper")) {
        return "Player";
      } else {
        return "No one";
      }
    } else {
      if (cpu.equals("Scissors")) {
        return "CPU";
      } else if (cpu.equals("Rock")) {
        return "Player";
      } else {
        return "No one";
      }
    }
  }

  public static String cpuPlay(int random) {
    //Uses pseudorandom numbers from static method to choose option
    if (random == 0) {
      return "Rock";
    } else if (random == 1) {
      return "Paper";
    } else { // random == 2
      return "Scissors";
    }
  }

  //Strategy was based on the repetition players make when playing the same opponent more than once
  public static String rematchr(int newr, String choice) {
    //If the user declared using rock last game the user would feel more inclined to use it again
    if (choice.equals("Rock") || choice.equals("rock")) {
      return "Paper";
    } else {
      //Uses pseudorandom numbers from static method to choose option
      if (newr == 0) {
        return "Rock";
      } else {
        return "Scissors";
      }
    }
  }

  public static String rematchp(int newr, String choice) {
    //If the user declared using paper last game the user would feel more inclined to use it again
    if (choice.equals("Paper") || choice.equals("paper")) {
      return "Scissors";
    } else {
      if (newr == 0) {
        return "Rock";
      } else {
        return "Scissors";
      }
    }
  }

  public static String rematchs(int newr, String choice) {
    //If the user declared using scissors last game the user would feel more inclined to use it again
    if (choice.equals("Scissors") || choice.equals("scissors")) {
      return "Rock";
    } else {
      if (newr == 0) {
        return "Rock";
      } else {
        return "Scissors";
      }
    }
  }
}
