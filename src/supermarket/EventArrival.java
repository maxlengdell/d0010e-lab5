package supermarket;

import simulator.*;

public class EventArrival extends Event {

	private SuperMarket s;
	private Customer customer;
	private double time;

	
	public EventArrival(double time, SuperMarket superMarket) {
		super(time, superMarket);
		this.s = superMarket;
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
				
				double debitingTime = time + s.getRandomPickingTime();
				s.getEventQueue().addEvent(new EventDebiting(debitingTime, s, customer));
			}
			else {
				s.addMissedCustomer();
			}
			double nextArrivalTime = time + s.getRandomTime();
			s.getEventQueue().addEvent(new EventArrival(nextArrivalTime, s));
		}
		else {
			
		}
		s.setTimeState(time);
		s.setEventType(this.getClass());
		s.setEventCustomer(customer);
		
		s.notifyStateObs();
		
	}

/*
	public void Arrives() {
		 
		//Initierar (check)
		//Skapar id för kunden. (check)
		//customer creates new object  to customer. (check)
		//Puts the customer in the "shopping" list
		if (s.getisOpen()) {
			int id = 0;
			Customer customer = new Customer(id, time);
			id++;
		} else if (!(supermarket.getisOpen())) {
			//Missad kund! add counter??
		}

	}
*/

}

/*
public void custArrives() {
//Initierar (check)
//Skapar id för kunden. (check)
//customer creates new object  to customer. (check)
//Puts the customer in the "shopping" list
if (supermarket.getisOpen()) {
	int id = 0;
	Customer customer = new Customer(id, time);
	id++;
} else if (!(supermarket.getisOpen())) {
	//Missad kund! add counter??
}
*/