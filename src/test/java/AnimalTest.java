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
    @Test
    public void equals_returnsTrueIfObjectsAreEquals(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        Animal animaltwo =  new Animal ("Jaguar", 1, "newborn","healthy");
        assertTrue(animal.equals(animaltwo));
    }

    @Test
    public void save_savesObjectIntoDatabase(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        animal.save();
        assertEquals(true, Animal.all().get(0).equals(animal));
    }

    @Test
    public void all_retrievesAllInstancesFromTheDatabase(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        animal.save();
        Animal animalTwo =  new Animal ("Leopard", 1, "adult","healthy");
        animalTwo.save();
        assertTrue(Animal.all().get(0).equals(animal));
        assertTrue(Animal.all().get(1).equals(animalTwo));

    }

    @Test
    public void find_retrievesASpecificAnimalUsingItsId(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        animal.save();
        Animal animalTwo =  new Animal ("Leopard", 1, "adult","healthy");
        animalTwo.save();
        assertEquals(animalTwo.getName(), Animal.find(animalTwo.getId()).getName());
    }

    @Test
    public void update_updatesAnAnimalDetails(){
        Animal animal =  new Animal ("Jaguar", 1, "newborn","healthy");
        animal.save();
        animal.update("adult","healthy");
        assertEquals("adult", Animal.find(animal.getId()).getAge());
    }


}