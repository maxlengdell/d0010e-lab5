package supermarket;
import java.util.Observable;
import simulator.*;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/

/**Class that describes what will be visible in the print
 * of the supermarket simulation
 */
public class SuperMarketView extends View {
	
	SuperMarket s;
	
	// Event descriptions
	String open = new String("Open         ");
	String close = new String("Close        ");
	String arrival = new String("Arrival      ");
	String paytime = new String("Wishes to pay");
	String departure = new String("Departure    ");
	String error = new String("Unknown      ");
	String stop = new String("Stop");
	@SuppressWarnings("deprecation")
	/**
	 * Constructor for the class SuperMarketView with the
	 * following variables (creates a SuperMarket object s and adds an observer).
	 * @param s
	 */
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
		System.out.println("Parametrar:");
		System.out.println("=============");
		System.out.println("Antal kassor, N..........: " + s.getcashRegister().length);
		System.out.println("Max som ryms, M..........: " + s.getmaxCustomerAmount() );
		System.out.println("Ankomsthastighet, lamda..: " + s.getLamda());
		System.out.println("Plocktider, [P_min..PMax]:"+ s.getPlockTidLower()+"..."+s.getPlockTidUpper());
		System.out.println("Betaltider, [K_min..Kmax]:"+ s.getPayTimeLower()+"..."+s.getPayTimeUpper());
		System.out.println("Frön, f..................:"+ s.getSeed());
		System.out.println("Förlopp");
		System.out.println("========");
		System.out.println("Time\tEvent\t\tId\tOpen?\tFree\tFreeT\tI\t$\tMissed\tTotQ\tQueueT\tCurQ\tIdQueue");
	}

	/**
	 * Updates the different variables of SuperMarketView for 
	 * every time a new event occurs.
	 */
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
		else if (eventType == EventStop.class){
		    event = stop; // hehe
            System.out.println(time+"\tStop");
            return;

        }
		else {
			event = error;
		}
		System.out.printf("%.2f\t", time);
		System.out.print(event+"\t"+customerId+"\t"+isOpen+"\t"+free+"\t");
		System.out.printf("%.2f\t", freeT);
		System.out.print(currentCustAmount+"\t"+debited+"\t"+missed+"\t"+queuedTot+"\t");
		System.out.printf("%.2f\t", queueTime);
		System.out.print(curQueue+"\t[");

		
		Customer[] customerQueue = s.getCustomerQueue();
//		System.out.print(customerQueue.length + ", ");
				
		
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
