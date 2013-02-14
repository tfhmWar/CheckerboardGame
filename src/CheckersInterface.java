/**
 * Write a description of class CheckersInterface here.
 * 
 * Lorenzo Martinez, Conner Lambden, Chris Sotorros 
 * 2/14/13
 */
import java.awt.*;
import objectdraw.*;
public class CheckersInterface extends FrameWindowController implements FakeButtonListener 
{
    private FakeButton endTurn;
    private FramedRect player1Frame,player2Frame;
    private FilledRect player1Highlight,player2Highlight;
    private Text player1Text,player2Text;
    private boolean playerTurn;
    private CheckerBoard board;
    //private Color highlightTurn;
    public void createInterface()
    {   
        board = new CheckerBoard();
        board.createBoard(canvas);
        player1Frame = new FramedRect(250,50,100,50,canvas);
        player2Frame = new FramedRect(250,100,100,50,canvas);
        
        player1Highlight = new FilledRect(251,51,99,49,canvas);
        player1Highlight.setColor(Color.orange);
        //player1Highlight.hide();
        player2Highlight = new FilledRect(251,101,99,49,canvas);
        player2Highlight.setColor(Color.orange);
        player2Highlight.hide();
        
        player1Text = new Text("Player 1's turn",260,66,canvas);        
        player2Text = new Text("Player 2's turn",260,116,canvas);
        
        endTurn = new FakeButton(250,200,100,50,"End Turn",1,this,canvas);

    }
    public void highlight(int playerNumber)
    {
        if(playerNumber == 1)
        {
           player1Highlight.show();
           player2Highlight.hide();
        }
        else
        {
            player2Highlight.show();
            player1Highlight.hide();
        }
    }
    public void buttonAction(int identity)
    {
        if(identity == 1)
        {            
            if(playerTurn == false)
            {
                highlight(2);
                playerTurn = true;
            }
            else
            {
                highlight(1);
                playerTurn = false;
            }
            //placeholder for the method that gets called when the turn is ended
        }
    }
}
