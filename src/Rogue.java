
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Ceng443-Hw1
//  @ File Name : Rogue.java
//  @ Date : 04.04.2015
//  @ Author : 
//
//




public class Rogue extends BasicKnight
{
    
    public Rogue(double xPos, double yPos, Team team) {
        super(xPos, yPos, team);
        this.setHealth(500);
        this.setSpeed(100);
        this.setMaxHealth(500);
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
                
                if(distance <= 200)
                {
                    setIsRangedAttack(true);
                    
                    distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                    
                    this.setSpeed(200);
                    if(distance <= 1)
                    {
                        
                        if(kn.getHealth() < 250)
                        {
                            Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), kn.getHealth());   
                            Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfElMorad());
                            Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfElMorad());
                            
                            
                            this.setScore(this.getScore() + 75);
                            
                            
                            
                            index = Simulation.getInstance().getKarus().indexOf(kn);
                            
                        }
                        else
                        {
                            kn.setHealth(kn.getHealth() - 250);
                            
                            Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), 250);

                        }
                        
                        this.setSpeed(100);
                        break;
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
                
                
                if(distance <= 200)
                {
                    setIsRangedAttack(true);

                    
                    distance = (int) NeededFunctions.getInstance().calculateDistance(kn, this);
                    this.setSpeed(200);

                    if(distance <= 1)
                    {
                        if(kn.getHealth() < 250)
                        {
                            
                            
                            Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), kn.getHealth());
                            
                            Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfKarus());
                            
                            Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfKarus());
                            
                            this.setScore(this.getScore() + 75);
                            
                            
                            

                            index = Simulation.getInstance().getElMorads().indexOf(kn);
                            
                        }
                        else
                        {
                            kn.setHealth(kn.getHealth() - 250);
                            
                            Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), 250);

                        }
                        this.setSpeed(100);

                        break;
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
        double distance = 0.0;
        int index = -1;
        
        if(getTeam().getName().equalsIgnoreCase("EL MORAD"))
        {
            for(Knight kn : Simulation.getInstance().getKarus())
            {
                distance = NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance == 0)
                {
                    if(kn.getHealth() < 150)
                    {
                        
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfElMorad());
                        
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfElMorad());
                            
                        this.setScore(this.getScore() + 75);
                        
                        
                        
                        index = Simulation.getInstance().getKarus().indexOf(kn);
                        
                    }
                    else
                    {   
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfElMorad(), 150);
                        
                        kn.setHealth(kn.getHealth() - 150);
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
                distance = NeededFunctions.getInstance().calculateDistance(kn, this);
                
                if(distance == 0)
                {
                    
                    if(kn.getHealth() < 150)
                    {
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), kn.getHealth());
                        Simulation.getInstance().increaseTotalKillOfTeam(Simulation.getTeamOfKarus());
                        
                        Simulation.getInstance().increaseScoreOfTeam(Simulation.getTeamOfKarus());
                            
                        this.setScore(this.getScore() + 75);
                        
                        
                        
                        index = Simulation.getInstance().getElMorads().indexOf(kn);
                        
                    }
                    else
                    {
                        
                        Simulation.getInstance().increaseTotalDamageOfTeam(Simulation.getTeamOfKarus(), 150);
                        
                        kn.setHealth(kn.getHealth() - 150);
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
    public void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g.create();
                
        g2d.setColor(this.getTeam().getColor());
        
        
        /*Draw and Fill Triangle*/
        NeededFunctions.getInstance().drawAndFillRogue(g2d, getxPos(), getyPos(), 24, 24);
        /*Draw and Fill Triangle*/

        /*Draw Centered Text*/
        NeededFunctions.getInstance().drawCenterText(g, getxPos(), getyPos(), 10f, "" + this.getHealth(), Color.WHITE);
        /*Draw Centered Text*/
        
        if(getIsRangedAttack() == true)
        {
            NeededFunctions.getInstance().drawRangedAttack(g, getxPos(), getyPos(), 40, "Rogue");
            setIsRangedAttack(false);
        }
        
    }
}
