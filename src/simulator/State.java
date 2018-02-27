package simulator;

import java.util.Observable;

public class State extends Observable{
	private double time;
	private boolean isActive;
	private Event currentEvent; 
	public State(double time, boolean isActive){
		this.time=time;
		this.isActive=isActive;
	}
	public double getTimeState(){
		return this.time;
	}
	public boolean getisActive(){
		return this.isActive;
	}
	public Event getCurrentEvent(){
		return this.currentEvent;
	}
	public void changeEvent(Event newEvent){
		this.currentEvent=newEvent;
	}
	
	public void notifyStateObs(){
		setChanged();
		notifyObservers();
	}

}
