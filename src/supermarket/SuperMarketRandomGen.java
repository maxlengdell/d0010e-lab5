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
	
		
	public double getRnGUniformDeparture(){
		return uniRSDeparture.next();
		
	}
	public double getRnGUniformDebiting(){
		return uniRSDebiting.next();
		
	}
	public double getRnGExponential(){
		return expRS.next();
	}
	

}
