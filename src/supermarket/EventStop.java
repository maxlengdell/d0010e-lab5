package supermarket;

import simulator.Event;

public class EventStop extends Event {
	SuperMarket s;
	double time;

	public EventStop(double time, SuperMarket s) {
		super(time, s);
		this.s=s;
		this.time=time; //stop at 1000
		
	}
	public void Execute(){
		s.updateTimeStatistics(time);
		s.changeisActive(false);
		s.setEventCustomer(null);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
	
}
