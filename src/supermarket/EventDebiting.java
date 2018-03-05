package supermarket;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import simulator.Event;
import simulator.State;
import supermarket.SuperMarket;
/** This class describes the event the occurs when a customer goes to the cash register and starts paying */
public class EventDebiting extends Event {
	double time;
	SuperMarket s;
	Customer c;
	/**The constructor for the class EventDebiting. References are made to time of event, state of the supermarket simulation and the customer/customers when a 
	 * EventDebiting object is created.*/
	/**
	 * 
	 * @param time
	 * @param s
	 * @param c
	 */
	public EventDebiting(double time, SuperMarket s, Customer c){
		super(time,s);
		this.s=s;
		this.c=c;
		this.time=time;
	}
	/** This method executes the event. If a customer goes to a free cash register or is first in the cash register line, the pay process begins and the next event (see class EventDeparture) will occur.
	 * The type of event is set and the state observers are notified of the event.
	 *  
	 */
	public void execute() {
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
		s.updateTimeStatistics(time);
		if(s.cashRegStatus()==true) {//if cashregister is free. Execute this. 
			
			double departureTime=time+s.getRnG().getRnGUniform()/s.getSkill();
			s.getEventQueue().addEvent(new EventDeparture(departureTime, s, c));
			s.takeCashRegister();
			//Place customer in the cashregister. 
		
		}
		else { //if cashregister is occupied. Execute this.
			s.addCustomerToQueue(c);
			s.addQueuedCustomer();
		}
		s.setTimeState(time);
		s.setEventCustomer(c);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
}
