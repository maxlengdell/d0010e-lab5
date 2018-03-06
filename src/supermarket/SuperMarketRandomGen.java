package supermarket;

import random.*;

public class SuperMarketRandomGen {
	
	// Arrival = exp
	// Debiting = uni
	// Lambda = 4
	// uni 0.05 = 0.25
	
	private ExponentialRandomStream expRS;
	private UniformRandomStream uniRS;
	public double lambda;
	public long seed;
	public double uniLower;
	public double uniUpper;
	
	
	public SuperMarketRandomGen(long seed, double expLambda, double uniLower, double uniUpper) {
		lambda = expLambda;
		this.seed = seed;
		this.uniLower = uniLower;
		this.uniUpper = uniLower;
		expRS = new ExponentialRandomStream(expLambda, seed);
		uniRS = new UniformRandomStream(uniLower, uniUpper, seed);
	}
	
		
	public double getRnGUniform(){
		return uniRS.next();
		
	}
	public double getRnGExponential(){
		return expRS.next();
	}
	

}
