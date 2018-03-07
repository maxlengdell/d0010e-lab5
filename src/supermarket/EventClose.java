package supermarket;

import simulator.Event;
/**
*
* @author Shahin Salehi, Max Lengdell, Johan Jirlén, Linus
* Lindahl Marjavaara
*
*/
/**This class decribes the event that ouccurs when the supermarket closes*/
public class EventClose extends Event {
	SuperMarket s;
	double time;
	/** Constructor for the class EventClose. When a EventClose object is created it is assigned a time when it occurs and a state*/ 
	/**
	 * 
	 * @param time
	 * @param s
	 */
	public EventClose(double time, SuperMarket s){
		super(time, s);
		this.s=s;
		this.time=time;
	}

/** This method executes the event. The store is closed and the stop simulation event will occur afterwards*/
	public void execute() {
		s.updateTimeStatistics(time);
		s.setEventCustomer(null);
		s.changeOpenState(false);
		s.setTimeState(time);
		s.setEventType(this.getClass());
		s.notifyStateObs();
	
	}
}

	

