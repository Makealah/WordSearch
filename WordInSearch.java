//Programmer: Makealah Miller
//Class: CS&145
//Date: 05/03/2023
//Assignment: Assignment 1: Word Search Generator 
//Purpose: User inputs words that they'd like to implement in a word search puzzle, then 
//program will generate a word search puzzle for the user. 
//This is the object class.

import java.util.*;

public class WordInSearch 

{

   Stack<String> userWords;
   char character;
   char[][] game = new char [30][30];
   char[][] gameSolve = new char [30][30];
   
   
   public WordInSearch() //start of constructor method LetterCounter
   {
      populateGridWithAsterisks(); 
   } //end of constructor method
   
   public void populateWordsStack(Stack<String> userWords) //start of populateWordsStack
   {
      this.userWords = userWords; 
   } //end of populateWordsStack
   
   //getLength method assumes that letter characters in string are >0
   //getLength method will return int length which is the number of letter chars in the string
   public static int getLength(String word) //start of getLength method
   {
      int length = 0;
		for (int i = 0; i < word.length(); i++)
      {
			if (Character.isLetter(word.charAt(i)))
         {
				length++;
			}
		}
      return length;
	} //end of getLength
   
   //this method fills the empty grid game with asterisks
   public void populateGridWithAsterisks() //start of populateGridWithAsterisks
   {
      for(char[] row : this.game)
        {
            for(int i = 0; i < 30; i++)
            {
               row[i] = '*'; 
            }
        }
   } //end of populateGridWithAsterisks
   
   //this method will fill the game grid with the words the user submitted
   // this method assumes that the stack userWords contains strings
   public void fillGame(Stack<String> userWords) //start of fillGame
   {
      boolean forwardHorizontal = false; 
      boolean backwardHorizontal = false; 
      boolean forwardVertical = false; 
      boolean backwardVertical = false;
      boolean forwardDiagonal = false; 
      boolean backwardDiagonal = false; 
      
      String newWord = userWords.pop();
      do
      {
        newWord = userWords.pop(); 
        if(!forwardHorizontal)
        {
           forwardHorizontal(newWord); 
           forwardHorizontal = true; 
        }
        else if(!backwardHorizontal)
        {
           backwardHorizontal(newWord); 
           backwardHorizontal = true;
        }
        else if(!forwardVertical)
        {
           forwardVertical(newWord);
           forwardVertical = true;
        }
        else if(!backwardVertical)
        {
           backwardVertical(newWord); 
           backwardVertical = true;
        }
        else if(!forwardDiagonal)
        {
           forwardDiagonal(newWord);
           forwardDiagonal = true;
        }
        else if(!backwardDiagonal)
        {
           backwardDiagonal(newWord);
           backwardDiagonal = true;
        }
      }
      while(!userWords.empty());
     
      for(int i = 0; i < game.length; i++) //copies contents of game into gameSolve
      {
         gameSolve[i] = game[i].clone();
      }
   } //end of fillGame
   
   
   public void forwardHorizontal(String newWord) //start of forwardHorizontal
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[27][8+i] = newWord.charAt(i);
      }
   }//end of forwardHorizontal
   
   public void backwardHorizontal(String newWord)//start of backwardHorizontal
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[17][10+i] = newWord.charAt(length-1-i);
      }
   } //end of backwardHorizontal
   
   public void forwardVertical(String newWord) //start of forwardVertical
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[5+i][3] = newWord.charAt(i);
      }
   }//end of forwardVertical
   
   public void backwardVertical(String newWord) //start of backwardVertical
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[7+i][9] = newWord.charAt(length-1-i);
      }
   } //end of backwardVertical
   
   public void forwardDiagonal(String newWord)//start of forwardDiagonal
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[15-i][13+i] = newWord.charAt(i);
      }
   }//end of forwardDiagonal
   
   public void backwardDiagonal(String newWord) //start of backwardDiagonal
   {
      int length = getLength(newWord);
      for(int i=0; i < length; i++)
      {
         game[19+i][14+i] = newWord.charAt(i);
      }
   } //end of backwardDiagonal
   
   public void printGame() //start of printGame
   {
        for(char[] row : this.game)
        {
            printRow(row);
        }
   } //end of printGame
   
   public void printSolution() //start of printSolution
   {
        for(char[] row : this.gameSolve)
        {
            printRow(row);
        }
   } //end of printSolution
   
   public void printRow(char[] row) //start of printRow, which prints individual rows within the table
   {
        for (char character : row) 
        { 
            System.out.print(character);
            System.out.print("\t");
        }
        System.out.println();
   } //end of printRow
   
   public void finishedPuzzle(Stack<String> userWords) //start of finishedPuzzle, which adds random chars to puzzle
   {
      fillGame(userWords);
      for(char[] row : this.game)
        {
            for(int i = 0; i < 30; i++)
            {
               if(row[i] == '*')
               {
                  Random r = new Random();
                  char c = (char)(r.nextInt(26) + 'a');
                  row[i] = c;
               }
            }
        }
   }//end of finishedPuzzle
 } //end of WordInSearch