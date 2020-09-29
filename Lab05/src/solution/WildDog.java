package solution;

/**
 * WildDog class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class WildDog extends Canine
{
    /**
     * WildDog constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public WildDog(Zoo myZoo, String name)
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
}
