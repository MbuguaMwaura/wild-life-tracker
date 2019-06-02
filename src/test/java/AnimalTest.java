import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();

    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = new Animal ("Jaguar", 1);
        assertTrue(animal instanceof Animal);
    }

    @Test
    public void animal_instantiatedWithName(){
        Animal animal =  new Animal ("Jaguar", 1);
        assertEquals("Jaguar", animal.getName());
    }

    @Test
    public void animal_instantiatesWithSpecies_id(){
        Animal animal =  new Animal ("Jaguar", 1);
        assertEquals(1, animal.getSpecies_id());
    }

}