package simulator;

import java.util.Observable;

public class State extends Observable{
	public double time;
	public boolean isActive;
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

}
