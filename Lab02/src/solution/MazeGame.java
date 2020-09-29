package solution;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * A maze game.
 * 
 * @author Reece Pollard
 * @version 1/27/2020
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;
    private boolean[][] breadCrumb;
    
    /**
     * The current location of the player vertically.
     */
    // TODO: add field here.
    private int userCol;

    /**
     * The current location of the player horizontally.
     */
    // TODO: add field here.
    private int userRow;
    /**
     * The scanner from which each move is read.
     */
    // TODO: add field here.
    private Scanner moveScanner;
    /**
     * The row and column of the goal.
     */
    // TODO: add fields here.
    private int goalCol;
    private int goalRow;
    
    /**
     * The row and column of the start.
     */
    // TODO: add fields here.
    private int startCol;
    private int startRow;

    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        // TODO
        loadMaze(mazeFile);
        setMoveScanner(new Scanner(System.in));
        
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
    	// TODO
        
        setMoveScanner(moveScanner);
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }
    
    /**
     * Function loads the data from the maze file and creates the 'blocked' 
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    // TODO: private void loadMaze(String mazeFile)
    public void loadMaze(String mazeFile)
    {
        Scanner readFile = null;
        File inFile = new File(mazeFile);
        try 
        {
            readFile = new Scanner(inFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("no file found");
            System.exit(0);
        }
        blocked = new boolean[HEIGHT][WIDTH];
        breadCrumb = new boolean[HEIGHT][WIDTH];
        for (int row = 0; row < HEIGHT; row++)
        {
            for (int col = 0; col < WIDTH; col++)
            {
                breadCrumb[row][col] = false;
                String crumb = readFile.next();
                if (crumb.equals("0"))
                {
                    blocked[row][col] = true;
                }
                else if (crumb.equals("1"))
                {
                    blocked[row][col] = false;
                }
                else if (crumb.equals("S"))
                {
                    setStartCol(col);
                    setStartRow(row);
                    
                    setUserCol(col);
                    setUserRow(row);
                    
                    blocked[row][col] = true;
                }
                else if (crumb.equals("G"))
                {
                    setGoalCol(col);
                    setGoalRow(row);
                   
                    blocked[row][col] = true;
                }
            }
        }
    }
    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        userRow = startRow;
        userCol = startCol;

        String command = "";
        Scanner moveScanner = getMoveScanner();

        while (!command.contentEquals("Quit"))
        {
            printMaze();
            System.out.print("Enter command (up, down, left, right): ");
            command = moveScanner.next();

            System.out.println();
            makeMove(command);

            if (playerAtGoal())
            {
                System.out.println("You win");
                command = "Quit";
            }
        }
 

    }

    /**
     * Checks to see if the player has won the game.
     * @return true if the player has won.
     */
    // TODO: 
    
    public boolean playerAtGoal()
    {       
        return getUserRow() == getGoalRow() 
            && getUserCol() == getGoalColumn();      
    }
    
    
    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {
        
        // TODOif 
        if (move.equals("up"))
        {
            return moveUp();
        }
        else if (move.equals("down"))
        {
            return moveDown();
        }
        else if (move.equals("left"))
        {
            return moveLeft();
        }
        else if (move.equals("right"))
        {
            return moveRight();
        }
        else
        {
            return true;
        }
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        // TODO
        
        boolean[][] mazeGame = getMaze();     

        System.out.print("*");
        for (int row = 0; row < mazeGame[0].length; row++)
        {
            System.out.print("-");
        }
        System.out.println("*");

        for (int row = 0; row < mazeGame.length; row++)
        {
            System.out.print("|");

            for (int col = 0; col < mazeGame[row].length; col++)
            {
                if (row == getUserRow() && col == getUserCol())
                {
                    System.out.print("@");
                }
                else if (row == getStartRow() && col == getStartCol())
                {
                    System.out.print("S");
                }
                else if (row == getGoalRow() && col == getGoalColumn())
                {
                    System.out.print("G");
                }
                else if (blocked[row][col] == false)
                {
                    System.out.print("X");
                }
                else if (breadCrumb[row][col])
                {
                    System.out.print(".");
                }
                else if (blocked[row][col] == true)
                {
                    System.out.print(" ");
                }
            }

            System.out.println("|");
        }
        
        System.out.print("*");
        for (int row = 0; row < mazeGame[0].length; row++)
        {
            System.out.print("-");
        }
        System.out.println("*");

    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "data/easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
    }
    /**
     * Getter for Column.
     * 
     * @return userCol
     */
    public int getUserCol()
    {
        return this.userCol;
    }

    /**
     * Setter for Column.
     * 
     * @param userCol sets users column
     *            
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
    }

    /**
     * Getter for row.
     * 
     * @return userRow
     */
    public int getUserRow()
    {
        return this.userRow;
    }

    /**
     * Setter for row.
     * 
     * @param userRow sets user row
     *            
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
    }

    /**
     * Getter for move.
     * 
     * @return move
     */
    public Scanner getMoveScanner()
    {
        return this.moveScanner;
    }
    /**
     * Setter for move.
     * 
     * @param moveScanner moves scanner
     *            
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
    }

    /**
     * Get start row.
     * 
     * @return startRow
     */
    public int getStartRow()
    {
        return this.startRow;
    }

    /**
     * Get start column.
     * 
     * @return startCol
     */
    public int getStartCol()
    {
        return this.startCol;
    }

    /**
     * Set start column.
     * 
     * @param column sets column
     *            
     * 
     *         
     */
    public void setStartCol(int column)
    {
        this.startCol = column;
    }
    /**
     * Set start row.
     * 
     * @param row sets row
     *            
     * 
     *         
     */
    public void setStartRow(int row)
    {
        this.startRow = row;
    }

    /**
     * Get goal row.
     * 
     * @return goalRow
     */
    public int getGoalRow()
    {
        return this.goalRow;
    }

    /**
     * Get goal column.
     * 
     * @return goalCol
     */
    public int getGoalColumn()
    {
        return this.goalCol;
    }

    /**
     * Set goal column.
     * 
     * @param column sets column
     *                       
     */
    public void setGoalCol(int column)
    {
        this.goalCol = column;
    }
    /**
     * Set goal row.
     * 
     * @param row sets row
     *                      
     */
    public void setGoalRow(int row)
    {
        this.goalRow = row;
    }
    /**
     * 
     * @return userCol
     */
    public int getUserColumn()
    {
        return userCol;
    }
    /**
     * 
     * @return right
     */
    public boolean moveRight()
    {
        if (userCol + 1 < WIDTH && blocked[userRow][userCol + 1] 
            && blocked[userRow][userCol])
        {
            breadCrumb[userRow][userCol] = true;
            userCol++;
            return true;
        }
        return false;
    }
    /**
     * 
     * @return up
     */
    public boolean moveUp()
    {
        if (userRow - 1 >= 0 && blocked[userRow - 1][userCol]
            && blocked[userRow][userCol])
        {
            breadCrumb[userRow][userCol] = true;
            userRow--;
            
            return true;

        }
        return false;
    }
    /**
     * 
     * @return left
     */
    public boolean moveLeft()
    {
        if (userCol - 1 >= 0 && blocked[userRow][userCol - 1] 
            && blocked[userRow][userCol])
        {
            breadCrumb[userRow][userCol] = true;
            userCol--;
            return true;
            
        }
        return false;
    }
    /**
     * 
     * @return down
     */
    public boolean moveDown()
    {
        if (userRow + 1 < HEIGHT && blocked[userRow + 1][userCol] 
            && blocked[userRow][userCol])
        {
            breadCrumb[userRow][userCol] = true;
            userRow++;
            return true;
        }
        return false;
    }

}


