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
	/** Constructor for the class EventClose. References are made to time of event and the state of the supermarket simulation*/ 
	public EventClose(double time, SuperMarket s){
		super(time, s);
		this.s=s;
		this.time=time;
	}

/** This method executes the event. The store is closed and the stop simulation event will occur afterwards*/
	public void Execute() {
		s.updateTimeStatistics(time);
		s.setEventCustomer(null);
		s.changeOpenState(false);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	
	}
}

	

