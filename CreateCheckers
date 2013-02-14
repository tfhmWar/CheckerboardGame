/**
 * WORKS IN CORRESPONDENCE WITH CheckerBoard.java, Checker.java, and testChecker.java
 * This class takes in the Checkerboard class and will create the checker pieces 
 * on the corresponding squares. 12 blue checkers placed on top and 12 green 
 * checkers on the bottom. 
 * 
 * Author: Lily Dam & Ryan Finney
 * Date: February 14th, 2013
 */
//imported libraries: 
import java.awt.*;
import objectdraw.*;

public class CreateCheckers 
{
    //This is the one dimensional array that will hold the checker object: 
    private Checker[] checkers= new Checker[24];
    
    /**
     * This will inherit the Checkerboard class and access the number of rows and
     * columns with the get.Rows() & getCols() methods. Two loop structures are used to
     * create (1) twelve blue checkers on top of the board and (2) twelve green checker
     * on the bottom. 
     * 
     */
    public CreateCheckers(CheckerBoard board)
    {
        //Getting number of rows and columns from board: 
        int rows= board.getRows();
        int cols= board.getCols();
        int x=0; //keep track of checkers
      
        //This looping structure steps through the top of the board; IF the square is red, then a checker 
        // will be created in the 1-D array of checkers and then places the checker on the board at the
        //corresponding spot. 
        for(int c=0; c<3; c++)//counting columns
        {
            
            for(int r=0; r<cols; r++)//counting rows
            {
                //Checking if the square is red: 
                if(board.getBoxColor(r,c)==Color.RED)
                    {
                       //creates the checker object multiple times into the 1-d array: 
                       checkers[x] = new Checker(r,c,Checker.Team.BLUE, board);
                       checkers[x].setColor(Color.blue); //Sets the color of the checkers to blue
                       x++; 
                    }
                    
            }
            
        }
        
        //This looping structure steps through the bottom of the board; IF the square is red, then a checker 
        //will be created in the 1-D array of checkers and then places the checker on the board at the 
        //corresponding spot. 
        for(int c2 = 5; c2<rows; c2++)//counting columns
        {
            
            for(int r2 = 0; r2<cols; r2++)//countimg rows
            {
                //Checking if the square is red: 
                if(board.getBoxColor(c2,r2) == Color.RED)
                {
                    //creates the checker object multiple times into the 1-d array: 
                    checkers[x] = new Checker(r2,c2,Checker.Team.GREEN, board); 
                    checkers[x].setColor(Color.green); //Sets the color of the checkers to green
                    x++; 
                }
            }
        }
    }
}
