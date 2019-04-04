import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a fish. Fish lives underwater.
 * 
 * @author Maxwell B. Lu
 * @version 1.0
 */
public class Fish extends Actor
{ 
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       checkKeyPress();
       checkCollision();
    }    
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-8);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+8);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+4, getY());
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
        }
    }
    
    /**
     * Check whether we are touching another organism.
     */
    private void checkCollision()
    {
        if (isTouching(SmallerFish.class)) 
        {
            Greenfoot.playSound("slurp.wav");
            removeTouching(SmallerFish.class);
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.addScore(50);
        }

        if (isTouching(BiggerFish.class)) 
        {
            removeTouching(BiggerFish.class);
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.addScore(-50);            
        }
        
        if (isTouching(Shark.class)) 
        {
            removeTouching(Shark.class);
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.addScore(-100);            
        }
        
        if (isTouching(Plankton.class)) 
        {
            Greenfoot.playSound("slurp.wav");
            removeTouching(Plankton.class);
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.addScore(10);            
        }
    }
}
