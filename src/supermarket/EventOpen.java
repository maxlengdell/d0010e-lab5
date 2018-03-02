package supermarket;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import simulator.Event;
import supermarket.SuperMarket;
/** This class describes the event that occurs when the simulation begins/the supermarket opens. */
public class EventOpen extends Event {
	double time;
	SuperMarket s;
	
/**The constructor for the class EventOpen. References are made to time of event and the state of the supermarket simulation*/
	public EventOpen(SuperMarket s, double time){
		super(time,s);
		this.s=s;
		this.time=time;
	}
/**This method executes the event. The simulation begins and the store opens. The type of event is set and the state observers are notified*/
	public void Execute() {
		s.updateTimeStatistics(0);
		s.changeOpenState(true);
		s.setEventCustomer(null);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
}
