/**
* Matthew Nataloni and Quinn Bissen
* Mini Project Part 1
* 
* This class is used to add pieces to the board and place checkers on the board.
*/
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;


public class AddPiece implements ActionListener
{
   private int[][] logicBoard; //Logic board 2D array
   private JLabel turnLabel; //Label that says who goes next
   private int turnDirtyBit; //the dirty bit that switches the players turn
   private JTextField redScore; //red players score
   private JTextField blackScore; //black players score
   private String redName; //red players name
   private String blackName; //black players name
   private JLabel[][] pictureBoard; //2D array for the pictures on the board
   private ImageIcon black = new ImageIcon("Images/bPiece.png"); //img for board pieces
   private ImageIcon red = new ImageIcon("Images/rPiece.png"); //img for board pieces
   private JPanel Board; //grid layout on the gui

   
   
   /**
   *Default constructor.
   */
   public AddPiece()
   {
      
   }
  
   
   /**
   *Passes in all values for the ConnectFourBoard class that need to be changed when a piece is placed on the board.
   */
   
   public AddPiece(int[][] array,JLabel[][] pic,JPanel grid,JLabel turn, int bit, JTextField red, JTextField black, String rName, String bName)
   {
      logicBoard = array;
      turnLabel = turn;
      pictureBoard = pic;
      Board = grid;
      turnDirtyBit = bit;
      redScore = red;
      blackScore = black;
      redName = rName;
      blackName = bName;
      
   }
     
   /**
   *Paces checkers onto the board.
   */ 
   public void setBoard(int row, int col,int turn)
   {
      
         
      if (turn == 1)
      {
         pictureBoard[row][col].setIcon(red);
         
      }
      else if (turn == 2)
      {
         pictureBoard[row][col].setIcon(black);
         
      }
         
      
   }  
   
       
  /**Trys to add pieces to the logic board based on which player's turn it is .
   *colPosition is the column in which each piece is placed.
   *First [] is for the row value of the 2D array.
   *Turn dirybit checks for which player is placing the piece, checks for if it is the red player(1) or black player(2).
   */
   public void tryAdd(int colPosition)
   { 
      if(logicBoard[5][colPosition] == 0)
      {  
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[5][colPosition]= turnDirtyBit;
               setBoard(5,colPosition,turnDirtyBit);
               
               break;
            case 2:
               logicBoard[5][colPosition]= turnDirtyBit;
               setBoard(5,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }
      else if(logicBoard[4][colPosition] == 0)
      {
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[4][colPosition]= turnDirtyBit;
               setBoard(4,colPosition,turnDirtyBit);
               break;
            case 2:
               logicBoard[4][colPosition]= turnDirtyBit;
               setBoard(4,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }
      else if(logicBoard[3][colPosition] == 0)
      {
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[3][colPosition]= turnDirtyBit;
               setBoard(3,colPosition,turnDirtyBit);
               break;
            case 2:
               logicBoard[3][colPosition]= turnDirtyBit;
               setBoard(3,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }
      else if(logicBoard[2][colPosition] == 0)
      {
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[2][colPosition]= turnDirtyBit;
               setBoard(2,colPosition,turnDirtyBit);
               break;
            case 2:
               logicBoard[2][colPosition]= turnDirtyBit;
               setBoard(2,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }
      else if(logicBoard[1][colPosition] == 0)
      {
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[1][colPosition]= turnDirtyBit;
               setBoard(1,colPosition,turnDirtyBit);
               break;
            case 2:
               logicBoard[1][colPosition]= turnDirtyBit;
               setBoard(1,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }
      else if(logicBoard[0][colPosition] == 0)
      {
         switch(turnDirtyBit)
         {
            case 1:
               logicBoard[0][colPosition]= turnDirtyBit;
               setBoard(0,colPosition,turnDirtyBit);
               break;
            case 2:
               logicBoard[0][colPosition]= turnDirtyBit;
               setBoard(0,colPosition,turnDirtyBit);
               break;
         }
         changeTurn();
      }      
      else
      {
         JOptionPane.showMessageDialog(null,"Column full, pick another column.");
      }
      
      
   
   }
 
  /**
  *Prints the logic for the board
  */
   public void to()
   {  
   
      for(int c = 0;c<logicBoard.length;c++)
      {
         
         for(int g = 0;g<logicBoard[c].length;g++)
         {
            System.out.print(logicBoard[c][g] + " ");
         }
         System.out.println("");
      }
      System.out.println("");
   } 
   
   
 /**
  *Once a piece is placed, this method is called to change the player's turn.
  *Checks to see number of dirty bit to see if player one or two, then changes to alternate player. 
  */ 
  public void changeTurn()
  
   {
      if(turnDirtyBit == 1)
      {
         turnLabel.setText(blackName+"'s Turn");
         turnDirtyBit = 2;
      }
      else if(turnDirtyBit == 2)
      {
         turnLabel.setText(redName+"'s Turn");
         turnDirtyBit = 1;
      } 
   }
      
 /**
 *When a button is pushed, this button is called, this method calls the tryAdd method in order to place a piece
 *colPosition specifies which column you add a piece to 
 */    
   public void actionPerformed(ActionEvent e)
   {  
      
      int colPlace = 0;
      
      
         
      if(e.getActionCommand().equals("Column 1")){      
         tryAdd(colPlace);
         
         to();
         
         
      }
      else if(e.getActionCommand().equals("Column 2")){      
         colPlace = 1;      
         tryAdd(colPlace);
         
         to();
         
         
      }
      else if(e.getActionCommand().equals("Column 3")){      
         colPlace = 2;      
         tryAdd(colPlace);
         
         to();
         
             
      }
      else if(e.getActionCommand().equals("Column 4")){      
         colPlace = 3;      
         tryAdd(colPlace);
         
         to();
         
         
           
      }
      else if(e.getActionCommand().equals("Column 5")){      
         colPlace = 4;      
         tryAdd(colPlace);
         
         to();
         
              
      }
      else if(e.getActionCommand().equals("Column 6")){      
         colPlace = 5;      
         tryAdd(colPlace);
         
         to();
         
              
      }
      else if(e.getActionCommand().equals("Column 7")){      
         colPlace = 6;      
         tryAdd(colPlace);
         
         to();
         
              
      } 
      
      /**
      *This passes variables to the check winner constructor so it can validate if there is a winner and if the board is full.
      **/
      CheckWinner winner = new CheckWinner(logicBoard,pictureBoard,Board,redScore,blackScore,redName,blackName,turnLabel);        
   }
   
   
   
}   
