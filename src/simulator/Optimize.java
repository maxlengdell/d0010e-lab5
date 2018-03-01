package simulator;

import supermarket.SuperMarket;
import random.ExponentialRandomStream;

public class Optimize {
	private static SuperMarket supermarket;

	State S;
	EventQueue EQ;
	
	public static void cashOpen() {
		for (int i = 0; i < supermarket.getmaxCustomerAmount(); i++) {
			
			
			setNumberOfCashRegisters(i);
			while(S.getisActive()) {
				EQ.eventList.get(0).Execute();
			}
			
		}
	}
	public static void main(String[] args) {
		ExponentialRandomStream exp = new ExponentialRandomStream(1,1234);
		System.out.println("rand valie from optimize: "+ exp.next());
	}
}
