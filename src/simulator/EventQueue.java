package simulator;

import java.util.ArrayList;

public class EventQueue extends Event {
	
	public EventQueue(int id, double time) {//Autogenererad?
		super(id, time);
		// TODO Auto-generated constructor stub
	}
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
	public void parseEvents(int scheduledTime, Event event) {
		for(int i = 0; i < eventList.size();i++) {
			if(scheduledTime > eventList.get(i).time) {
				eventList.add(i,event);
				break;
				
			}else {
				eventList.add(event);
				break;
			}
		}
	}
	

}
