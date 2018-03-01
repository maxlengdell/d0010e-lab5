package supermarket;

import simulator.Event;
import simulator.State;
import supermarket.SuperMarket;

public class EventDebiting extends Event {
	double time;
	SuperMarket s;
	Customer c;
	
	
	public EventDebiting(double time, SuperMarket s, Customer c){
		super(time,s);
		this.s=s;
		this.c=c;
		
	}
	public void Execute() {
		int[] cashReg=s.getcashRegister();
	 
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
	 for(int i=0; i<=cashReg.length; i++){
		if(s.cashRegStatus()==0) {//if cashregister is free. Execute this. 
			s.getEventQueue().addEvent(s.getCurrentEvent());
			s.addCustomerToQueue(c);
			//Place customer in the cashregister. 
		
		}
		else if(s.cashRegStatus()==1){ //if cashregister is occupied. Execute this.
			s.addCustomerToQueue(c);
		}
		
	 }
	}
}
