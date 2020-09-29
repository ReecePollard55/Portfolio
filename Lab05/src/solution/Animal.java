package solution;

/**
 * Animal class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 */
public abstract class Animal
{
    private String name;
    private Zoo zoo;
    private int hunger;

    /**
     * Animal Constructor.
     * @param myZoo is my zoo.
     * @param name name.
     */
    public Animal(Zoo myZoo, String name)
    {
        
        setName(name);
        setHungerLevel(0);
    }
    
    /**
     * hungerLevel getter..
     * @return hunger level.
     */
    public int getHungerLevel()
    {
        return hunger;
    }
    
    /**
     * hungerLevel setter.
     * @param hunger hunger.
     */
    public void setHungerLevel(int hunger)
    {
        if (hunger < 0)
        {
            hunger = 0;
        }
        
        else if (hunger > 10)
        {
            hunger = 10;
        }
       
        this.hunger = hunger;
    }

    /**
     * noise.
     */
    public abstract void makeNoise();
    /**
     * eat.
     */
    public abstract void eat();
    /**
     * sleep.
     */
    public void sleep()
    {
        System.out.println("sleeping...");
        setHungerLevel(10);
    }
    /**
     * roam.
     */
    public void roam()
    {
        System.out.println("moving around...");
        setHungerLevel(getHungerLevel() + 1);
    }

    /**
     * name getter.
     * @return name name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * name setter.
     * @param name name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * zoo getter.
     * @return zoo zoo.
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    
    
}