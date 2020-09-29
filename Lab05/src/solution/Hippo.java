package solution;

/**
 * Hippo class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Hippo extends Animal
{
    /**
     * Hippo constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Hippo(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("blub...");
    }
    /**
     * eat.
     */
    public void eat()
    {
        System.out.println("slurp...");
        setHungerLevel(getHungerLevel() - 1);
    }
}