package supermarket;

import simulator.View;

import java.util.ArrayList;
import java.util.stream.*;

public class SuperMarketView extends View {
	
	SuperMarket superMarket;
	
	// Event descriptions
	String open = new String("Open");
	String close = new String("Close");
	String arrival = new String("Customer arrival");
	String paytime = new String("Customer wishes to pay");
	String departure = new String("Customer departure");
	String error = new String("Error");
	
	public SuperMarketView(SuperMarket superMarket) {
		this.superMarket = superMarket;
		/*
		Tid			Time 	= Time of event
		Händelse	Event 	= Type of event
		Kund		Customer= Id of customer
		?			Open?	= Is the store open
		led			Free	= Number of free registers
		ledt		FreeT	= total free register time
		I 			I		= Number of customers in the shop
		$			$		= Number of customers that have paid
		:-(			Missed	= Number of missed customers
		koat		QueuedTot= Total number of customer that has been in the queue
		koT			QueueT	= Total queue time for all customers
		koar		CurQueue= Number of customers in queue
		kassako		IdQueue	= The queue of customer with id
		*/
		System.out.println("Time\tEvent\tCustomer\tOpen?\tFree\tFreeT\tI\t$\tMissed\tQueueTot\tQueueT\tCurQueue\tIdQueue");
	}
	
	public void update() {
		double time = superMarket.getTimeState()
		int customerId = superMarket.getCurrentEvent().getCustomer().getId();  // TODO: placeholder method 
		boolean isOpen = superMarket.getisOpen();
		int free = IntStream.of(superMarket.getcashRegister()).sum();
		double freeT = superMarket.getFreeCashRegTime();
		int currentCustAmount = superMarket.getcurrentCustomerAmount();
		int debited = superMarket.getdebitedCustomer();
		int missed	= superMarket.getMissedCustomer();
		int queuedTot = superMarket.getQueuedTot();			// TODO: placeholder method
		double queueTime = superMarket.getwaitedTime();
		int curQueue = superMarket.getCustomerQueue().size();		
		ArrayList <Customer> queueList	= superMarket.getCustomerQueue();
		String event;
		int eventType = superMarket.getCurrentEvent().getEventType();
		switch(eventType) {
		case 0 :
			event = open;
			break;
		case 1 :
			event = close;
			break;
		case 2 :
			event = arrival;
			break;
		case 3 :
			event = paytime;
			break;
		case 4 :
			event = departure;
			break;
		default :
			event = error;
			
		}
		System.out.println(time+"\t"+event+"\t"+customerId+"\t"+isOpen+"\t"+free+"\t"+freeT+"\t"+currentCustAmount+"\t"+
		debited+"\t"+missed+"\t"+queuedTot+"\t"+queueTime+"\t"+curQueue+"\t");
		
		// TODO: Needs to print the current queue of customers, depends on implementation of FIFO
	}
}
