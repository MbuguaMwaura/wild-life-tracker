
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
}