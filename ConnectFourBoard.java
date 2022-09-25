/**
* Matthew Nataloni and Quinn Bissen
* Mini Project Part 1
* 
* This class is used to build the GUI and start the game.
*/
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;



public class ConnectFourBoard extends JFrame{
   
   
   private final int columns = 7; //columns in the board
   private final int rows = 6; //rows in the board
   
   private AddPiece act; //Object used to pass objects to subclass AddPiece
   
   private ImageIcon smallBlack = new ImageIcon("Images/Black.png"); //img used for player name joptionpane
   private ImageIcon smallRed = new ImageIcon("Images/Red.png"); //img used for player name joptionpane
   
   private String redName; //Name of the red player
   private String blackName; //Name of the black player
   private int turnDirtyBit; //dirty bit that specifies which player goes
   private JPanel Board; //Gui grid layout for the board
   private JLabel turnLabel; //This label states who goes frist
   private JLabel redLabel; //Red player score label
   private JLabel blackLabel; //Black player score label
   private JButton col1; //Button for column 1
   private JButton col2; //Button for column 2
   private JButton col3; //Button for column 3
   private JButton col4; //Button for column 4
   private JButton col5; //Button for column 5
   private JButton col6; //Button for column 6
   private JButton col7; //Button for column 7
   private JTextField redScoreField; //The text field that keeps track of red players score
   private JTextField blackScoreField; //The text field that keeps track of black players score
   
   private int[][] logicBoard; //2D array for the background logic of the game
   private JLabel[][] pictureBoard; //2D array of jLabels for the pictures on the board
   
   /**
   *Default Constructor, this isnt referenced in the code.
   */
   public ConnectFourBoard()
   {
               
   }
   
   /**
   *This method is used to call methods in order to build the game logic, game board, and gui for the game board.
   */
   public void startGame()
   {
      logicBoard = new int[rows][columns];
      pictureBoard = new JLabel[rows][columns];
      buildGui(); //method to build the board
      newGame(); //method to propmt for new game
   }

   
   /**
   *This method creates the layout of the game board. It creates and adds the border layouts for the GUI, the buttons for each column of the board, the variouse JLabels, the menu items.
   *Furthermore it adds functionality to populate the game board and action listers for the variouse buttons.
   *Finally, it sets the default values for the JFrame such as size and title.
   */
   public void buildGui()
   {
      
       //Grid Layout for the center
      Board = new JPanel(new GridLayout(rows,columns));
      
      //Flow layout for north
      JPanel jFlowScore = new JPanel(new FlowLayout());
      
      //Grid and flow layouts for south
      JPanel jBorderSouth = new JPanel(new BorderLayout());
      JPanel jGridBottomButtons = new JPanel(new GridLayout(1,7));
      JPanel jFlowTurn = new JPanel(new FlowLayout());
      
      
      
      
      //Create buttons for droping checkers in
      col1 = new JButton("Column 1");
      col2 = new JButton("Column 2");
      col3 = new JButton("Column 3");
      col4 = new JButton("Column 4");
      col5 = new JButton("Column 5");
      col6 = new JButton("Column 6");
      col7 = new JButton("Column 7");
      
      //Create the JMenuBar for new game and exit
      JMenuBar jMenu = new JMenuBar();
      
      //Label for whose turn it is
      turnLabel = new JLabel("");
      turnLabel.setFont(new Font("Default", Font.PLAIN, 20));
      
      //Label for red score
      redLabel = new JLabel("");
      redLabel.setFont(new Font("Default", Font.PLAIN, 16));
      
      //Label for blue score
      blackLabel = new JLabel("");
      blackLabel.setFont(new Font("Default", Font.PLAIN, 16));
      
      //Text field for red score and set editable to false
      redScoreField = new JTextField("0",2);
      redScoreField.setEditable(false);
      
      //Text field for blue score and set editable to false
      blackScoreField = new JTextField("0",2);
      blackScoreField.setEditable(false);
      
      //File menu
      JMenu file = new JMenu("File");
      
      //Menu items 
      JMenuItem newGame = new JMenuItem("New Game");
      JMenuItem abt = new JMenuItem("Directions");
      JMenuItem exit = new JMenuItem("Exit");
      
      
      
      
      //Add menu items to menu bar 
      file.add(newGame);
      file.add(abt);
      file.add(exit);
      jMenu.add(file);
      
      //Add components to the score bar
      jFlowScore.add(redLabel);
      jFlowScore.add(redScoreField);
      jFlowScore.add(blackLabel);
      jFlowScore.add(blackScoreField);
      
      //adds column buttons
      jGridBottomButtons.add(col1);
      jGridBottomButtons.add(col2);
      jGridBottomButtons.add(col3);
      jGridBottomButtons.add(col4);
      jGridBottomButtons.add(col5);
      jGridBottomButtons.add(col6);
      jGridBottomButtons.add(col7);
      
      //adds the turn label
      jFlowTurn.add(turnLabel);
      
      //add the grid lines to the playing board
      Border border = BorderFactory.createLineBorder(Color.black, 2);
   
      //populates the grid with jlabels
      for(int c = 0;c<rows;c++)
      {
         
         for(int g = 0;g<columns;g++)
         {   
            JLabel pie = new JLabel("",SwingConstants.CENTER);
            pie.setBorder(border);
            this.pictureBoard[c][g] = pie;
            Board.add(pictureBoard[c][g]);
            
         }
      }
    
      
      //adds the buttons and turn counter to the south border
      jBorderSouth.add(jGridBottomButtons, BorderLayout.NORTH);
      jBorderSouth.add(jFlowTurn, BorderLayout.SOUTH);
      
      //Add the menu bar and score bar to a border layout
      setJMenuBar(jMenu);
      add(jFlowScore, BorderLayout.NORTH);
      
      //Add jpanels to the default jframe
      add(Board, BorderLayout.CENTER);
      
      //creates a new borer layout for the bottom buttons and the turn label
      add(jBorderSouth, BorderLayout.SOUTH);  
      
      
      
      //action listeners for the exit button
      exit.addActionListener(
         new ActionListener (){ 
            public void actionPerformed(ActionEvent ae){
               System.exit(0);
            }});
            
            //action listeners for the exit button
      abt.addActionListener(
         new ActionListener (){ 
            public void actionPerformed(ActionEvent ae){
               JOptionPane.showMessageDialog(null,"This game consists of two players, one being red and the other being black. The goal of the game is \nto get four checkers in a row, whether it is vertically, horizontally, or diagonally.");
            }});
      
      //new game action listener calls the new game method      
      newGame.addActionListener(
         new ActionListener (){ 
            public void actionPerformed(ActionEvent ae){
               newGame();
            }});        
            
      //set title and other default values      
      setTitle("Connect Four by Quinn and Matthew");
      setSize(800, 700);
      setLocationRelativeTo( null );		
      setMinimumSize(new Dimension(800, 700));
      setVisible(true); 
   }
    
