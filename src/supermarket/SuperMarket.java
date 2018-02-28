package supermarket;

import java.util.ArrayList;

import simulator.State;

public class SuperMarket extends State {
	public boolean isOpen=false;
	public ArrayList <Customer> customerQueue;
	private double skill;
	private int missedCustomer=0;
	private int debitedCustomer;
	private int[] cashRegister={0,0,0,0}; //0 for vacant, 1 for occupied cashregister
	private int maxCustomerAmount=5;
	private int currentCustomerAmount=0;
	private double waitedTime=0;
	private int customerIDCount=1;
	private double timeOpen=8.0;
	
	public SuperMarket(){
		super(0, true);
		
	}
	public ArrayList<Customer> getCustomerQueue(){
		return customerQueue;
	}
	
	public boolean getisOpen(){
		return isOpen;
	}
	public double getSkill(){
		return skill;
	}
	public int getMissedCustomer(){
		return missedCustomer;
	}
	public int getdebitedCustomer(){
		return debitedCustomer;
	}
	public int[] getcashRegister(){
		return cashRegister;
	}
	public int getmaxCustomerAmount(){
		return maxCustomerAmount;
	}
	public int getcurrentCustomerAmount(){
		return currentCustomerAmount;	
	}
	public double getwaitedTime(){
		return waitedTime;
	}
	
	public int getcustomerIDCount(){
		return customerIDCount;
	}
	
	public double getTimeOpen(){
		return timeOpen;
	}
	
	public boolean cashRegStatus(){
		for(int i=0; i<cashRegister.length;i++){
			if(this.cashRegister[i]==0){
				this.cashRegister[i]=1;
				return true;
			}
		}
		return false;
	}
	
	
	public void changeState(boolean changeOpenorClose){
		isOpen=changeOpenorClose;
		
	}
	public void addQueue(Customer id) { // Tvivlar på att detta fungerar. Måste nog ta en ny int som arg. och så håller den kol själv. 
		customerQueue.add(id); //Lägger till kundens id i kön.
	}

}
