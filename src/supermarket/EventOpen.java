package supermarket;

import simulator.Event;
import supermarket.SuperMarket;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
/** This class describes the event that occurs when the simulation begins/the supermarket opens. */
public class EventOpen extends Event {
	double time;
	SuperMarket s;
	
/**The constructor for the class EventOpen. References are made to time of event and the state of the supermarket simulation when a
 * EventOpen object is created*/
/**
 * 
 * @param s
 * @param time
 */
	public EventOpen(SuperMarket s, double time){
		super(time,s);
		this.s=s;
		this.time=time;
	}
/**This method executes the event. The simulation begins and the store opens. The type of event is set and the state observers are notified*/
	public void execute() {
		s.updateTimeStatistics(0);
		s.changeOpenState(true);
		s.setEventCustomer(null);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
}
