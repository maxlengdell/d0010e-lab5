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
		this.time=time;
	}
	public void Execute() {
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
		s.updateTimeStatistics(time);
		if(s.cashRegStatus()==true) {//if cashregister is free. Execute this. 
			
			double departureTime=time;
			time+s.getRandomNumber()/s.getSkill();
			s.getEventQueue().addEvent(new EventDeparture(departureTime, s, c));
			s.takeCashRegister();
			//Place customer in the cashregister. 
		
		}
		
		if(s.cashRegStatus()==false){ //if cashregister is occupied. Execute this.
			s.addCustomerToQueue(c);
			s.addQueuedCustomer();
		}
		
		s.setEventCustomer(c);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
}
