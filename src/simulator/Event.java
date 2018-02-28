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
	
	int Start = 1;
//	int customerArrival = 2;
//	int customerShopping = 3;
//	int customerPayment = 4;
//	int Close = 0;
	int eventType;
	

	double time = 100;//*********** TID SKA SKAPAS*********** ENDAST FÖR ATT SLIPPA FEL
	private SuperMarket supermarket;
	private Customer customer;

	public Event(int id, double time) { //Perhaps more parameters?
		//Sort the events by time.
		
	}
	
	public int getEventType() {
		return eventType;
		
	}
		//Variabel för customer till customer. 
	
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
		if (supermarket.getisOpen()) {
			int id = 0;
			Customer customer = new Customer(id, time);
			id++;
		} else if (!(supermarket.getisOpen())) {
			//Missad kund! add counter??
		}
		
		

	}//Customer finished shopping. 
	public void custTriesToPurchase() {
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
		if(supermarket.cashRegStatus()) {//if cashregister is free. Execute this. 
			
			//Place customer in the cashregister. 
		
		}else if (!(supermarket.cashRegStatus())
				) {//If the register is allocated and returns false. Place customer in queue. 
			customer.enterQue(time);
			supermarket.addQueue(id);
			
		}
		
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
