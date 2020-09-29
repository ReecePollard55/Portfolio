package solution;

import java.util.ArrayList;

/**
 * Zoo class.
 * 
 * @author Reece Pollard
 * @version 2/20/2020
 *
 */
public class Zoo implements AnimalLocation
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> zooAnimals;
    
    /**
     * @param name name
     * @param latitude latitude
     * @param longitude longitude
     */
    public Zoo(String name, double latitude, double longitude)
    {
        setName(name);
        this.latitude = latitude;
        this.longitude = longitude;
        this.zooAnimals = new ArrayList<Animal>();
    }
    
    /**
     * @param animal animal
     */
    public void addAnimal(Animal animal)
    {
        zooAnimals.add(animal);
    }
    /**
     * testAnimal.
     */
    public void testAnimals()
    {
        System.out.println(name);
        System.out.println(latitude);
        System.out.println(longitude);
        
        for (Animal animal : zooAnimals)
        {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
            animal.roam();
            
            if (animal instanceof Pet)
            {
                ((Pet) animal).play();
                ((Pet) animal).beFriendly();
            }
        }
    }

    /**
     * name getter.
     * @return name name
     */
    public String getName()
    {
        return name;
    }

    /**
     * name setter.
     * @param name name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * latitude getter.
     * @return latitude latitude
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * longitude getter.
     * @return longitude longitude
     */
    public double getLongitude()
    {
        return longitude;
    }

    /**
     * animal # getter.
     * @return size number of animals
     */
    @Override
    public int getNumOfAnimals()
    {
        return zooAnimals.size();
    }
    
    /**
     * Main method.
     * @param args string array of args
     */
    public static void main(String[] args)
    {
        Zoo zoo = new Zoo("Test Zoo", 1.0, 1.0);

        zoo.addAnimal(new Cat(zoo, "Felix the Cat"));
        zoo.addAnimal(new Coyote(zoo, "Bob the Coyote"));
        zoo.addAnimal(new Dog(zoo, "Sandra the Dog"));
        zoo.addAnimal(new FeralCat(zoo, "James the Feral Cat"));
        zoo.addAnimal(new Hippo(zoo, "Stewart the Hippo"));
        zoo.addAnimal(new Lion(zoo, "Leo the Lion"));
        zoo.addAnimal(new WildDog(zoo, "Max the Wild Dog"));
        zoo.addAnimal(new Wolf(zoo, "Tammy the Wolf"));
        
        zoo.testAnimals();
    }
}
