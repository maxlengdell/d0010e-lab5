package supermarket;

import com.sun.jdi.event.EventQueue;

import simulator.*;

public class EventArrival extends Event {

	private SuperMarket s;
	private Customer customer;
	private double time;

	
	public EventArrival(double time, SuperMarket superMarket) {
		super(time);
		this.s = superMarket;
		
		
	}



	public void execute() {
		Customer customer = new Customer(s.nextCustomerId(), s.getTimeState());
		
		if (s.getisOpen()) {
			if (s.getcurrentCustomerAmount()<s.getmaxCustomerAmount()) {
				s.addCustomerAmount();
				
				double nextTime = time + s.getRandomTime();
				s.getEventQueue().addEvent(new ArrivalEvent())  arrivalevent			
			
			}
			else {
				s.addMissedCustomer();
			}
		}
		else {
			
		}
		s.notify();
		
	}


	public void Arrives() {
		 
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

	}


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