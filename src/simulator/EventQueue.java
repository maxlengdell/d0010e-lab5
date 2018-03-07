package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import java.util.ArrayList;
//import simulator.Event;

public class EventQueue {

	
	public ArrayList <Event> eventList = new ArrayList<Event>();
/**
 * adds the parameter to parseEvent method and sorts them according to scheuled time
 * @param event
 */
	public void addEvent(Event event){
		parseEvents(event.getTime(), event);
		

	}
	/**
	 * Executes next event if there exists such a event. 
	 * @return
	 */
	public boolean executeNext(){
		if (eventList.size() > 0) {
			Event first = eventList.get(0);
			eventList.remove(0);
			first.execute();
			return true;
		}
		else {
			return false;
		}
		

	}
	/**
	 * Returns the eventList
	 * @return
	 */
	public ArrayList<Event> getEventList () {
		return eventList;
	}
	/**
	 * returns the first event in the eventList(eventQueue)
	 * @return
	 */
	public Event getFirstEvent() {
		Event first = eventList.get(0);
		
		return first;
	}
	/**
	 * Sorts the events in eventList to the correct scheduled scheme. 
	 * @param scheduledTime
	 * @param event
	 */
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
