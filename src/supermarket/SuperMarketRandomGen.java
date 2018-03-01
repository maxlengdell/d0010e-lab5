package supermarket;

import random.ExponentialRandomStream;
import random.UniformRandomStream;

public class SuperMarketRandomGen {
	
	public ExponentialRandomStream getExponentialRandomStream(){
		return new ExponentialRandomStream(15);
	}
	public UniformRandomStream getUniformRandomStream(){
		return new UniformRandomStream(0, 0);
	}
	

}
