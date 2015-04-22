
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OnurYilmaz
 */
public class NeededFunctions {
    
    private static NeededFunctions instance;
    private final Tuple firstKarusCoordinate;
    private final Tuple firstElMoradCoordinate;

    public NeededFunctions() {
        
        Tuple karus = new Tuple(730.0, 430.0);
        Tuple elMorad = new Tuple(120.0, 120.0);
        this.firstKarusCoordinate = karus;
        this.firstElMoradCoordinate = elMorad;
    }

    public Tuple getFirstKarusCoordinate() {
        return firstKarusCoordinate;
    }

    public Tuple getFirstElMoradCoordinate() {
        return firstElMoradCoordinate;
    }
    
    
    
    public static NeededFunctions getInstance()
    {
        if(instance == null)
        {
            instance = new NeededFunctions();
        }
        return instance;
    }
    
    public double calculateDistance(Knight kn1, Knight kn2)
    {
        double distanceX = kn1.getxPos() - kn2.getxPos();
        double distanceY = kn1.getyPos() - kn2.getyPos();
        
        double distance =  Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        
        return distance;
    }
    
    public void drawRangedAttack(Graphics g, double x, double y, int radius, String kn)
    {
        /*Draw Circle Around Knight*/
        
        
        if(kn.equalsIgnoreCase("Priest"))
            g.setColor(new Color(0, 128, 0));
        else if(kn.equalsIgnoreCase("Rogue"))
            g.setColor(new Color(255, 165, 0));
        else
            g.setColor(new Color(255, 0, 255));
        
        g.drawOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        
       
        g.fillOval((int) x - radius, (int) y - radius, 2 * radius , 2 * radius);
    }
    
    public void drawGradeDecorator(Graphics g, double x, double y, int radius, int whichGrade)
    {
        if(whichGrade == 1)
            g.setColor(Color.YELLOW);
        else if(whichGrade == 2)
            g.setColor(Color.PINK);
        else
            g.setColor(Color.CYAN);
        g.drawOval((int) x - radius, (int) y - radius, 5, 5);
        g.fillOval((int) x - radius, (int) y - radius, 5, 5);
    }
    
    public void drawAndFillPriest(Graphics g, double x, double y, int width, int height)
    {
        g.drawRect((int)x, (int)y, width, height);
        g.fillRect((int)x, (int)y, width, height);
        
        
    }
    
    void drawAndFillRogue(Graphics g, double x, double y, int width, int height) 
    {
        int[] xCoors = {(int)x - 16, (int)x , (int)x + 16};
        int[] yCoors = {(int)y + 11, (int)y - 18 , (int)y + 11};
        
        Polygon p = new Polygon(xCoors, yCoors, 3);
        
        g.drawPolygon(p);
        g.fillPolygon(p);
    }
    
    void drawAndFillMage(Graphics g, double x, double y, int width, int height) 
    {
        int[] xCoors = {(int)x - width / 2, (int)x, (int)x + width / 2, (int)x};
        int[] yCoors = {(int)y, (int)y - width / 2, (int)y, (int)y + width / 2};
        
        Polygon p = new Polygon(xCoors, yCoors, 4);
        
        g.drawPolygon(p);
        g.fillPolygon(p);
    }
    
    public void drawCenterText(Graphics g, double x, double y, float size, String text, Color color)
    {
        Font font = g.getFont().deriveFont(size);
        
        g.setFont(font);
        
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rectangle = fm.getStringBounds(text, g);
        
        int textHeight = (int) (rectangle.getHeight());
        int textWidth = (int) (rectangle.getWidth());

        // Find the top left and right corner
        double cornerX = x - (textWidth / 2);
        double cornerY = y - (textHeight / 2) + fm.getAscent();

        g.setColor(color);
        g.drawString(text, (int)cornerX, (int)cornerY); // Draw the string.
        
    }

    

    
    
    
}
