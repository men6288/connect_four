/**
* Matthew Nataloni and Quinn Bissen
* Mini Project Part 1
* 
* This class is used to check if there is a winner of the game and add the score
*/
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckWinner
{
   private int[][] logicBoard; //2D array for the board logic
   private int redInARow; //Red pieces in a row
   private int blackInARow; //Black pieces in a row
   private JLabel turnLabel; //Label for player turn
   private JTextField redScoreField; //Label for red players score
   private JTextField blackScoreField; //Label for black players score
   private String redName; //red players name
   private String blackName; //black players name 
   private JPanel Board; //Grid layout for the game board
   private JLabel[][] pictureBoard; //2D array for the pieces
   
   
  /**
  *Default constructor.
  */ 
   public CheckWinner()
   {
   
   }
   
   /**
   *This consturctor accepts the values from the AddPiece class and calls methods to check if the board is full.
   *It also checks to see if there is four in a row and if a user has won the game.
   */
   public CheckWinner(int[][] array,JLabel[][] pic,JPanel grid, JTextField red, JTextField black, String redN, String blackN,JLabel turn)
   {
      Board = grid;
      pictureBoard = pic;
      logicBoard = array;
      redScoreField = red;
      blackScoreField = black;
      redName = redN;
      blackName = blackN;
      turnLabel = turn;
      checkFull();
      checkHorizontal();
      checkVertical();
      checkDiagonal_Bottom53();
      checkDiagonal_Bottom52();
      checkDiagonal_Bottom51();
      checkDiagonal_Bottom50();
      checkDiagonal_Bottom40();
      checkDiagonal_Bottom30();
      checkDiagonal_Top00();
      checkDiagonal_Top10();
      checkDiagonal_Top20();
      checkDiagonal_Top01();
      checkDiagonal_Top02();
      checkDiagonal_Top03();
      
   }
   
   /**
   *This method is called when four pieces in a row are found, it then prompts the user if they want to play anouther game. 
   *The two 'if' statements will be called if either red or black gets four in a row. 
   */
   public void checkGame(int red, int black)
   {
      int redInARow = red;
      int blackInARow = black;
      boolean map = true;
      int i = 0;
   
   /**
   *A panel pops up and checks to see if there are four a row, depending on which player has four in a row, it will prompt the user if they want to play again.
   *This if statement is for if the red player wins. 
   */  
      if(redInARow == 4)
      {
         turnLabel.setText(redName+" wins!");
         int yesorno = JOptionPane.showConfirmDialog(null,"Would you like to play another game?\nPressing No will exit the game.",redName+" Wins.",JOptionPane.YES_NO_OPTION);
         if (yesorno == JOptionPane.YES_OPTION) {  
            clearBoard();
            turnLabel.setText(blackName+"'s turn!");
            while(map)
            {
               String convert = Integer.toString(i);
               String rSc = redScoreField.getText();
               int compare = Integer.parseInt(rSc);
               if(compare<=i)
               {
                  if(rSc.equals(convert))
                  {
                     int score = i+1;
                     String strScore = Integer.toString(score);
                     redScoreField.setText(strScore);
                     map = false; 
                  }
               }
            
               i++;
            }
         }
         else {
            System.exit(0);  
         } 
         
         
      }
      /**
      *This statement is for if the black player wins. It is functionally the same as the red version.
      */
      else if(blackInARow == 4)
      {
         turnLabel.setText(blackName+" wins!");
         int yesorno = JOptionPane.showConfirmDialog(null,"Would you like to play another game?\nPressing No will exit the game.",blackName+" Wins.",JOptionPane.YES_NO_OPTION);
         if (yesorno == JOptionPane.YES_OPTION) {
            clearBoard();
            turnLabel.setText(redName+"'s turn!");
            while(map)
            {
               String convert = Integer.toString(i);
               String rSc = blackScoreField.getText();
               int compare = Integer.parseInt(rSc);
               if(compare<=i)
               {
                  if(rSc.equals(convert))
                  {
                     int score = i+1;
                     String strScore = Integer.toString(score);
                     blackScoreField.setText(strScore);
                     map = false; 
                  }
               }
            
               i++;
            }
         }
         else {
            System.exit(0); 
         } 
         
         
      }
   }
   /**
   *This method is called when a player wins.
   *It will resets the board based on the users decistion.
   */
   public void clearBoard()
   {
      
         
      for(int c = 0;c<logicBoard.length;c++)
      {
         
         for(int g = 0;g<logicBoard[c].length;g++)
         {
            pictureBoard[c][g].setIcon(null);
            logicBoard[c][g]= 0;
         }
      } 
      
   }
   
   
   /**
   *Checks to see if the board is full, if it is then it declairs the game a draw.
   */
   public void checkFull()
   {
      int zeroCount = 0;
      for(int c = 0;c<logicBoard.length;c++)
      {
         
         for(int g = 0;g<logicBoard[c].length;g++)
         {
            if(logicBoard[c][g] == 0)
            {
               zeroCount++;
               
            }
         }
      } 
      
      if(zeroCount == 0)
      {
         int yesorno = JOptionPane.showConfirmDialog(null,"Would you like to play another game?\nPressing No will exit the game.","It's a Draw",JOptionPane.YES_NO_OPTION);
         if (yesorno == JOptionPane.YES_OPTION) {
            clearBoard();
            turnLabel.setText("The game is a draw!");
         }
         else {
            System.exit(0); 
         } 
      }
      
   }
   
   
   /**
   *Checks the board horizonatly to see if there are four in a row.
   *If there are four in a row, a message will be outputed stating who has won.
   */
   public void checkHorizontal()
   {
      int redInARow = 0;
      int blackInARow = 0;
      for(int c = 0;c<logicBoard.length;c++)
      {
         int g = 0; 
         //c = amount of rows
         //g = amount of columns
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g]==logicBoard[c][(g+1)])
            {
               if(logicBoard[c][g]==logicBoard[c][(g+2)])
               {
                  
                  if(logicBoard[c][g]==logicBoard[c][(g+3)])
                  {
                     if(logicBoard[c][g] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[c][g] == 2)
                     {
                        blackInARow +=4;
                     }
                     //if 4 in a row, calls the method checkGame to checks to see what color the player is, 
                     //then outputs a message saying who wins
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         /**
         *Iterates through columns and checks the row to see if there are four in a row.
         *If it finds four in a row, it will check to see which player has four in a row then sets black in a row or red in a row to 4.
         */
         if(logicBoard[c][(g+1)]!=0)
         {
            if(logicBoard[c][(g+1)]==logicBoard[c][(g+2)])
            {
               if(logicBoard[c][(g+1)]==logicBoard[c][(g+3)])
               {
                  if(logicBoard[c][(g+1)]==logicBoard[c][(g+4)])
                  {
                     if(logicBoard[c][(g+1)] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[c][(g+1)] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
         if(logicBoard[c][(g+2)]!=0)
         {
            if(logicBoard[c][(g+2)]==logicBoard[c][(g+3)])
            {
               if(logicBoard[c][(g+2)]==logicBoard[c][(g+4)])
               {
                  if(logicBoard[c][(g+2)]==logicBoard[c][(g+5)])
                  {
                     if(logicBoard[c][(g+2)] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[c][(g+2)] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
         if(logicBoard[c][(g+3)]!=0)
         {
            if(logicBoard[c][(g+3)]==logicBoard[c][(g+4)])
            {
               if(logicBoard[c][(g+3)]==logicBoard[c][(g+5)])
               {
                  if(logicBoard[c][(g+3)]==logicBoard[c][(g+6)])
                  {
                     if(logicBoard[c][(g+3)] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[c][(g+3)] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
      }
      
      
   } 
   
   
   /**
   *Checks to see if there are four in a row vertically.
   *The variables for the row (g and c) are switched, g+1 is used to check accross each row.
   *This allows the program to check for a victory condition.
   */
   public void checkVertical()
   {
      int redInARow = 0;
      int blackInARow = 0;
     
      for(int c = 0;c<logicBoard.length;c++)
      {
         int g = 0; 
         if(logicBoard[g][c]!=0)
         {
            if(logicBoard[g][c]==logicBoard[(g+1)][c])
            {
               if(logicBoard[g][c]==logicBoard[(g+2)][c])
               {
                  
                  if(logicBoard[g][c]==logicBoard[(g+3)][c])
                  {
                     if(logicBoard[g][c] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[g][c] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
         if(logicBoard[(g+1)][c]!=0)
         {
            if(logicBoard[(g+1)][c]==logicBoard[(g+2)][c])
            {
               if(logicBoard[(g+1)][c]==logicBoard[(g+3)][c])
               {
                  if(logicBoard[(g+1)][c]==logicBoard[(g+4)][c])
                  {
                     if(logicBoard[(g+1)][c] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[(g+1)][c] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
         if(logicBoard[(g+2)][c]!=0)
         {
            if(logicBoard[(g+2)][c]==logicBoard[(g+3)][c])
            {
               if(logicBoard[(g+2)][c]==logicBoard[(g+4)][c])
               {
                  if(logicBoard[(g+2)][c]==logicBoard[(g+5)][c])
                  {
                     if(logicBoard[(g+2)][c] == 1)
                     {
                        redInARow +=4;
                     }
                     else if(logicBoard[(g+2)][c] == 2)
                     {
                        blackInARow +=4;
                     }
                     checkGame(redInARow,blackInARow);
                     break;
                  }
               }
            } 
         }
         
         
      }
      
      
   }
   
   /**
   *Checks to see if there are four in a row from [5][0] to [0][5].
   **/
   public void checkDiagonal_Bottom50()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      int redInARow2 = 0;
      int blackInARow2 = 0;
      
      int g = 0; 
      for(int c = 5;c>=2;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c-1)][(g+1)]!=0)
         {
            if(logicBoard[(c-1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c-1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         if(logicBoard[(c-2)][(g+2)]!=0)
         {
            if(logicBoard[(c-2)][(g+2)] == 1)
            {
               redInARow2 ++;
               blackInARow2 = 0;
            }
            else if(logicBoard[(c-2)][(g+2)] == 2)
            {
               blackInARow2 ++;
               redInARow2 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      if(blackInARow2 == 4 || redInARow2 == 4)
      {
         checkGame(redInARow2,blackInARow2);
      }
   
   }
   
   /**
   *Checks to see if there are four in a row from [5][1] to [0][6].
   **/
   public void checkDiagonal_Bottom51()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      int redInARow2 = 0;
      int blackInARow2 = 0;
      
      int g = 1; 
      for(int c = 5;c>=2;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c-1)][(g+1)]!=0)
         {
            if(logicBoard[(c-1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c-1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         if(logicBoard[(c-2)][(g+2)]!=0)
         {
            if(logicBoard[(c-2)][(g+2)] == 1)
            {
               redInARow2 ++;
               blackInARow2 = 0;
            }
            else if(logicBoard[(c-2)][(g+2)] == 2)
            {
               blackInARow2 ++;
               redInARow2 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      if(blackInARow2 == 4 || redInARow2 == 4)
      {
         checkGame(redInARow2,blackInARow2);
      }
   
   }
   
   /**
   *Checks to see if there are four in a row from [5][2] to [1][6].
   */
   public void checkDiagonal_Bottom52()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 2; 
      for(int c = 5;c>=2;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c-1)][(g+1)]!=0)
         {
            if(logicBoard[(c-1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c-1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         g++;  
      }
      
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      
   
   }
   
   /**
   *Checks to see if there are four in a row from [5][3] to [2][6].
   */
   public void checkDiagonal_Bottom53()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      
      int g = 3; 
      for(int c = 5;c>=2;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         
         g++;  
      }
      
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      
   
   }

   /**
   *Checks to see if there are four in a row from [3][0] to [0][3].
   */
   public void checkDiagonal_Bottom30()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      
      int g = 0; 
      for(int c = 3;c>=0;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         
         g++;  
      }
      
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      
   
   }

     /**
     *Checks to see if there are four in a row from [4][0] to [0][4].
     */
   public void checkDiagonal_Bottom40()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 0; 
      for(int c = 4;c>=1;c--)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c-1)][(g+1)]!=0)
         {
            if(logicBoard[(c-1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c-1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         g++;  
      }
      
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      
   
   }

   /**Checks to see if there are four in a row from [0][0] to [5][5].
   */
   public void checkDiagonal_Top00()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      int redInARow2 = 0;
      int blackInARow2 = 0;
      
      int g = 0; 
      for(int c = 0;c<=3;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c+1)][(g+1)]!=0)
         {
            if(logicBoard[(c+1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c+1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         if(logicBoard[(c+2)][(g+2)]!=0)
         {
            if(logicBoard[(c+2)][(g+2)] == 1)
            {
               redInARow2 ++;
               blackInARow2 = 0;
            }
            else if(logicBoard[(c+2)][(g+2)] == 2)
            {
               blackInARow2 ++;
               redInARow2 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      if(blackInARow2 == 4 || redInARow2 == 4)
      {
         checkGame(redInARow2,blackInARow2);
      }
   
   }

   /**
   *Checks to see if there are four in a row from [1][0] to [5][4].
   */
   public void checkDiagonal_Top10()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 0; 
      for(int c = 1;c<=4;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c+1)][(g+1)]!=0)
         {
            if(logicBoard[(c+1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c+1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
   
   }
   
    /**
    *Checks to see if there are four in a row from [2][0] to [5][3].
    */
   public void checkDiagonal_Top20()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 0; 
      for(int c = 2;c<=5;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
   
   }
   
      /**
      *Checks to see if there are four in a row from [0][3] to [3][6].
      */
   public void checkDiagonal_Top03()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 3; 
      for(int c = 0;c<=3;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
   
   }

    /**
    *Checks to see if there are four in a row from [0][2] to [4][6].
    */
    
   public void checkDiagonal_Top02()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      
      int g = 2; 
      for(int c = 0;c<=3;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c+1)][(g+1)]!=0)
         {
            if(logicBoard[(c+1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c+1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
   
   }

    /**
    *Checks to see if there are four in a row from [0][1] to [5][6].
    */
    
   public void checkDiagonal_Top01()
   {
      
      int redInARow = 0;
      int blackInARow = 0;
      int redInARow1 = 0;
      int blackInARow1 = 0;
      int redInARow2 = 0;
      int blackInARow2 = 0;
      
      int g = 1; 
      for(int c = 0;c<=3;c++)
      {
         if(logicBoard[c][g]!=0)
         {
            if(logicBoard[c][g] == 1)
            {
               redInARow ++;
               blackInARow = 0;
            }
            else if(logicBoard[c][g] == 2)
            {
               blackInARow ++;
               redInARow = 0;
            }
            
         }
         if(logicBoard[(c+1)][(g+1)]!=0)
         {
            if(logicBoard[(c+1)][(g+1)] == 1)
            {
               redInARow1 ++;
               blackInARow1 = 0;
            }
            else if(logicBoard[(c+1)][(g+1)] == 2)
            {
               blackInARow1 ++;
               redInARow1 = 0;
            }
            
         }
         if(logicBoard[(c+2)][(g+2)]!=0)
         {
            if(logicBoard[(c+2)][(g+2)] == 1)
            {
               redInARow2 ++;
               blackInARow2 = 0;
            }
            else if(logicBoard[(c+2)][(g+2)] == 2)
            {
               blackInARow2 ++;
               redInARow2 = 0;
            }
            
         }
         g++;
      }
      if(blackInARow == 4 || redInARow == 4)
      {
         checkGame(redInARow,blackInARow);
      }
      if(blackInARow1 == 4 || redInARow1 == 4)
      {
         checkGame(redInARow1,blackInARow1);
      }
      if(blackInARow2 == 4 || redInARow2 == 4)
      {
         checkGame(redInARow2,blackInARow2);
      }
   
   }



}