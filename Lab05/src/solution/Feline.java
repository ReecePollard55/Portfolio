package solution;

/**
 * Feline class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public abstract class Feline extends Animal
{
    /**
     * Feline Constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Feline(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * roam.
     */
    public void roam()
    {
        System.out.println("felines like to roam alone...");
        setHungerLevel(getHungerLevel() + 1);
    }
}

