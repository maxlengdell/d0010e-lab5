package simulator;
import supermarket.*;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
/**The main class that runs the simulation*/
public class RunSim {
    
//    So basically we get a generated time from the randomgen. This value is going to be passed to the respective event.
//    Example exponential has the random lambda generator. Event has to call this and get the value somehow?
//    Every ArrivalEvent is to generate the next arrival event as well. So arrival event has to call for exporandom

    //When we get the stop signal we set run to false!


/**
 * Executes the next event if there exist such a event. 
 * @param eq
 * @param S
 */
    public static void run(EventQueue eq, SuperMarket S){
        while(S.getisActive()){
            //get next event in queue and execute
            if (!eq.executeNext()) {
            	break;
            }
        }
    }
/**
 * Main method
 * @param args
 */
    public static void main(String[] args) {
        //Start simulation by calling for the arrival event -> will put in Eque and all will start
        //Create all objects for the constructors give supermarket EQ and give supermarket to EA
        EventQueue eq = new EventQueue();
        
        // SuperMarket(double time, boolean isActive, EventQueue eventQueue, double skill, int max, int cash, double timeopen)
        SuperMarket sm = new SuperMarket(0,true,eq, 1,7,2,8);
        sm.initRandGen(13,3,0.6,0.9,0.35,0.6);
        SuperMarketView smView = new SuperMarketView(sm);
        
        eq.addEvent(new EventOpen(sm, 0));
        double time = sm.getRnG().getRnGExponential();
        //sm.randgen(1234, 1, 0.5, 1.0);
        
        eq.addEvent(new EventArrival(time, sm));
        eq.addEvent(new EventClose(8, sm));
        eq.addEvent(new EventStop(999,sm));
        
        //now run eventQueue
        run(eq,sm);
        System.out.println("Resultat");
		System.out.println("=============");
		
		System.out.print("1); Av "+(sm.getcustomerIDCount()-1)+" kunder handlade " + sm.getDebitedCustomer()+" medans "+ sm.getMissedCustomer()+" missades.\n");
		
		System.out.print("\n2); Total tid " + sm.getcashRegister().length + " kassor varit lediga: ");
		System.out.printf("%.2f",sm.getFreeCashRegTime());
		System.out.print(". \nGenomsnittlig ledig kassatid: ");
		System.out.printf("%.2f",(sm.getFreeCashRegTime()/sm.getcashRegister().length));
		System.out.print(" te (dvs ");
		System.out.printf("%.2f",sm.getFreeCashRegTime()/sm.getcashRegister().length/sm.getLastCustomerDeparture()*100);
		System.out.print("% av tiden från öppning tills sista kunden betalat).\n");
		
		System.out.print("\n3); Total tid " + sm.getQueuedCustomer() + " kunder tvingats köa: ");
		System.out.printf("%.2f",  sm.getwaitedTime());
		System.out.print(".\nGenomsnittlig kötid: ");
		System.out.printf("%.2f",sm.getwaitedTime()/sm.getQueuedCustomer());
		System.out.print(" te.");


    }

}
