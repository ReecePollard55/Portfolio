package solution;

/**
 * Cat class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Cat extends Feline implements Pet
{
    /**
     * Cat constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Cat(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("meow...");
    }
    /**
     * eat.
     */
    public void eat()
    {
        System.out.println("pick...");
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
        System.out.println("purr...");
    }
}