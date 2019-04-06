import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a fish. Fish lives underwater.
 * 
 * @author Maxwell B. Lu
 * @version 1.0
 */
public class Fish extends Actor
{ 
    private GreenfootImage image1;
    private GreenfootImage image2;
    /**
     * Create the fish and initialize its two images.
     */
    public Fish()
    {
       image1 = new GreenfootImage("Fish.png");
       image2 = new GreenfootImage("Fish2.png");
       setImage(image1);
    }    
    
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       checkKeyPress();
       checkCollision();
       checkScore();
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
            Greenfoot.playSound("au.wav");
            removeTouching(BiggerFish.class);
            SeaWorld seaworld = (SeaWorld)getWorld();
            seaworld.addScore(-50);            
        }
        
        if (isTouching(Shark.class)) 
        {
            Greenfoot.playSound("au.wav");
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
    
    /**
     * Check the score to adjust the size.
     */
    private void checkScore()
    {
        SeaWorld seaworld = (SeaWorld)getWorld();
        if ((seaworld.getScore() >= 150) && (seaworld.getScore() < 200))
        {
            setImage(image2);
        }
        
        if (seaworld.getScore() < 150)
        {
            setImage(image1);
        }
    }
}
