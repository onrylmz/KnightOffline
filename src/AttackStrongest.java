/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OnurYilmaz
 */
public class AttackStrongest extends Strategy{

    @Override
    public void act(Knight knight) {

        Knight strongestKnight = null;
        
        if(knight.getTeam().getName().equalsIgnoreCase("EL MORAD"))
        {
            
            strongestKnight = Simulation.getInstance().getKarus().get(0);
            
            for(Knight kn : Simulation.getInstance().getKarus())
            {
                if(strongestKnight.getHealth() <= kn.getHealth())
                    strongestKnight = kn;
            }
            
        }
        else if(knight.getTeam().getName().equalsIgnoreCase("KARUS"))
        {
            strongestKnight = Simulation.getInstance().getElMorads().get(0);
            
            for(Knight kn : Simulation.getInstance().getElMorads())
            {
                if(strongestKnight.getHealth() <= kn.getHealth())
                    strongestKnight = kn;
            }
        }
    
        double distanceX = strongestKnight.getxPos() - knight.getxPos();
        double distanceY = strongestKnight.getyPos() - knight.getyPos();
        
        double distance = NeededFunctions.getInstance().calculateDistance(strongestKnight, knight);
        
        if(knight.getxPos() < 780)
            knight.setxPos(knight.getxPos() + 
                        distanceX / distance * knight.getSpeed() / 35.0);
        
        
        
        if(50 < knight.getyPos() && knight.getyPos() < 500)
            knight.setyPos(knight.getyPos() + 
                        distanceY / distance * knight.getSpeed() / 35.0);
            
        
    
    }
    
}
