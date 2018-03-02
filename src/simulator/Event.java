package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/

public abstract class Event {
	
	private double time;
	private State state;
	
	public Event(double time, State state) { //Perhaps more parameters?
		
		this.time = time; //Sort the events by time.
		this.state = state;
	}

	public double getTime() {
		return time;
	}
	public State getState() {
		return state;
	}
	public void execute() {
		
	}

}
