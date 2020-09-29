package solution;

/**
 * Lion class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Lion extends Feline
{
    /**
     * lion constructor.
     * @param myZoo myZoo
     * @param name namew
     */
    public Lion(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * noise.
     */
    public void makeNoise()
    {
        System.out.println("roar...");
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
