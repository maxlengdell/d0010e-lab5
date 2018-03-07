package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/

public abstract class Event {
	
	private double time;
	private State state;
	/**Constructor for the class Event. A time of event and a state of event is assigned when a event object is created
	 * 
	 * @param time
	 * @param state
	 */
	public Event(double time, State state) { //Perhaps more parameters?
		
		this.time = time; //Sort the events by time.
		this.state = state;
	}
	/**This method returns the time
	 * 
	 * @return
	 */
	
	public double getTime() {
		return time;
	}
	/**This method returns the state/what kind of event it is
	 * 
	 * @return
	 */
	
	public State getState() {
		return state;
	}
	/**This method runs an event*/
	public void execute() {
		
	}

}
