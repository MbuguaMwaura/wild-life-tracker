


public class Species{
    private String name;
    private int population;
    private boolean endangered;

    public Species(String name, int population, boolean endangered){
        this.name = name;
        this.population = population;
        this.endangered = endangered;
    }

    public String getName(){
        return name;
    }

    public int getPopulation(){
        return population;
    }
    public boolean isEndangered(){
        return endangered;
    }
}