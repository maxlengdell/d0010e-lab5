package supermarket;

import java.util.Observable;

/**
*
* @author Shahin, Max, Johan, Linus
*
*/


import simulator.*;

public class SuperMarketView extends View {
	
	SuperMarket s;
	
	// Event descriptions
	String open = new String("Open                  ");
	String close = new String("Close                 ");
	String arrival = new String("Customer arrival      ");
	String paytime = new String("Customer wishes to pay");
	String departure = new String("Customer departure    ");
	String error = new String("Unknown               ");
	
	@SuppressWarnings("deprecation")
	public SuperMarketView(SuperMarket s) {
		this.s = s;
		s.addObserver(this);
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
		System.out.println("Time\tEvent\t\t\tCustomer\tOpen?\tFree\tFreeT\tI\t$\tMissed\tQueueTot\tQueueT\tCurQueue\tIdQueue");
	}

	
	public void update(Observable arg0, Object arg1) {
		double time = s.getTimeState();
		int customerId = s.getEventCustomerId();
		boolean isOpen = s.getisOpen();
		int free = s.amountOfFreeCashRegs();
		double freeT = s.getFreeCashRegTime();
		int currentCustAmount = s.getcurrentCustomerAmount();
		int debited = s.getDebitedCustomer();
		int missed	= s.getMissedCustomer();
		int queuedTot = s.getQueuedCustomer();
		double queueTime = s.getwaitedTime();
		int curQueue = s.customerAmountInQueue();

		String event;
		Class<?> eventType = s.getCurrentEventType();
				
		if (eventType == EventOpen.class) {
			event = open;
		}	
		else if (eventType == EventClose.class) {
			event = close;
		}
		else if (eventType == EventArrival.class) {
			event = arrival;
		}
		else if (eventType == EventDebiting.class) {
			event = paytime;
		}
		else if (eventType == EventDeparture.class) {
			event = departure;
		}
		else {
			event = error;
		}
		
		System.out.print(time+"\t"+event+"\t"+customerId+"\t"+isOpen+"\t"+free+"\t"+freeT+"\t"+currentCustAmount+"\t"+
		debited+"\t"+missed+"\t"+queuedTot+"\t"+queueTime+"\t"+curQueue+"\t[");
		
		Customer[] customerQueue = s.getCustomerQueue();
				
		
		for (int i = 0; i < customerQueue.length; i++) {
			if (customerQueue[i] == null) {
				System.out.println("]");
				break;
			}
			System.out.print(customerQueue[i].getID());
			if (customerQueue[i+1] != null) {
				System.out.print(", ");
			}
		}
		
		// TODO: Needs to print the current queue of customers, depends on implementation of FIFO
	}
}
