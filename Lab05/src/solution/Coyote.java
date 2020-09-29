package solution;

/**
 * Coyote Class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Coyote extends Canine
{
    /**
     * Coyote constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Coyote(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("howl...");
    }
    /**
     * eat.
     */
    public void eat()
    {
        System.out.println("gnaws...");
        setHungerLevel(getHungerLevel() - 2);
    }
}
