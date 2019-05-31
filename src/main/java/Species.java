


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

    @Override
    public boolean equals(Object otherSpecies){
        if(!(otherSpecies instanceof Species)){
            return false;
        } else {
            Species species = (Species) otherSpecies;
            return this.getName().equals(species.getName()) &&
                    this.getPopulation() == species.getPopulation() &&
                    this.isEndangered() == species.isEndangered();

        }
    }
}