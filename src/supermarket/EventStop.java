package supermarket;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import simulator.Event;
/** This class describes the event that occurs when the supermarket simulation stops/ends*/
public class EventStop extends Event {
	SuperMarket s;
	double time;
/** The constructor for the class EventStop, References are made to time of event and the state of the supermarket simulation*/
	public EventStop(double time, SuperMarket s) {
		super(time, s);
		this.s=s;
		this.time=time; //stop at 1000
		
	}
	/** This method executes the event. The simulation is no longer active/running, time is updated, the type of event is set and the
	 * state observers are notified*/
	public void Execute(){
		s.updateTimeStatistics(time);
		s.changeisActive(false);
		s.setEventCustomer(null);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
	
}
