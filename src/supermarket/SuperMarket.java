package supermarket;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import simulator.State;


public class SuperMarket extends State {
	
	private boolean isOpen=false;
	
	
	// SuperMarket variables
	private double skill;
	private int maxCustomerAmount=10;
	private double timeOpen=8.0;
	
	// SuperMarket statistics
	private int missedCustomer = 0;
	private int debitedCustomer = 0;
	private double waitedTime = 0;
	private double freeCashRegTime = 0;
	
	// Current State data
	private int[] cashRegister = {0,0,0,0}; //0 for vacant, 1 for occupied cashregister
	private int currentCustomerAmount = 0;
	private int customerIDCount = 0;
	
	public ArrayList <Customer> customerQueue=new ArrayList<Customer>();
	
	public SuperMarket(){
		super(0, true);
		
	}
	public void addQueue(Customer id) { // Tvivlar på att detta fungerar. Måste nog ta en ny int som arg. och så håller den koll själv. 
		customerQueue.add(id); //Lägger till kundens id i kön.
	}
	public void removeFirst() throws NoSuchElementException{
		if(customerQueue.size()==0){
			throw new NoSuchElementException();
		}
		else{
			this.customerQueue.remove(0);
		}
		
	}
	
	public Customer first() throws NoSuchElementException{
		if(this.customerQueue.size()==0){
			 throw new NoSuchElementException();
		 }
		 else{
			 return this.customerQueue.get(0);
		 }
	 }
	
	 public boolean isEmpty(){
		 if(this.customerQueue.size()==0){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
	
	public int size(){
		return this.customerQueue.size();
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
	
	public double getFreeCashRegTime(){
		return this.freeCashRegTime;
		
	}
	
	public int cashRegStatus(){
		for(int i=0; i<cashRegister.length;i++){
			if(this.cashRegister[i]==0){
				this.cashRegister[i]=1;
				return 1;
			}
		}
		return 0;
	}
	
	
	public void changeOpenState(boolean changeOpenorClose){
		isOpen=changeOpenorClose;
		
	}
	
	

}
