
import org.sql2o.*;
import java.util.List;
import java.util.Arrays;

public class Species{
    private String name;
    private int population;
    private boolean endangered;
    private int id;

    public Species(String name, int population, boolean endangered){
        this.name = name;
        this.population = population;
        this.endangered = endangered;

    }

    public String getName(){
        return name;
    }

    public int getPopulation(){
        return population;
    }
    public boolean isEndangered(){
        return endangered;
    }

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object otherSpecies){
        if(!(otherSpecies instanceof Species)){
            return false;
        } else {
            Species species = (Species) otherSpecies;
            return this.getName().equals(species.getName()) &&
                    this.getPopulation() == species.getPopulation() &&
                    this.isEndangered() == species.isEndangered();

        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO species (name, population, endangered) VALUES (:name, :population, :endangered)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("population", this.population)
                    .addParameter("endangered", this.endangered)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Species> all(){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM species";
            return con.createQuery(sql).executeAndFetch(Species.class);
        }
    }
}