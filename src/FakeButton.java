import java.awt.*;
import objectdraw.*;
/**
 * A button that uses the interface FakeButtonListener to call a method to do something
 * much like action listener
 * 
 * Jordan Dunlap
 * v 1.0
 */
public class FakeButton extends AWTWindowController
{
    private double x, y, width, height, nameWidth, nameHeight;
    private String name;
    private FilledRect inner, dark;
    private FramedRect outer;
    private Text gName;
    private int identity;
    private FakeButtonListener callingClass;
    private boolean isPressed = false;
    private Color innerColor, darkColor;
    public FakeButton(double xIn, double yIn, double widthIn, double heightIn, String nameIn, int identityIn, FakeButtonListener callingClassIn, DrawingCanvas canvasIn){
        super.init();
        x = xIn; y = yIn; width = widthIn; height = heightIn; name = nameIn; canvas = canvasIn; identity = identityIn; callingClass = callingClassIn;
        dark = new FilledRect(x, y, width, height, canvas);
        outer = new FramedRect(xIn, yIn, widthIn, heightIn, canvasIn);
        dark.setColor(new Color(255, 255, 255));
        darkColor = new Color(255, 255, 255);
        inner = new FilledRect(x + (width/10), y + (height/10), width - (width/5), height - (height/5), canvas);
        inner.setColor(new Color(240, 240, 240));
        innerColor = new Color(240, 240, 240);
        gName = new Text(name, x, y, canvas);
        nameWidth = gName.getWidth();
        nameHeight = gName.getHeight();
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public FakeButton(Location origin, double widthIn, double heightIn, String nameIn, DrawingCanvas canvasIn){
        x = origin.getX(); y = origin.getY(); width = widthIn; height = heightIn; name = nameIn; canvas = canvasIn;
        dark = new FilledRect(x, y, width, height, canvas);
        outer = new FramedRect(origin, widthIn, heightIn, canvasIn);
        dark.setColor(new Color(255, 255, 255));
        darkColor = new Color(255, 255, 255);
        inner = new FilledRect(x + (width/10), y + (height/10), width - (width/5), height - (height/5), canvas);
        inner.setColor(new Color(240, 240, 240));
        innerColor = new Color(240, 240, 240);
        gName = new Text(name, x, y, canvas);
        nameWidth = gName.getWidth();
        nameHeight = gName.getHeight();
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void onMousePress(Location pt){
        if(outer.contains(pt)){
            dark.setColor(MyColors.Darken(darkColor, 80));
            inner.setColor(MyColors.Darken(innerColor, 10));
            isPressed = true;
        }
    }
    
    public void onMouseRelease(Location pt){
        if(outer.contains(pt) && isPressed)
            callingClass.buttonAction(identity);
        dark.setColor(darkColor);
        inner.setColor(innerColor);
        isPressed = false;
    }
    
    public void moveTo(double xIn, double yIn){
        x = xIn; y = yIn;
        outer.moveTo(x, y);
        dark.moveTo(x, y);
        inner.moveTo(x + (width/10), y + (height/10));
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void moveTo(Location pt){
        x = pt.getX(); y = pt.getY();
        outer.moveTo(x, y);
        dark.moveTo(x, y);
        inner.moveTo(x + (width/10), y + (height/10));
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void move(double xIn, double yIn){
        x += xIn; y += yIn;
        outer.moveTo(x, y);
        dark.moveTo(x, y);
        inner.moveTo(x + (width/10), y + (height/10));
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void rename(String str){
        name = str;
        gName.setText(str);
        nameWidth = gName.getWidth();
        nameHeight = gName.getHeight();
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void removeFromCanvas(){
        dark.removeFromCanvas();
        inner.removeFromCanvas();
        gName.removeFromCanvas();
        outer.removeFromCanvas();
    }
    
    public void hide(){
        dark.hide();
        inner.hide();
        gName.hide();
        outer.hide();
    }
    
    public void show(){
        dark.show();
        inner.show();
        gName.show();
        outer.show();
    }
    
    public String getName(){
        return name;
    }
    
    public void setSize(double widthIn, double heightIn){
        width = widthIn; height = heightIn;
        outer.setSize(width, height);
        dark.setSize(width, height);
        inner.moveTo(x + (width/10), y + (height/10));
        inner.setSize(width - (width/5), height - (height/5));
        gName.moveTo((x + (width/2)) - (nameWidth/2), (y + (height/2)) - (nameHeight/2));
    }
    
    public void setIdentity(int i){
        identity = i;
    }
    
    public int getIdentity(){
        return identity;
    }
    
    public void setColor(Color c){
        inner.setColor(c);
        innerColor = c;
        dark.setColor(MyColors.Brighten(c, 25));
        darkColor = MyColors.Brighten(c, 25);
    }
}
