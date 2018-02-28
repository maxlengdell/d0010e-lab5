package simulator;

import java.util.ArrayList;
//import simulator.Event;

public class EventQueue {

	private Event event;
	public ArrayList <Event> eventList;

	public void addEvent(Event event){//Nödvändigt??
		eventList.add(event);

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
		//Adds event to eventList in order based on scheduled time. 
		if (eventList.size() == 0) {
			eventList.add(event);
		}else {
			for(int i = 0; i < eventList.size();i++) {
				if(scheduledTime > eventList.get(i).getTime()) { // Vilken klass ska hålla koll på tiden?
					//Tveksamt om detta fungerar. hur får man det enskilda eventets tid?
					eventList.add(i,event);

					break;

				}else {
					eventList.add(event);
					break;
				}
			}
		}
	}


}
