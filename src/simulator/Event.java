package simulator;
import supermarket.Customer;
import supermarket.SuperMarket;

public class Event {
	
	
	private SuperMarket supermarket;
	public void hello() {
		
		
	}
	public void open() {
		//Open shop and lets customers in. 
		
	}
	public void close() {
		//Reject customers from entering the shop. Let customers already in the shop finish their shopping. 
	}
	public void custArrives() {
		//Initierar
		//Skapar id för kunden. 
		//customer creates new object  to customer. Waiting for method name.
		//Takes two arguments. 
		double time = 100;
		for (int id = 0; id <= supermarket.getcurrentCustomerAmount(); id++) {
			Customer customer = new Customer(id, time);
			id++;
		}
		 // Tar det senare
		 // Tar det senare	
		
		
	}
	public void custEnterQueue() {
		//Calls method in customer. The time that is returned 
		//customerExit returns time units the customer has been in queue. 
		
	}
	public void custLeaves() {
		//Get a timestamp of when the customer leaves.
		
	}public void custLeaveQueue() {
		
	}

}
