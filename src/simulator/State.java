package simulator;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class State extends Observable{
	private double time;
	
	private boolean isActive;
	private Event currentEvent; 
	private Class<?> currentEventType;
	private EventQueue eventQueue;
	
	public State(double time, boolean isActive, EventQueue eventQueue){
		this.time=time;
		this.isActive=isActive;
		this.eventQueue = eventQueue;
	}
	
	/*
	 * Returns the time of the state
	 */	
	public double getTimeState(){
		return this.time;
	}
	/*
	 * Sets the time of the state
	 */
	public void setTimeState(double newTime){
		this.time = newTime;
		return;
	}
	
	/*
	 * Returns the EventQueue that handles the state's events
	 */
	public EventQueue getEventQueue() {
		return eventQueue;
	}
		
	/*
	 * Returns true if the state is active and false if not
	 */
	public boolean getisActive(){
		return this.isActive;
	}
	public boolean changeisActive(boolean isActive){
		return this.isActive;
	}
	
	/*
	 * CurrentEvent stuff
	 */
	public Event getCurrentEvent(){
		return this.currentEvent;
	}
	public void changeEvent(Event newEvent){
		this.currentEvent=newEvent;
	}
	public Class<?> getCurrentEventType(){
		return currentEventType;
	}
	public void setEventType(Class<?> eventType){
		currentEventType = eventType;
	}
	
	
	public void notifyStateObs(){
		setChanged();
		notifyObservers();
	}

}
