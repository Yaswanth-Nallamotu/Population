/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Yaswanth Nallamotu
 *	@since	1/16/2023
 */

public class City implements Comparable<City> {
	
	// fields
	private String name; /// The City's name
	private String designation; /// The City's type
	private String state; /// The state that the City's in
	private int population; /// The City's population
	// constructor
	public City(String stateIn, String nameIn, String designationIn, int populationIn)
	{
		state = stateIn;
		name = nameIn;
		designation = designationIn;
		population = populationIn;
	}
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City otherCity)
	{
		if(this.getPopulation() != otherCity.getPopulation())
		{
			return this.getPopulation()- otherCity.getPopulation();
		}
		else if(!this.getState().equals(otherCity.getState()))
		{
			return this.getState().compareTo(otherCity.getState());
		}
		else
		{
			return this.getName().compareTo(otherCity.getName());
		}
	}
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	public boolean equals(City otherCity)
	{
		return (this.getName().equals(otherCity.getName()) && 
			this.getState().equals(otherCity.getState()));
	}
	/**	Accessor methods */
	public int getPopulation() /// @return population(the city's population)
	{
		return population;
	}
	public String getState() /// @return state(the state the city belongs to)
	{
		return state;
	}
	public String getName() /// @ return name(the city's name)
	{
		return name;
	}
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
	
}
