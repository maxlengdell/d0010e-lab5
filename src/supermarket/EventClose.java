package supermarket;

import simulator.Event;

public class EventClose extends Event {
	SuperMarket s;
	
	public EventClose(double time, SuperMarket s){
		super(time, s);
		this.s=s;
	}


	public void Execute() {
		s.changeOpenState(false);
		s.notifyObservers();
	
	}
}

	

