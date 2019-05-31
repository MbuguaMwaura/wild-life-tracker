


public class Species{
    private String name;
    private int population;

    public Species(String name, int population, boolean endangered){
        this.name = name;
        this.population = population;
    }

    public String getName(){
        return name;
    }

    public int getPopulation(){
        return population;
    }
}