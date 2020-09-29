package solution;

/**
 * FeralCat class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class FeralCat extends Feline
{
    /**
     * FeralCat constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public FeralCat(Zoo myZoo, String name)
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
}
