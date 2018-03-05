package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import random.ExponentialRandomStream;
import supermarket.EventArrival;
import supermarket.SuperMarket;
import simulator.State;

/*
public class Optimize {
	private static SuperMarket supermarket;
	
	
	public static void cashOpen(EventQueue EQ, SuperMarket S) {
		for (int i = 0; i < supermarket.getmaxCustomerAmount(); i++) {
			
			supermarket.changeVariables(i);
			while(S.getisActive()) {
				EQ.eventList.get(0).execute();
			}
			//Måste jämföra minsta antalet missade kunder och publicera vilket som är mest lämpligt.
		}
	}
	public static void main(String[] args) {
		//Kopierat från RunSim
			EventQueue EQ = new EventQueue();
	        SuperMarket SM = new SuperMarket(0,true,EQ);
	        EventArrival EA = new EventArrival(0,SM);
	        EA.execute();
	        //now run eventQueue
	        cashOpen(EQ,SM);
	}
}
*/