package supermarket;

/**
*
* @author Shahin, Max, Johan, Linus
*
*/


import simulator.*;
import supermarket.*;

import java.util.ArrayList;
import java.util.stream.*;

public class SuperMarketView extends View {
	
	SuperMarket s;
	
	// Event descriptions
	String open = new String("Open");
	String close = new String("Close");
	String arrival = new String("Customer arrival");
	String paytime = new String("Customer wishes to pay");
	String departure = new String("Customer departure");
	String error = new String("Error");
	
	public SuperMarketView(SuperMarket superMarket) {
		this.s = superMarket;
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
		double time = s.getTimeState();
		int customerId = s.getCurrentEvent().getCustomer().getId();  // TODO: placeholder method 
		boolean isOpen = s.getisOpen();
		int free = IntStream.of(s.getcashRegister()).sum();
		double freeT = s.getFreeCashRegTime();
		int currentCustAmount = s.getcurrentCustomerAmount();
		int debited = s.getdebitedCustomer();
		int missed	= s.getMissedCustomer();
		int queuedTot = s.getQueuedTot();			// TODO: placeholder method
		double queueTime = s.getwaitedTime();
		int curQueue = s.getCustomerQueue().size();		
		ArrayList <Customer> queueList	= s.getCustomerQueue();
		String event;
		int eventType = s.getCurrentEvent().getEventType();
		switch(s.getCurrentEvent().getClass()) {
		case EventOpen.class :
			event = open;
			break;
		case EventClose.class :
			event = close;
			break;
		case EventArrival.class :
			event = arrival;
			break;
		case EventDebiting.class :
			event = paytime;
			break;
		case EventDeparture.class :
			event = departure;
			break;
		default :
			event = error;
			
		}
		System.out.print(time+"\t"+event+"\t"+customerId+"\t"+isOpen+"\t"+free+"\t"+freeT+"\t"+currentCustAmount+"\t"+
		debited+"\t"+missed+"\t"+queuedTot+"\t"+queueTime+"\t"+curQueue+"\t[");
		
		int[] queueId = s.getQueueIdArray();
		
		for (int i = 0; i < queueId.length; i++) {
			System.out.print(queueId[i]);
			if (i< queueId.length-1) {
				System.out.print(", ");
			}
			else {
				System.out.println("]");
			}
		}
		
		// TODO: Needs to print the current queue of customers, depends on implementation of FIFO
	}
}
