import objectdraw.*;
import java.awt.*;

public class Checker
{
	private int x;
	private int y;
	private FilledOval checker;
	private Checkerboard parent;
	private Team team;
	
	public Checker(int x, int y, Team t, Checkerboard board)
	{
		this.x = x;
		this.y = y;
		this.team = t;
		this.parent = board;
		
		checker = new FilledOval(Checkerboard.LEFT + x*Checkerboard.SIZE, Checkerboard.TOP + y*Checkerboard.SIZE,
				Checkerboard.SIZE, Checkerboard.SIZE, parent.canvas);
	}
	
	public boolean contains(int x, int y)
	{
		return checker.contains(new Location(x, y));
	}
	
	public boolean contains(Location loc)
	{
		return checker.contains(loc);
	}
	
	public void capture()
	{
		//TODO what happens to the piece after it is captured
	}
	
	public void move(int x, int y)
	{
		this.x = x;
		this.y = y;
		checker.moveTo(Checkerboard.LEFT + x*Checkerboard.SIZE, Checkerboard.TOP + y*Checkerboard.SIZE);
	}
	
	public boolean isOpposite(Checker other)
	{
		return other.getTeam() != this.team;
	}
	
	public void setColor(Color color)
	{
		checker.setColor(color); 
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Team getTeam()
	{
		return team;
	}
	
	public enum Team
	{
		BLACK,
		RED;
		
		public static Team getOpposite(Team t)
		{
			if(t == RED)
				return BLACK;
			else
				return RED;
		}
		
		public Team getOpposite()
		{
			if(this == RED)
				return BLACK;
			else
				return RED;
		}
	}
}
