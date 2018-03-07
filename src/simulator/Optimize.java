
package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import com.sun.org.apache.xpath.internal.SourceTree;
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
    private static int min=9999;
    private static int simulations=10;
    private static SuperMarket minobj;
    private static ArrayList<SuperMarket> missedcust = new ArrayList<>();


    //gonna test max of 10 and time of 8 and see what minimum amount of cashiers to lost customers is.
	


    public static void firstmethod(int cashregs){

        EventQueue eq = new EventQueue();
        SuperMarket sm = new SuperMarket(0,true,eq, 0.5,max,cashregs,time);


        SuperMarketView smView = new SuperMarketView(sm);
        eq.addEvent(new EventOpen(sm, 0));
        //double time = sm.getRnG().getRnGExponential(); Changed to method in sm and we can change vals from here
        //give wanted values for simulation
        sm.randgen(SEED,lambda,uLow,uUp);
        eq.addEvent(new EventArrival(0, sm));
        eq.addEvent(new EventClose(8, sm));
        eq.addEvent(new EventStop(999,sm));
        while(sm.getisActive()){
            //get next event in queue and execute
            if (!eq.executeNext()) {
                break;
            }
        }
        System.out.println("Resultat");
        System.out.println("=============");

        System.out.print("1); Av "+sm.getmaxCustomerAmount()+" kuser handlade " + sm.getDebitedCustomer()+" medans "+ sm.getMissedCustomer()+" missades.\n");

        System.out.print("\n2); Total tid " + sm.getcashRegister().length + " kassor varit lediga: " + sm.getFreeCashRegTime() + ". \nGenomsnittlig ledig kassatid: ");
        System.out.printf("%.2f",(sm.getFreeCashRegTime()/sm.getTimeOpen())*100);
        System.out.print(" te (dvs ");
        System.out.printf("%.2f",sm.getFreeCashRegTime()/sm.getTimeOpen());
        System.out.print("% av tiden från öppning tills sista kunden betalat).\n");

        System.out.println("\n3); Total tid " + sm.getQueuedCustomer() + " kunder tvingats köa: " + sm.getwaitedTime()
                + ".\nGenomsnittlig kötid: " + sm.getwaitedTime()/sm.getQueuedCustomer()+ "te.");
    }

    public static void scndMethod(){
        //my duty is to send cashregs to method1
        //maybe i set max and skill and all that?
        //while i is less then max cust send more cash regs
        for (int i=1;i<max;i++){
            firstmethod(i);
        }
    }


	public static void cashOpen() {



		for (int i = 0; i < simulations; i++) {
		    //dont need ++ can use + 0.5 or whatever is appropriate.
		    //max++;
		    time = 8;
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

            System.out.println("\n--------------------------------");
            System.out.print("Maxcust: "+max+"\tCashregs: "+cash+"\tTimeopen: "+time);
		    //change multiple scenarios
            EventQueue eq = new EventQueue();

            SuperMarket sm = new SuperMarket(0,true,eq, 0.5,max,cash,time);
            //SuperMarketView smView = new SuperMarketView(sm);

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
		                //add all objs to list
		                missedcust.add(sm);
                        System.out.println("\nWaited time: "+sm.getwaitedTime());
                        System.out.println("Missed customer: "+sm.getMissedCustomer());
                        System.out.println("Idle cashregTime: "+sm.getFreeCashRegTime()+"\n");
		            	break;
		            }
		        }
			//Måste jämföra minsta antalet missade kunder och publicera vilket som är mest lämpligt.
			// System.out.println(supermarket.amountOfFreeCashRegs());
		}
		//loop through amount of simulations and get the sim with least missed
		for(int i=0;i<simulations;i++){
		    if(missedcust.get(i).getMissedCustomer()<min){
		        min = missedcust.get(i).getMissedCustomer();
		        minobj = missedcust.get(i);
            }
        }
        System.out.println("==========================================");
        System.out.println("THE MOST EFFICIENT SOLUTION\n");
        System.out.print("Maxcust: "+minobj.getmaxCustomerAmount()+"\tCashregs: "+minobj.numofcashregs()+"\tTimeopen: "+minobj.getTimeOpen());
        System.out.println("\nWaited time: "+minobj.getwaitedTime());
        System.out.println("Missed customer: "+minobj.getMissedCustomer());
        System.out.println("Idle cashregTime: "+minobj.getFreeCashRegTime()+"\n");
	}

	public static void main(String[] args) {
        //cashOpen();
        // doing the methods of lab spec 2.0
        firstmethod(2);
	}
}
