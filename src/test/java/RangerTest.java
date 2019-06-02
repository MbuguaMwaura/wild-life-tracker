import org.junit.*;
import static org.junit.Assert.*;

public class RangerTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();

    @Test
    public void ranger_instantiatesCorrectly_true(){
        Ranger ranger = new Ranger ("John", 010);
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    public void ranger_instantiatedWithName(){
        Ranger ranger =  new Ranger ("John", 010);
        assertEquals("John", ranger.getName());
    }


    @Test
    public void equals_returnsTrueIfObjectsAreEquals(){
        Ranger ranger =  new Ranger ("John", 010);
        Ranger rangertwo =  new Ranger ("John", 010);
        assertTrue(ranger.equals(rangertwo));
    }

    @Test
    public void save_savesObjectIntoDatabase(){
        Ranger ranger =  new Ranger ("John", 010);
        ranger.save();
        assertEquals(true, Ranger.all().get(0).equals(ranger));
    }

    @Test
    public void all_retrievesAllInstancesFromTheDatabase(){
        Ranger ranger =  new Ranger ("John", 010);
        ranger.save();
        Ranger rangerTwo =  new Ranger ("Jane", 030);
        rangerTwo.save();
        assertTrue(Ranger.all().get(0).equals(ranger));
        assertTrue(Ranger.all().get(1).equals(rangerTwo));

    }

    @Test
    public void find_retrievesASpecificRangerUsingItsId(){
        Ranger ranger =  new Ranger ("John", 010);
        ranger.save();
        Ranger rangerTwo =  new Ranger ("Jane", 030);
        rangerTwo.save();
        assertEquals(rangerTwo.getName(), Ranger.find(rangerTwo.getId()).getName());
    }

    @Test
    public void update_updatesAnRangerDetails(){
        Ranger ranger =  new Ranger ("John", 010);
        ranger.save();
        ranger.update("Jane", 030);
        assertEquals("Jane", Ranger.find(ranger.getId()).getName());
    }


}