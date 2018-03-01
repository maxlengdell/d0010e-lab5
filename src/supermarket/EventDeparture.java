package supermarket;

import simulator.*;

public class EventDeparture extends Event {

	double time;
	SuperMarket s;
	Customer customer;
	
	public EventDeparture(double time, SuperMarket superMarket, Customer customer) {
		super(time);
		this.s = superMarket;
		this.customer = customer;
	}
	
	public void execute() {
		// update waited time
		// update free cash register time
		s.subCustomerAmount();
		s.addDebitedCount();
		if (s.getCustomerQueue().size()>0) {
			double debitingTime = time + s.getRandomTime();
			s.getEventQueue().addEvent(new EventDeparture(debitingTime, s, s.getCustomerQueue().getNextInQueue()));			
		}
		else {
			s.freeCashRegister();
		}		
		
		s.setTime(time);
		s.setCurrentEventType(this);
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