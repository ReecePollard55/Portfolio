package solution;

/**
 * Canine class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public abstract class Canine extends Animal
{
    /**
     * Canine constructor.
     * @param myZoo myZoo
     * @param name name
     */
    public Canine(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * roam.
     */
    public void roam()
    {
        System.out.println("like canines roam in packs...");
        setHungerLevel(getHungerLevel() + 1);
    }
}
