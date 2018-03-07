package supermarket;

import random.*;
/**This class creates a random run every time the program is runned*/
public class SuperMarketRandomGen {
	
	// Arrival = exp
	// Debiting = uni
	// Lambda = 4
	// uni 0.05 = 0.25
	
	private ExponentialRandomStream expRS; //Object that generates exponential random numbers
	private UniformRandomStream uniRSDeparture; //Object that generates uniform random numbers.
	private UniformRandomStream uniRSDebiting; //Object that genereates uniform random numbers.
	/**Describes the shape of the distribution curve*/
	public double lambda; 
	/**Random start value that initializes the random generator*/
	public long seed;
	/**Random uniform low value for when a depart event occurs*/
	public double uniLowerDeparture;
	/**Random uniform high value for when a depart event occurs*/
	public double uniUpperDeparture;
	/**Random uniform low value for when a debiting event occurs*/
	public double uniLowerDebiting;
	/**Random uniform high value for when a debiting event occurs*/
	public double uniUpperDebiting;
	/**
	 * Generates a random number with the following parameters.
	 * @param seed
	 * @param expLambda
	 * @param uniLowerDebiting
	 * @param uniUpperDebiting
	 * @param uniLowerDeparture
	 * @param uniUpperDeparture
	 */
	public SuperMarketRandomGen(long seed, double expLambda, double uniLowerDebiting, double uniUpperDebiting, double uniLowerDeparture, double uniUpperDeparture) {
		lambda = expLambda;
		this.seed = seed;
		this.uniLowerDebiting = uniLowerDebiting;
		this.uniUpperDebiting = uniUpperDebiting;
		this.uniLowerDeparture = uniLowerDeparture;
		this.uniUpperDeparture = uniUpperDeparture;
		expRS = new ExponentialRandomStream(expLambda, seed);
		uniRSDeparture = new UniformRandomStream(uniLowerDeparture, uniUpperDeparture, seed);
		uniRSDebiting = new UniformRandomStream(uniLowerDebiting, uniUpperDebiting, seed);
	}
	
		/**
		 * returns the a new departure RnG number
		 * @return
		 */
	public double getRnGUniformDeparture(){
		return uniRSDeparture.next();
		
	}
	/**
	 * returns a new debiting RnG number
	 * @return
	 */
	public double getRnGUniformDebiting(){
		return uniRSDebiting.next();
		
	}
	/**
	 * returns a new exponential RnG number.
	 * @return
	 */
	public double getRnGExponential(){
		return expRS.next();
	}
	

}
