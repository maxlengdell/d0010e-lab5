package simulator;
import supermarket.Customer;
import supermarket.SuperMarket;
import simulator.EventQueue;
/**
 * 
 * GLÖM EJ NOTIFYOBSERVERS!
 *
 */

public class Event {
	
	double time = 0;//*********** TID SKA SKAPAS*********** ENDAST FÖR ATT SLIPPA FEL
	private SuperMarket supermarket;
	private Customer customer;

	public Event(Customer customer, double time) { //Perhaps more parameters?
		//Sort the events by time.
		this.time = time;
		this.customer = customer;
	}

	

}
