
import java.text.DateFormat;
import java.util.Arrays;
import org.sql2o.*;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


public class Sighting{
    private int animal_id;
    private int location_id;
    private int ranger_id;
    private int species_id;
    private Timestamp time;

    private int id;


    public Sighting(int animal_id,int location_id, int ranger_id,int species_id){
       this.animal_id = animal_id;
       this.location_id = location_id;
       this.ranger_id = ranger_id;
        this.species_id = species_id;


       
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getSpecies_id(){
        return species_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public int getId(){
        return id;
    }

    public String getFormattedDate(){
        return DateFormat.getDateTimeInstance().format(time);
    }

   public static Animal getAnimal(int id){
        return Animal.find(id);
   }


    @Override
    public boolean equals(Object otherSighting){
        if(!(otherSighting instanceof Sighting)){
            return false;
        } else {
            Sighting sighting = (Sighting) otherSighting;
            return this.getAnimal_id() == sighting.getAnimal_id() &&
                    this.getLocation_id() == sighting.getLocation_id() &&
                    this.getRanger_id() == sighting.getRanger_id() &&
                    this.getSpecies_id() == sighting.getSpecies_id();
                    
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings (animal_id, location_id, ranger_id, species_id, time) VALUES (:animal_id, :location_id, :ranger_id, :species_id ,now())";
            this.id =(int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location_id", this.location_id)
                    .addParameter("ranger_id", this.ranger_id)
                    .addParameter("species_id", this.species_id)
                    .executeUpdate()
                    .getKey();

        }
    }

    public static List<Sighting> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings";
            return    con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE id =:id";
            Sighting sighting  = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
    public void update(int animal_id, int location_id, int ranger_id,  int species_id){
        try(Connection con = DB.sql2o.open()){
            String sql = "UPDATE sightings SET animal_id = :animal_id, species_id = :species_id, location_id = :location_id, ranger_id = :ranger_id, time = now() WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("animal_id", animal_id)
                    .addParameter("species_id", species_id)
                    .addParameter("location_id", location_id)
                    .addParameter("ranger_id" , ranger_id)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}