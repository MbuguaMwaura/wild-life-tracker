import java.util.Arrays;
import org.sql2o.*;
import java.util.List;

public class Animal{
    private String name;
    private int species_id;
    private String age;
    private String health;
    private int id;


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

    public int getId(){
        return id;
    }

    public int getTotalAnimals(){
        return Animal.all().size();
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

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, health, age, species_id) VALUES (:name, :health, :age, :species_id)";
          this.id =(int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("species_id", this.species_id)
                    .executeUpdate()
                  .getKey();

        }
    }

    public static List<Animal> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals";
         return    con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }
    public static Animal find(int id){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals WHERE id =:id";
            Animal animal  = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
    public void update( String age, String health){
        try(Connection con = DB.sql2o.open()){
            String sql = "UPDATE animals SET  age = :age, health = :health WHERE id = :id";
            con.createQuery(sql)

                    .addParameter("age", age)
                    .addParameter("health" , health)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}