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

import java.util.ArrayList;

//hitta minsta antalet kassor som också kan ge minst missade kunder

public class Optimize {
	private static SuperMarket supermarket;
	private static int max =10;
	private static int cash =1;
	private static double time=8.0;
    //randomgen variables
    private static int SEED;
    private static int lambda;
    private static double uLow;
    private static double uUp;
    private static int min=0;
    private static ArrayList<Integer> missedcust = new ArrayList<>();


    //gonna test max of 10 and time of 8 and see what minimum amount of cashiers to lost customers is.
	
	
	public static void cashOpen() {

<<<<<<< HEAD
		for (int i = 0; i < 10; i++) {
		    //randgen variables
            SEED = 5;
            //only seed change other stay the same
            lambda=6;
            uLow=0.05;
            uUp=0.4;
            //add cashiers to max

            if(cash<max-1){
                cash++;
            }


=======
		for (int i = 0; i < 5; i++) {
		    //dont need ++ can use + 0.5 or whatever is appropriate.
		    //max++;
		    cash++;
		    time = 8;
>>>>>>> d7849a9f0cfa9a64c67aac37fef05994ff79391f
            System.out.println("\n--------------------------------");
            System.out.print("Maxcust: "+max+"\tCashregs: "+cash+"\tTimeopen: "+time);
		    //change multiple scenarios
            EventQueue eq = new EventQueue();

            SuperMarket sm = new SuperMarket(0,true,eq, 0.5,max,cash,time);
            SuperMarketView smView = new SuperMarketView(sm);

            eq.addEvent(new EventOpen(sm, 0));
            //double time = sm.getRnG().getRnGExponential(); Changed to method in sm and we can change vals from here
            //give wanted values for simulation
            sm.randgen(SEED,lambda,uLow,uUp);
            eq.addEvent(new EventArrival(0, sm));
            eq.addEvent(new EventClose(8, sm));
            eq.addEvent(new EventStop(999,sm));
            //individual sim run
			 while(sm.getisActive()){
                 //get next event in queue and execute
		            if (!eq.executeNext()) {
                        System.out.println("\nWaited time: "+sm.getwaitedTime());
                        System.out.println("Missed customer: "+sm.getMissedCustomer());
                        System.out.println("Idle cashregTime: "+sm.getFreeCashRegTime());
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
	    /*
        EventQueue eq = new EventQueue();
        
          SuperMarket sm = new SuperMarket(0,true,eq, 0.5,10,2,8.0);
     //   SuperMarketView smView = new SuperMarketView(sm);
        
        eq.addEvent(new EventOpen(sm, 0));
        double time = sm.getRnG().getRnGExponential();
        eq.addEvent(new EventArrival(time, sm));
        eq.addEvent(new EventClose(8, sm));
        eq.addEvent(new EventStop(999,sm));
        */
        //now run eventQueue
        cashOpen();
	}
}
