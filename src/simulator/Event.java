package simulator;
/**
 * 
 * GLÖM EJ NOTIFYOBSERVERS!
 *
 */

public abstract class Event {
	
	private double time;
	
	public Event(double time, state) { //Perhaps more parameters?
		
		this.time = time; //Sort the events by time.
		this.state = state;
	}

	public double getTime() {
		return time;
	}
	public State getState() {
		return state;
	}
	public void Execute() {
		
	}

}
