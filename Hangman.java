// Name: Derek Darko
// Email: ddarko365@gmail.com
// Date: 3 Nov 2016
// Bugs: None

import java.util.*;

public class Hangman {
  public static void main(String[] args) {
    System.out.println();
    System.out.println("This program plays a game of reverse hangman.");
    System.out.println("You think up a word (by typing it on the computer) and I'll try to guess");
    System.out.println("the letters.");
    System.out.println();
    //Put main game in the static method
    playGame();
  }

  public static void playGame(){
    Scanner console = new Scanner(System.in);
    System.out.print("How many letters are in your word? ");
    //The user will have to input the number of letters in the word and the
    //hidden word itself
    int letters = console.nextInt();
    System.out.print("Please enter the word for me to guess (letters only): ");
    String hangWord = console.next();
    //Create static methods to create hidden word, hangman figure, and the CPU's guesses
    System.out.println(makeLine(letters));
    drawStrike(0);
    hangMan(hangWord, makeLine(letters));
  }

  public static String makeLine(int stringNum){
    //The for loop adds dashes to the empty string to create the hidden word
    String mystery = "";
    for (int i = 0; i < stringNum; i++) {
      mystery = mystery + "-";
    }
    return mystery;
  }

  public static void hangMan(String word, String mystery) {
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    int lcount = word.length();
    //Created counters for found letters and strikes the CPU made
    int lfound = 0;
    int strike = 0;
    //Since random numbers assigned to letters cannot be stopped from being
    //reused, a string was instead created consisting of every letter of the alphabet
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    //Created if statements nested in a do while loop with the condition that
    //there is at least one dash in the hidden word
    do {
      //Created variable that chooses a random letter from the number of
      //available letters in the alphabet string
      int r = rand.nextInt(25-strike-lfound);
      //It then chooses a random character from the string
      char guess = alphabet.charAt(r);
      System.out.println("I've got " + lfound + " of the " + lcount + " letters so far");
      System.out.println("I guess: " + guess);
      System.out.print("Is that letter in the word? ");
      String response = console.next();
      //Created an if statement to check that user inputs y or n
      if (!(response.equals("y") || response.equals("n"))) {
          System.out.println("Please enter y or n");
      }
      if (response.equals("y")) {
        for(int i = 0; i < lcount; i++) {
          if (guess == word.charAt(i)) {
            //The correct letter gets revealed in the hidden word every time it appears
            mystery = mystery.substring(0,i) + word.charAt(i) + mystery.substring((i+1));
            //The found letter gets accumulated
            lfound++;
          }
        }
        System.out.println(mystery);
        drawStrike(strike);
        //Alphabet gets updated by removing the selected letter
        alphabet = alphabet.substring(0,r) + alphabet.substring((r+1));
        //Guess can get updated here
        guess = alphabet.charAt(r);
      } else {
        //A strike gets added for an incorrect letter
        strike++;
        System.out.println(mystery);
        //The figure gets updated for each new strike
        drawStrike(strike);
        //Alphabet gets updated by removing the selected letter
        alphabet = alphabet.substring(0,r) + alphabet.substring((r+1));
        //Guess can get updated here
        guess = alphabet.charAt(r);
      }
    } while (strike < 7 && mystery.indexOf("-") != -1);
    if (mystery.equals(word) && strike < 7) {
      //When there are no more dashes in the hidden word the cpu won
      System.out.println("Congrats");
    }
    if (strike == 7) {
      //If there are seven strikes the cpu lost and displays the full figure
      System.out.println();
      drawStrike(6);
      System.out.println("You beat me this time.");
    }
  }

  public static void drawStrike(int strike) {
    //Created six different options for the figure dependent on the number of strikes the CPU has
    if (strike == 0) {
      System.out.println("+--+");
      System.out.println("|  |");
      for(int i = 0; i<=3; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 1) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      for(int i = 0; i<=2; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 2) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      System.out.println("|  |");
      for(int i = 0; i<=1; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 3) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      System.out.println("|  |");
      System.out.println("|   \\");
      for(int i = 0; i<=0; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 4) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      System.out.println("|  |");
      System.out.println("| / \\");
      for(int i = 0; i<=0; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 5) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      System.out.println("|  |\\");
      System.out.println("| / \\");
      for(int i = 0; i<=0; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
    if (strike == 6) {
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|  O");
      System.out.println("| /|\\");
      System.out.println("| / \\");
      for(int i = 0; i<=0; i++){
        System.out.println("|");
      }
      System.out.println("+---------+");
    }
  }
}
