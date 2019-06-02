
import org.junit.*;
import static org.junit.Assert.*;


public class SpeciesTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();


    @Test
    public void species_instantiatesCorrectly(){
        Species testSpecies = new Species("Buffalo", 2000, false);
        assertEquals(true,testSpecies instanceof Species );
    }

    @Test
    public void getName_instantiatesWithName(){
        Species species = new Species("Buffalo", 2000, false);
        assertEquals("Buffalo", species.getName());
    }

    @Test
    public void getPopulation_instantiatesWithPopulation(){
        Species species = new Species("Buffalo", 2000, false);
        assertEquals(2000, species.getPopulation());
    }
    @Test
    public void getEndangered_instantiatesWithEndangered(){
        Species species = new Species("Buffalo", 2000, false);
        assertEquals(false, species.isEndangered());
    }

    @Test
    public void equals_assertsThatObjectsWithSameValueAreEqual(){
        Species speciesOne = new Species("Buffalo", 2000, false);
        Species speciesTwo = new Species("Buffalo", 2000, false);
        assertTrue(speciesOne.equals(speciesTwo));
    }

    @Test
    public void save_insertsObjectIntoDatabase(){
        Species species = new Species("Buffalo", 2000, false);
        species.save();
        assertEquals(true, Species.all().get(0).equals(species));
    }

    @Test
    public void find_retrievesAnObjectWithSimilarId(){
        Species speciesOne = new Species("Buffalo", 2000, false);
        speciesOne.save();
        Species speciesTwo = new Species("Antelope", 20000, false);
        speciesTwo.save();
        assertEquals(Species.find(speciesTwo.getId()), speciesTwo);
    }
}