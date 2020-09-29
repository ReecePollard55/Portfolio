package solution;

/**
 * Wolf class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 */
public class Wolf extends Canine
{
    /**
     * Wolf constructor.
     * @param myZoo is the Zoo.
     * @param name is the name of zoo.
     */
    public Wolf(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("growl...");
    }
    /**
     * eat.
     */
    public void eat()
    {
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel() - 2);
    }
}