import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a dolphin, dolphin lives underwater.
 * 
 * @author Maxwell B. Lu
 * @version 1.0
 */
public class Dolphin extends Actor
{
    private int speed;
    /**
     * Constructor: Initialise the speed to a somewhat random value.
     */
    public Dolphin()
    {
        speed = Greenfoot.getRandomNumber(5) + 1;
    }
    
    /**
     * Act - do whatever the SmallerFish wants to do. This method is called whenever
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
