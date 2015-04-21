
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Ceng443-Hw1
//  @ File Name : Mage.java
//  @ Date : 04.04.2015
//  @ Author : 
//
//




public class Mage extends BasicKnight
{

    public Mage(double xPos, double yPos, Team team) {
        super(xPos, yPos, team);
        this.setHealth(400);
        this.setSpeed(75);
        this.setMaxHealth(400);
    }
    
    @Override
    public void rangedAttack()
    {
        int distance = 0;
        int index = -1;
        
        
        if(getTeam().getName().equalsIgnoreCase("EL MORAD"))
        {
            for(Knight kn : Simulation.getInstance().getKarus())
            {
                distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance <= 100)
                {
                    this.setIsRangedAttack(true);

                    if(kn.getHealth() < 75)
                    {
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfElMorad());
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfElMorad());
                        
                        this.setScore(getScore() + 75);
                        
                        
                        
                        
                        index = Simulation.getInstance().getKarus().indexOf(kn);
                        
                    }
                    else
                    {
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), 75);
                        
                        kn.setHealth(kn.getHealth() - 75);
                    }
                }
            }
            if(index != -1)
            {
                Simulation.getInstance().getKarus().get(index).setHealth(0);

                Simulation.getInstance().getKarus().remove(index);
                Simulation.getInstance().repaint();
            }
        }
        else if(getTeam().getName().equalsIgnoreCase("KARUS"))
        {
            for(Knight kn : Simulation.getInstance().getElMorads())
            {
                distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance <= 100)
                {
                    this.setIsRangedAttack(true);

                    if(kn.getHealth() < 75)
                    {
                       
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfKarus());
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfKarus());
                        
                        this.setScore(getScore() + 75);
                        
                        
                        
                        index = Simulation.getInstance().getElMorads().indexOf(kn);
                        
                    }
                    else
                    {
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), 75);
                        
                        kn.setHealth(kn.getHealth() - 75);
                    }
                }
            } 
            if(index != -1)
            {
                Simulation.getInstance().getElMorads().get(index).setHealth(0);
                Simulation.getInstance().getElMorads().remove(index);
                Simulation.getInstance().repaint();
                
            }
        }
    }
    
    
    @Override
    public void meleeAttack()
    {
        int distance = 0;
        int index = -1;
        
        if(getTeam().getName().equalsIgnoreCase("EL MORAD"))
        {
            for(Knight kn : Simulation.getInstance().getKarus())
            {
                distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance <= 75)
                {
                    if(kn.getHealth() < 100)
                    {
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfElMorad());
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfElMorad());
                        
                        index = Simulation.getInstance().getKarus().indexOf(kn);
                        
                    }
                    else
                    {
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), 100);
                        kn.setHealth(kn.getHealth() - 100);
                    }
                    break;
                }
            }
            if(index != -1)
            {
                Simulation.getInstance().getKarus().get(index).setHealth(0);
                Simulation.getInstance().getKarus().remove(index);
                Simulation.getInstance().repaint();                

            }
        }
        else if(getTeam().getName().equalsIgnoreCase("KARUS"))
        {
            for(Knight kn : Simulation.getInstance().getElMorads())
            {
                distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance <= 75)
                {
                    if(kn.getHealth() < 100)
                    {
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfKarus());
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfKarus());
                        
                        
                        
                        index = Simulation.getInstance().getElMorads().indexOf(kn);
                        
                    }
                    else
                    {
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), 100);
                        
                        kn.setHealth(kn.getHealth() - 100);
                    }
                    break;
                }
            }
            if(index != -1)
            {
                Simulation.getInstance().getElMorads().get(index).setHealth(0);
                Simulation.getInstance().getElMorads().remove(index);
                Simulation.getInstance().repaint();
                
            }
        }
    }
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        
        
        g2d.setColor(this.getTeam().getColor());
        
        
        /*Draw and Fill Diamond*/
        NeededFunctions.getInstance().drawAndFillMage(g2d, getxPos(), getyPos(), 30, 30);
        /*Draw and Fill Diamond*/

        /*Draw Centered Text*/
        NeededFunctions.getInstance().drawCenterText(g, getxPos(), getyPos(), 10f, "" + this.getHealth(), Color.WHITE);
        /*Draw Centered Text*/
        
        
        if(getIsRangedAttack() == true)
        {
            NeededFunctions.getInstance().drawRangedAttack(g, getxPos(), getyPos(), 40, "Mage");
            setIsRangedAttack(false);
        }
    }
}