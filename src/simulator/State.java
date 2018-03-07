package simulator;

import java.util.Observable;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
@SuppressWarnings("deprecation")
/**The State class. Describes a state of a simulation*/
public class State extends Observable{
	private double time;
	
	private boolean isActive; //Variable that checks if the simulation is active/ is running or not
	private Event currentEvent; //Object that stores the current event. 
	private Class<?> currentEventType; //Object that stores the current type of event.
	private EventQueue eventQueue; //Object that stores the event queue.
/**
 * Constructor that creates a State object with the following parameters
 * @param time
 * @param isActive
 * @param eventQueue
 */
	public State(double time, boolean isActive, EventQueue eventQueue){
		this.time=time;
		this.isActive=isActive;
		this.eventQueue = eventQueue;
	}
	
	/*
	 * Returns the time of the state
	 */	
/**
 * Returns the time of the state
 * @return
 */
	public double getTimeState(){
		return this.time;
	}
	/*
	 * Sets the time of the state
	 */
/**
 * Sets the time of the state
 * @param newTime
 */
	public void setTimeState(double newTime){
		this.time = newTime;
		return;
	}
	
	/*
	 * Returns the EventQueue that handles the state's events
	 */
/**Returns the EventQueue that handles the events of the state*/
	public EventQueue getEventQueue() {
		return eventQueue;
	}
		
	/*
	 * Returns true if the state is active and false if not
	 */
/**
 * Returns true if the state is active and false if not
 * @return
 */
	public boolean getisActive(){
		return this.isActive;
	}
/**
 * Changes if the state is active or not
 * @param isActive
 * @return
 */
	public boolean changeisActive(boolean isActive){
		return this.isActive;
	}
	
	/*
	 * CurrentEvent stuff
	 */
/**
 * Returns the current event
 * @return
 */
	public Event getCurrentEvent(){
		return this.currentEvent;
	}
/**Changes the current event to a new event
 * 
 * @param newEvent
 */
	public void changeEvent(Event newEvent){
		this.currentEvent=newEvent;
	}
/**Returns the current type of event
 * 
 * @return
 */
	public Class<?> getCurrentEventType(){
		return currentEventType;
	}
/**Changes the current type of event
 * 
 * @param eventType
 */
	public void setEventType(Class<?> eventType){
		currentEventType = eventType;
	}
	
	


}
