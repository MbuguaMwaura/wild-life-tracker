import java.util.Arrays;


public class Animal{
    private String name;
    private int species_id;
    private String age;
    private String health;



    public Animal(String name, int species_id, String age, String health){
        this.name = name;
        this.species_id = species_id;
        this.age = age;
        this.health = health;
    }

    public String getName(){
        return name;
    }
    public int getSpecies_id(){
        return species_id;
    }

    public String getAge(){
        return age;
    }

    public String getHealth(){
        return health;
    }
}