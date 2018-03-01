package supermarket;
import simulator.Event;
import supermarket.SuperMarket;
public class EventOpen extends Event {
	double time;
	SuperMarket s;
	
	
	public EventOpen(SuperMarket s, double time){
		super(time,s);
		this.s=s;
		this.time=time;
	}
	public void Execute() {
		s.changeOpenState(true);
		s.setEventCustomer(null);
		s.updateTimeStatistics(0);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	}
}
