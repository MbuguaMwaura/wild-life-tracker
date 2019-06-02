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

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        } else {
            Animal animal = (Animal) otherAnimal;
            return this.getName().equals(animal.getName()) &&
                    this.getSpecies_id() == animal.getSpecies_id() &&
                    this.getAge().equals(animal.getAge()) &&
                    this.getHealth().equals(animal.getHealth());

        }
    }

}