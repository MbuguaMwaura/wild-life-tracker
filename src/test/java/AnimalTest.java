import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();

    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = new Animal ("Jaguar", 1, "newborn","healthy");
        assertTrue(animal instanceof Animal);
    }

    @Test
    public void animal_instantiatedWithName(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        assertEquals("Jaguar", animal.getName());
    }

    @Test
    public void animal_instantiatesWithSpecies_id(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        assertEquals(1, animal.getSpecies_id());
    }

    @Test
    public void animal_instantiatesWithAge(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        assertEquals("newborn", animal.getAge());
    }
    @Test
    public void animal_instantiatesWithHealth(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        assertEquals("healthy", animal.getHealth());
    }


}