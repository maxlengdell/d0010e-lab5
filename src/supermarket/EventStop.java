package supermarket;
import simulator.Event;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
/** This class describes the event that occurs when the supermarket simulation stops/ends*/
public class EventStop extends Event {
	SuperMarket s;
	double time;
/**
 * Constructor for the class EventStop that creates a EventStop object
 * with the following parameters
 * @param time
 * @param s
 */
	public EventStop(double time, SuperMarket s) {
		super(time, s);
		this.s=s;
		this.time=time; //stop at 1000
		
	}
	/** This method executes the event. The simulation will end and the stats updated*/
	public void execute(){
		s.setTimeState(this.time);
		s.updateTimeStatistics(time);
		s.changeisActive(false);
		s.setEventCustomer(null);
		s.setEventType(this.getClass());
		s.notifyStateObs();

	}
	
}
