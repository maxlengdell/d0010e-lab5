package supermarket;

import random.*;

public class SuperMarketRandomGen {
	
	// Arrival = exp
	// Debiting = uni
	// Lambda = 4
	// uni 0.05 = 0.25
	
	private ExponentialRandomStream expRS;
	private UniformRandomStream uniRS;
	
	public SuperMarketRandomGen(long seed, double expLambda, double uniLower, double uniUpper) {
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
