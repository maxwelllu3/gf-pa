import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a bigger fish. Fish lives underwater.
 * 
 * @author Maxwell B. Lu
 * @version 1.0.1
 */
public class BiggerFish extends Actor
{
    private int speed;
    /**
     * Constructor: Initialise the speed to a somewhat random value.
     */
    public BiggerFish()
    {
        speed = Greenfoot.getRandomNumber(5) + 1;
    }
    
    /**
     * Act - do whatever the BiggerFish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        
        if (getX() == 0) 
        {
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.removeObject(this);
        }
    }     
}
