package simulator;
import supermarket.Customer;
import supermarket.SuperMarket;
/**
 * 
 * GLÖM EJ NOTIFYOBSERVERS!
 *
 */

public class Event {

	double time = 100;
	private SuperMarket supermarket;
	private Customer customer;
	public void Event() {


	}
	public void open() {
		//Open shop and lets customers in. 
		supermarket.changeState(true);

	}
	public void close() {
		//Reject customers from entering the shop. Let customers already in the shop finish their shopping. 
		supermarket.changeState(false);
	}
	public void custArrives() {
		//Initierar (check)
		//Skapar id för kunden. (check)
		//customer creates new object  to customer. (check)
		//Puts the customer in the "shopping" list
		int id = 0;
		Customer customer = new Customer(id, time);
		id++;
		

	}//Customer finished shopping. 
	public void custEnterQueue() {
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
		customer.enterQue(time);
		supermarket.addQueue(id);//Need to add customer to the queue. 
	}
	public void custExit() { // CUSTOMER LEAVES STORE
		//Get a timestamp of when the customer leaves the store
		customer.custExit(time);


	}public void custLeaveQueue() {
		customer.exitQue(time);
		//Här måste vi antingen ändra så några variabler i SuperMarket blir publika eller skapa dubla metoder så man kan ändra
		//T.ex antalet studenter i butiken osv eftersom detta är event-styrt.

	}

}
