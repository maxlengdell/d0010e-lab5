package supermarket;

import simulator.*;
/**This class describes the event that occurs when a customer is leaving the store*/
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
public class EventDeparture extends Event {

	double time;
	SuperMarket s;
	Customer customer;
/**Constructor for the class EventDeparture
 * with the following parameters.
 * @param time
 * @param superMarket
 * @param customer
 */
	public EventDeparture(double time, SuperMarket superMarket, Customer customer) {
		super(time, superMarket);
		this.time=time;
		this.s = superMarket;
		this.customer = customer;
	}
/**This method executes the event. A customer leaves and the stats are updated.*/
	public void execute() {
		s.updateTimeStatistics(time);
		s.subCurrentCustomerAmount();
		s.addDebitedCustomer();
		Customer nextCustomer = s.takeFirstCustomerFromQueue();
		if (nextCustomer != null) {
			double debitingTime = time + s.getRnG().getRnGUniformDeparture();
			s.getEventQueue().addEvent(new EventDeparture(debitingTime, s, nextCustomer));			
		}
		else {
			s.freeCashRegister();
		}			
		s.setTimeState(time);
		s.setLastCustomerDeparture(time);
		s.setEventType(this.getClass());
		s.setEventCustomer(customer);
		s.notifyStateObs();
	}

}