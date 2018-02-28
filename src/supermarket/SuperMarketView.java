package supermarket;

import simulator.View;

public class SuperMarketView extends View {
	
	SuperMarket superMarket;
	
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
		double time = superMarket.getTime();
		int customerId = superMarket.getCurrentEvent().getCustomerId(); 
		boolean isOpen = superMarket.getisOpen();
		
		
		Free	= Number of free registers
		FreeT	= total free register time
		I		= Number of customers in the shop
		$		= Number of customers that have paid
		Missed	= Number of missed customers
		QueuedTot= Total number of customer that has been in the queue
		QueueT	= Total queue time for all customers
		CurQueue= Number of customers in queue
		IdQueue	= The queue of customer with id
		
		Event eventType;
		switch  {
		case 0 :
			//stuff
			break;
		case 1 :
			//stuff
			break;
		case 2 :
			//stuff
			break;
		case 3 :
			//stuff
			break;
		case 4 :
			//stuff
			break;
			
		}
		
		
		
		System.out.println("Time\tEvent\tCustomer\tOpen?\tFree\tFreeT\tI\t$\tMissed\tQueueTot\tQueueT\tCurQueue\tIdQueue");
	}
}
