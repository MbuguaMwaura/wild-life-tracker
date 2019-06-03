import org.junit.*;
import static org.junit.Assert.*;
import java.sql.Timestamp;


public class SightingTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting sighting = new Sighting (1,2,3,4);
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    public void sighting_instantiatedWithAnimal_Id(){
        Sighting sighting =  new Sighting (1,2,3,4);
        assertEquals(1, sighting.getAnimal_id());
    }

    @Test
    public void sighting_instantiatesWithSpecies_id(){
        Sighting sighting =  new Sighting (1,2,3,4);
        assertEquals(4, sighting.getSpecies_id());
    }

    @Test
    public void sighting_instantiatesWithLocation_Id(){
        Sighting sighting =  new Sighting (1,2,3,4);
        assertEquals(2, sighting.getLocation_id());
    }
    @Test
    public void sighting_instantiatesWithRanger_Id(){
        Sighting sighting =  new Sighting (1,2,3,4);
        assertEquals(3, sighting.getRanger_id());
    }
    @Test
    public void equals_returnsTrueIfObjectsAreEquals(){
        Sighting sighting =  new Sighting (1,2,3,4);
        Sighting sightingtwo =  new Sighting (1,2,3,4);
        assertTrue(sighting.equals(sightingtwo));
    }

    @Test
    public void save_savesObjectIntoDatabase(){
        Sighting sighting =  new Sighting (1,2,3,4);
        sighting.save();
        assertEquals(true, Sighting.all().get(0).equals(sighting));
    }

    @Test
    public void all_retrievesAllInstancesFromTheDatabase(){
        Sighting sighting =  new Sighting (1,2,3,4);
        sighting.save();
        Sighting sightingTwo =  new Sighting (2,3,1,4);
        sightingTwo.save();
        assertTrue(Sighting.all().get(0).equals(sighting));
        assertTrue(Sighting.all().get(1).equals(sightingTwo));

    }

    @Test
    public void find_retrievesASpecificSightingUsingItsId(){
        Sighting sighting =  new Sighting (1,2,3,4);
        sighting.save();
        Sighting sightingTwo =  new Sighting (2,3,4,5);
        sightingTwo.save();
        assertEquals(sightingTwo.getAnimal_id(), Sighting.find(sightingTwo.getId()).getAnimal_id());
    }

    @Test
    public void update_updatesAnSightingDetails(){
        Sighting sighting =  new Sighting (1,2,3,4);
        sighting.save();
        sighting.update(2,3,4,5);
        assertEquals(4, Sighting.find(sighting.getId()).getRanger_id());
    }


}