   /**
   *This is called whenever a new game is invoved from the menu bar. The first try / catch clears the board and prompts for the user to input thier names.
   */
   public void newGame()
   {    
      
      //calls method to clear the board and prompts for player names and sets player names
      try{
         
         resetBoard(); //method to reset board
         JOptionPane.showMessageDialog(null,"This game consists of two players, one being red and the other being black. The goal of the game is \nto get four checkers in a row, whether it is vertically, horizontally, or diagonally.");
         JFrame pane = new JFrame(); 
         
         //Prompt for red name 
         redName = (String) JOptionPane.showInputDialog(pane,"Enter player one's name:","Red Player's Name",JOptionPane.QUESTION_MESSAGE,smallRed,null,null);
         while(redName.isEmpty())
         {
            JOptionPane.showMessageDialog(pane,"Please enter a name for Player one!","Red Player Error",JOptionPane.WARNING_MESSAGE);
            redName = (String) JOptionPane.showInputDialog(pane,"Enter player one's name:","Red Player's Name",JOptionPane.QUESTION_MESSAGE,smallRed,null,null);
         }
         
         //Prompt for black name
         blackName = (String) JOptionPane.showInputDialog(pane,"Enter player two's name:","Black Player Name",JOptionPane.QUESTION_MESSAGE,smallBlack,null,null);
         while(blackName.isEmpty())
         {
            JOptionPane.showMessageDialog(pane,"Please enter a name for Player two!","Black Player Error",JOptionPane.WARNING_MESSAGE);
            blackName = (String) JOptionPane.showInputDialog(pane,"Enter player two's name:","Black Player Name",JOptionPane.QUESTION_MESSAGE,smallBlack,null,null);
         }
         
         //Set names
         redLabel.setText(redName+"'s Score");
         redLabel.setForeground(Color.RED);
         blackLabel.setText(blackName+"'s Score");
         blackLabel.setForeground(Color.BLACK);   
      }
      catch(Exception nameError)
      {
         System.exit(0);
      }
    
    //calls method that randomizes who goes first  
      randomizeTurn();
   }
   
   /**
   *This resets the board and values when new game is called.
   */
   public void resetBoard()
   {   
      //Reset both arrays
      for(int c = 0;c<logicBoard.length;c++)
      {
         
         for(int g = 0;g<logicBoard[c].length;g++)
         {
            pictureBoard[c][g].setIcon(null);
            logicBoard[c][g]= 0;
         }
      } 
      
      redName = "";
      blackName = "";
      turnDirtyBit = 0;
      turnLabel.setText("");
      redLabel.setText("");
      blackLabel.setText("");
      redScoreField.setText("0");
      blackScoreField.setText("0");
   }
   
   
   /** 
   *Creates action listeners for the columns. When a new game is called, all old aciton listeners are removed and replaced with new action listeners based on the action object.
   *This method cannot be placed in buildGUI because old values were not being updated and were carried through to the new game.
   */ 
   public void actionListeners()
   {
   
      if(act != null)
      {
         col1.removeActionListener(act);
         col2.removeActionListener(act);
         col3.removeActionListener(act);
         col4.removeActionListener(act);
         col5.removeActionListener(act);
         col6.removeActionListener(act);
         col7.removeActionListener(act);
      }
      
      act = new AddPiece(logicBoard,pictureBoard,Board,turnLabel,turnDirtyBit,redScoreField,blackScoreField,redName,blackName);
      
      //Adds action listeners
      col1.addActionListener(act);
      col2.addActionListener(act);
      col3.addActionListener(act);
      col4.addActionListener(act);
      col5.addActionListener(act);
      col6.addActionListener(act);
      col7.addActionListener(act);
   }  
   
   
   /**
   *Randomizes turn and checks who goes first, then calls action listeners.
   */
   public void randomizeTurn()
   {
      double ma = Math.random();
      turnDirtyBit = (1+(int)(ma * 2));
      
      checkTurn(); //calls method to check the turn bit
      actionListeners(); //method to create addpiece object and add object listeners
   } 
   
   /**
   *Checks who goes first, then sets the turn label to that players name.
   */
   public void checkTurn()
   {
      switch(turnDirtyBit)
      {
         case 1:
            turnLabel.setText(redName+"'s turn");
            break;
         case 2:
            turnLabel.setText(blackName+"'s turn");
            break;
      }
   }
   
   /**
   *Runs the programl.
   */
   public static void main (String [] args)
   {
      ConnectFourBoard col4 = new ConnectFourBoard();
      col4.startGame();
   }

}