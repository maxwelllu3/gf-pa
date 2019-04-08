import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines a sea, where all the sea creatures live.
 * 
 * @author Maxwell B. Lu 
 * @version 1.0.1
 */
public class SeaWorld extends World
{
    private int score;
    private int time;
    
    /**
     * Constructor for objects of class SeaWorld.
     */
    public SeaWorld()
    {    
        // Create a new world with 1024x768 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        prepare();
        score = 0;
        time = 4000;
        showScore();
        showTime();
    }
    
    /**
     * Create new organisms at irregular intervals.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(200) < 1)
        {
            addObject(new BiggerFish(), 1024, Greenfoot.getRandomNumber(768));
        }
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new SmallerFish(), 1024, Greenfoot.getRandomNumber(768));
        }
        
        if (Greenfoot.getRandomNumber(50) < 1)
        {
            addObject(new Plankton(), 1024, Greenfoot.getRandomNumber(768));
        }
        
        if (Greenfoot.getRandomNumber(700) < 1)
        {
            addObject(new Jellyfish(), 1024, Greenfoot.getRandomNumber(768));
        }
        
        if (Greenfoot.getRandomNumber(300) < 1)
        {
            addObject(new Dolphin(), 1024, Greenfoot.getRandomNumber(768));
        }
        
        if (Greenfoot.getRandomNumber(300) < 1)
        {
            addObject(new Shark(), 1024, Greenfoot.getRandomNumber(768));
        }
        countTime();
    }
    
    /**
     * Add some points to our current score. (May be negative.)
     * If the score falls below 0, game's over.
     */
    public void addScore(int points)
    {
        score = score + points;
        showScore();
        if (score < 0) 
        {
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Show our current score on screen.
     */
    private void showScore()
    {
        showText("Score: " + score, 70, 25);
    }
    
    /**
     * Count down the game time and display it. Stop the game 
     * with a winning message when time is up.
     */
    private void countTime()
    {
        time--;
        showTime();
        if (time == 0)
        {
            showEndMessage();
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        showText("Time: " + time, 950, 25);
    }
    
    /**
     * Show the end-of-game message on screen.
     */
    private void showEndMessage()
    {
        showText("Time is up - you win!", 500, 300);
        showText("Your final score: " + score + " points", 500, 345);
    }
    
    /**
     * Prepare the world for the start of the program. In this case: Create
     * a fish at the left side of the World, at 200x340.
     */
    private void prepare()
    {
        Fish fish = new Fish();
        addObject(fish, 200, 340);
    }
    
    /**
     * Return the current score
     */
    public int getScore()
    {
        return score;
    }
}
