package supermarket;

import java.util.ArrayList;

import simulator.State;

public class SuperMarket extends State {
	private boolean isOpen=false;
	public ArrayList <Customer> Queue;
	private double skill;
	private int missedCustomer=0;
	private int debitedCustomer;
	private int[] cashRegister={0,0,0,0};
	private int maxCustomerAmount=5;
	private int currentCustomerAmount=0;
	private double waitedTime=0;
	private int customerIDCount=1;
	
	public SuperMarket(){
		super(0, true);
		
	}
	public ArrayList<Customer> getCustomerList(){
		return Queue;
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
	
	
	
	public void changeState(){
		
	}

}
