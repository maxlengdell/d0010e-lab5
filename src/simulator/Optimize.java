package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import random.ExponentialRandomStream;
import supermarket.EventArrival;
import supermarket.EventClose;
import supermarket.EventOpen;
import supermarket.EventStop;
import supermarket.SuperMarket;
import supermarket.SuperMarketView;
import simulator.State;


public class Optimize {
	private static SuperMarket supermarket;
	
	
	public static void cashOpen(EventQueue eq, SuperMarket S) {
		for (int i = 0; i < 10; i++) {
			
			 while(S.getisActive()){
		            //get next event in queue and execute
		            if (!eq.executeNext()) {
		            	System.out.println("STOP!");
		            	break;
		            }
		        }
			//Måste jämföra minsta antalet missade kunder och publicera vilket som är mest lämpligt.
			// System.out.println(supermarket.amountOfFreeCashRegs());
		}
	}
	
//	private static void optimize() {
//		int temp;
//		temp = 
//	}
	public static void main(String[] args) {
        EventQueue eq = new EventQueue();
        
          SuperMarket sm = new SuperMarket(0,true,eq, 0.5,10,2,8.0);
     //   SuperMarketView smView = new SuperMarketView(sm);
        
        eq.addEvent(new EventOpen(sm, 0));
        double time = sm.getRnG().getRnGExponential();
        eq.addEvent(new EventArrival(time, sm));
        eq.addEvent(new EventClose(8, sm));
        eq.addEvent(new EventStop(999,sm));
        
        //now run eventQueue
        cashOpen(eq,sm);
	}
}
