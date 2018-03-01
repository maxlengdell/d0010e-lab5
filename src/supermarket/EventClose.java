package supermarket;

import simulator.Event;

public class EventClose extends Event {
	SuperMarket s;
	double time;
	
	public EventClose(double time, SuperMarket s){
		super(time, s);
		this.s=s;
		this.time=time;
	}


	public void Execute() {
		s.updateTimeStatistics(time);
		s.setEventCustomer(null);
		s.changeOpenState(false);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	
	}
}

	

