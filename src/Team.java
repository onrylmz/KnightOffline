
import java.awt.Color;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Ceng443-Hw1
//  @ File Name : Team.java
//  @ Date : 04.04.2015
//  @ Author : 
//
//




public class Team
{
    public String name;
    public int score;
    public Color color;
    public int totalKills;
    public int totalDamage;

    public Team(String name) {
        this.name = name;
        this.score = 0;
        this.totalKills = 0;
        this.totalDamage = 0;
        
        if(name.equalsIgnoreCase("KARUS"))
        {
            this.color = Color.RED;
        }
        else if(name.equalsIgnoreCase("EL MORAD"))
        {
            this.color = Color.BLUE;
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }
    
    
}
