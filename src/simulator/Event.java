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
		//Initierar
		//Skapar id för kunden. 
		//customer creates new object  to customer. Waiting for method name.
		//Takes two arguments. 
		int id = 0;
		Customer customer = new Customer(id, time);
		id++;
		

	}//Customer finished shopping. 
	public void custEnterQueue() {
		//Calls method in customer. The time that is returned 
		//customerExit returns time units the customer has been in queue. 
		customer.enterQue(time);
	}
	public void custExit() { // CUSTOMER LEAVES STORE
		//Get a timestamp of when the customer leaves the store
		customer.custExit(time);


	}public void custLeaveQueue() {
		customer.exitQue(time);

	}

}
