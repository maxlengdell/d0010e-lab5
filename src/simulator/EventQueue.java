package simulator;

import java.util.ArrayList;

public class EventQueue extends Event {
	public ArrayList <Event> eventList;
	
	public void addEvent(Event event){
		
	}
	public void executeNext(Event event){
		
	}
	public ArrayList<Event> getEventList () {
		return eventList;
	}
	public Event getFirstEvent() {
		Event first = eventList.get(0);
		eventList.remove(0);
		return first;
	}
	public void addEvent() {
		//Add event..? How to add according to time.
		
	}

}
