package simulator;

import java.util.ArrayList;
//import simulator.Event;

public class EventQueue {

	
	public ArrayList <Event> eventList;

	public void addEvent(Event event){
		parseEvents(event.getTime(), event);
		

	}
	public void executeNext(Event event){
		Event first = eventList.get(0);
		eventList.remove(0);
		first.Execute();
		

	}
	public ArrayList<Event> getEventList () {
		return eventList;
	}
	public Event getFirstEvent() {
		Event first = eventList.get(0);
		
		return first;
	}
	public void parseEvents(double scheduledTime, Event event) { 
		//Adds event to eventList in order based on scheduled time. 
		
		boolean added = false;
		if (eventList.size() == 0) {
			eventList.add(event);
		}else {
			for(int i = 0; i < eventList.size();i++) {
				if(event.getTime() < eventList.get(i).getTime()) { // Vilken klass ska hålla koll på tiden?
					//Tveksamt om detta fungerar. hur får man det enskilda eventets tid?
					eventList.add(i,event);
					System.out.println(eventList);
					added = true;

					return;
				}
			}
			if(added == false) {
				eventList.add(event);
				
			}
		}
		return;	
	}
}
