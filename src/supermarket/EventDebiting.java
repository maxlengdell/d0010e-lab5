package supermarket;

import simulator.Event;
import simulator.State;

public class EventDebiting extends Event {
	SuperMarket s;
	public EventDebiting(double time, SuperMarket s){
		super(time,s);
		this.s=s;
		
	}
 public void Execute() {
		//Time for how long the customer shopped*I think*(check)
		//Puts the customer in the supermarket queue.
	 
		if(s.cashRegStatus()==0) {//if cashregister is free. Execute this. 
			
			//Place customer in the cashregister. 
		
		}
		else if(s.cashRegStatus()==1){ //if cashregister is occupied. Execute this.
			
		}
		
  }
}
