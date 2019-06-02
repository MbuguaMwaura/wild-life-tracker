import org.junit.*;
import static org.junit.Assert.*;

public class LocationTest{

    @Rule
    public DataBaseRule dataBaseRule = new DataBaseRule();

    @Test
    public void location_instantiatesCorrectly_true(){
        Location location = new Location ("Zone A");
        assertTrue(location instanceof Location);
    }

    @Test
    public void location_instantiatedWithName(){
        Location location =  new Location ("Zone A");
        assertEquals("Zone A", location.getName());
    }


    @Test
    public void equals_returnsTrueIfObjectsAreEquals(){
        Location location =  new Location ("Zone A");
        Location locationtwo =  new Location ("Zone A");
        assertTrue(location.equals(locationtwo));
    }

    @Test
    public void save_savesObjectIntoDatabase(){
        Location location =  new Location ("Zone A");
        location.save();
        assertEquals(true, Location.all().get(0).equals(location));
    }

    @Test
    public void all_retrievesAllInstancesFromTheDatabase(){
        Location location =  new Location ("Zone A");
        location.save();
        Location locationTwo =  new Location ("Zone C");
        locationTwo.save();
        assertTrue(Location.all().get(0).equals(location));
        assertTrue(Location.all().get(1).equals(locationTwo));

    }

    @Test
    public void find_retrievesASpecificLocationUsingItsId(){
        Location location =  new Location ("Zone A");
        location.save();
        Location locationTwo =  new Location ("Zone C");
        locationTwo.save();
        assertEquals(locationTwo.getName(), Location.find(locationTwo.getId()).getName());
    }

    @Test
    public void update_updatesAnLocationDetails(){
        Location location =  new Location ("Zone A");
        location.save();
        location.update("Zone C");
        assertEquals("Zone C", Location.find(location.getId()).getName());
    }


}