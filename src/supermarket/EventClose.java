package supermarket;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import simulator.Event;
/**This class decribes the event that ouccurs when the supermarket closes*/
public class EventClose extends Event {
	SuperMarket s;
	double time;
	/** Constructor for the class EventClos. References are made to time of event and the state of the supermarket simulation*/ 
	public EventClose(double time, SuperMarket s){
		super(time, s);
		this.s=s;
		this.time=time;
	}

/** This method executes the event. When this happens time of event is updated, the store is closed (s.changeOpenState(false) ),
 *the event type is set as the closing event and the state observers are notified*/
	public void Execute() {
		s.updateTimeStatistics(time);
		s.setEventCustomer(null);
		s.changeOpenState(false);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	
	}
}

	

