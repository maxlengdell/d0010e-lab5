package supermarket;

import random.*;

public class SuperMarketRandomGen {
	
	// Arrival = exp
	// Debiting = uni
	// Lambda = 4
	// uni 0.05 = 0.25
	
	private ExponentialRandomStream expRS;
	private UniformRandomStream uniRSDeparture;
	private UniformRandomStream uniRSDebiting;
	public double lambda;
	public long seed;
	public double uniLowerDeparture;
	public double uniUpperDeparture;
	public double uniLowerDebiting;
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
