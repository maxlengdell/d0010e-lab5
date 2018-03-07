package supermarket;
import simulator.*;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
/**Class that describes the arrival event (customer arrives in supermarket)*/
public class EventArrival extends Event {

	private SuperMarket s;
	private Customer customer;
	private double time;

/**
 * Constructor for the class EventArrival with the following
 * parameters.	
 * @param time
 * @param superMarket
 */
	public EventArrival(double time, SuperMarket superMarket) {
		super(time, superMarket);
		this.s = superMarket;
		this.time = time;
	}

	/**
	 * Creates a new arriving customer and checks if this new customer can enter the supermarket.
	 * Then it updates the appropriate state variables and creates a payment event if the customer could enter.
	 * It also creates the next arrival event if the shop is still open.
	 */
	public void execute() {
		Customer customer = new Customer(s.nextCustomerId(), s.getTimeState());
		s.updateTimeStatistics(time);
		
		if (s.getisOpen()) {
			if (s.getcurrentCustomerAmount()<s.getmaxCustomerAmount()) {
				s.addCurrentCustomerAmount();
				
				double debitingTime = this.time + s.getRnG().getRnGUniformDebiting();
				s.getEventQueue().addEvent(new EventDebiting(debitingTime, s, customer));
			}
			else {
				s.addMissedCustomer();
			}
			double nextArrivalTime = this.time + s.getRnG().getRnGExponential();
			s.getEventQueue().addEvent(new EventArrival(nextArrivalTime, s));
		}
		else {
			
		}
		s.setTimeState(this.time);
		s.setEventType(this.getClass());
		s.setEventCustomer(customer);
		
		s.notifyStateObs();		
	}
}