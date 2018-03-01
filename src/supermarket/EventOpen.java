package supermarket;
import simulator.Event;
import supermarket.SuperMarket;
public class EventOpen extends Event {
	SuperMarket s;
	
	
	public EventOpen(SuperMarket s){
		super(0,s);
		this.s=s;
	}
	public void Execute() {
		s.changeOpenState(true);
		s.getcashRegister();
		s.getCurrentEvent();
		s.notifyObservers();
	}
}
