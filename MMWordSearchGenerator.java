//Programmer: Makealah Miller
//Class: CS&145
//Date: 6/1/2023
//Assignment: Assignment 1: Word Search Generator
//Purpose: User inputs words that they'd like to implement in a word search puzzle, then 
//program will generate a word search puzzle for the user. 
//This is the test class

import java.util.*; 

public class MMWordSearchGenerator
{

   public static void main(String[] args) //start of main method
   {
      Scanner input = new Scanner(System.in);
      String userInput;
      String menuInput;
      String menu = "notOkay";
      Stack <String> userWords = new Stack<String>();
      
      System.out.println("Welcome to the Borpo's Pizza Employee Word Search Generator!");
      System.out.println("All Borpo employees are required to engage in stimulating activities daily.");
      System.out.println("This is not optional, and we hope you have fun!");
      System.out.println("Lucky for you, we have implemented a new function");
      System.out.println("Where you can generate your very own personalized word search puzzle!");
      
      WordInSearch grid = new WordInSearch(); 
      
      do //start of do/while menu loop
      {
         System.out.println("Please select one of the following options:");
         System.out.println("Generate a new word search (g)");
         System.out.println("Print out your word search (p)");
         System.out.println("Show the solution to your word search (s)");
         System.out.println("Quit the program (q)");
         menuInput = input.nextLine();
         
         if(menuInput.equals("g")) //start of if/else 
         {
            System.out.println("What words would you like to add to your word search?");
            System.out.println("Please enter up to six words.");
            System.out.println("When you are finished, please enter 'finished'.");
            do
            {
               userInput = input.nextLine();
               userWords.push(userInput);
            }
            while(!userInput.equals("finished"));
            
            grid.populateWordsStack(userWords);
            grid.finishedPuzzle(userWords);
            menu = "okay";
         }
         else if(menu.equals("okay")) //this prevents following menu items from being accessed until 
         // the user has provided their puzzle words
         {
            if(menuInput.equals("p"))
            {
               grid.printGame();
            }
            else if(menuInput.equals("s"))
            {
               grid.printSolution();
            }
            else if(menuInput.equals("q"))
            {
               System.out.println("Great job enriching your mind! Have an out of this world day!");
            }
         }
      } //end of if/else
      while(!menuInput.equals("q")); //end of do/while
   } //end of main method
} //end of class

