import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a plankton. Plankton lives underwater.
 * 
 * @author Maxwell B. Lu
 * @version 1.0.1
 */
public class Plankton extends Actor
{
    private int speed;
    /**
     * Constructor: Initialise the speed to a somewhat random value.
     */
    public Plankton()
    {
        speed = Greenfoot.getRandomNumber(5) + 1;
    }
    
    /**
     * Act - do whatever the Plankton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.removeObject(this);
        }
    }    
}
