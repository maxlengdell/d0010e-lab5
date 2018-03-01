
package random;

import java.util.Random;

import supermarket.SuperMarketRandomGen;


public class UniformRandomStream extends SuperMarketRandomGen {

	private Random rand;
	private double lower, width;
	
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper-lower;
	}
	
	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
	    this.lower = lower;
	    this.width = upper-lower;
	}
	
	public double next() {
	    return lower+rand.nextDouble()*width;
	}
}
