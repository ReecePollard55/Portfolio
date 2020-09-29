package solution;

/**
 * Dog class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Dog extends Canine implements Pet
{
    /**
     * Dog constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Dog(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("bark...");
    }
    /**
     * eat.
     */
    public void eat()
    {
        System.out.println("slop...");
        setHungerLevel(getHungerLevel() - 3);
    }
    /**
     * play.
     */
    public void play()
    {
        System.out.println("frolic...");
    }
    /**
     * beFriendly.
     */
    public void beFriendly()
    {
        System.out.println("bark...");
    }
}