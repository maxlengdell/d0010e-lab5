package supermarket;

import simulator.*;
/**This class describes the event that occurs when a customer is leaving the store*/
public class EventDeparture extends Event {

	double time;
	SuperMarket s;
	Customer customer;
/**The constructor for the class EventDeparture. References are made to the time of the event, the state of the supermarket simulation and the customer */
	public EventDeparture(double time, SuperMarket superMarket, Customer customer) {
		super(time, superMarket);
		this.time=time;
		this.s = superMarket;
		this.customer = customer;
	}
/**This method executes the event. A customer leaves and the stats are updated.*/
	public void Execute() {
		s.updateTimeStatistics(time);
		
		s.subCurrentCustomerAmount();
		s.addDebitedCustomer();
		Customer nextCustomer = s.takeFirstCustomerFromQueue();
		if (nextCustomer != null) {
			double debitingTime = time + s.getRnG().getRnGUniform();
			s.getEventQueue().addEvent(new EventDeparture(debitingTime, s, nextCustomer));			
		}
		else {
			s.freeCashRegister();
		}		
		
		s.setTimeState(time);
		s.setEventType(this.getClass());
		s.setEventCustomer(customer);
		s.notifyStateObs();
	}

}

/*
public void custExit() { // CUSTOMER LEAVES STORE
	//Get a timestamp of when the customer leaves the store
	customer.custExit(time);


}


public void custLeaveQueue() {
		customer.exitQue(time);
		//Här måste vi antingen ändra så några variabler i SuperMarket blir publika eller skapa dubla metoder så man kan ändra
		//T.ex antalet studenter i butiken osv eftersom detta är event-styrt.

	}

*/