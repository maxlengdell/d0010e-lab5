package supermarket;

import java.util.ArrayList;

import simulator.State;

public class SuperMarket extends State {
	public boolean isOpen=false;
	public ArrayList <Customer> Queue;
	public double skill;
	public int missedCustomer=0;
	public int debitedCustomer;
	public int[] cashRegister={0,0,0,0};
	public int maxCustomerAmount=5;
	public int currentCustomerAmount=0;
	public double waitedTimed=0;
	public int CustomerIDCount=1;
	
	public SuperMarket(){
		super(0, true);
		
	}
	public void getOpenState(){
		
	}
	public void getClosedState(){
		
	}
	public void getCustomerPayedState(){
		
	}
	public void getCustomerEnteredState(){
		
	}
	public void getCustomerLeftState(){
		
	}
	public void changeState(){
		
	}

}
