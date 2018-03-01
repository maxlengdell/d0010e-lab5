package supermarket;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import simulator.*;


public class SuperMarket extends State {
	
	private boolean isOpen=false;
	
	double time;
	
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
	private int[] cashRegister = {0,0,0,0}; // 0 for vacant, 1 for occupied cashregister
	private Customer[] customerQueue = new Customer[maxCustomerAmount]; // public ArrayList <Customer> customerQueue=new ArrayList<Customer>(); This an alternative to a customer array
	private int currentCustomerAmount = 0;
	private int customerIDCount = 0;
	
	/*
	 * Constructor
	 */
	public SuperMarket(double time, boolean isActive, EventQueue eventQueue){
		super(time, isActive, eventQueue);
		this.time = time;
	}
		
	/*
	 * CustomerQueue stuff
	 */
	public Customer[] getCustomerQueue() {
		return customerQueue;
	}
	public Customer takeFirstCustomerFromQueue() {
		Customer firstCustomer = customerQueue[0];
		for (int i = 1; i < customerQueue.length; i++) {
			customerQueue[i-1] = customerQueue[i];
		}
		customerQueue[customerQueue.length-1] = null;
		return firstCustomer;
	}
	public void addCustomerToQueue(Customer newCustomer) {
		for (int i = 0; i < customerQueue.length; i++) {
			if (customerQueue[i] == null) {
				customerQueue[i] = newCustomer;
				break;
			}
		}
		return;
	}
	private int customerAmountInQueue() {
		int queueCount = 0;
		for (int i = 0; i < customerQueue.length; i++) {
			if (customerQueue[i] == null) {
				break;
			}
			queueCount++;
		}
		return queueCount;
	}
	
	/*
	 * Customer id stuff
	 */
	public int nextCustomerId() {
		customerIDCount++;
		return customerIDCount;
	}
	
	/*
	 * IsOpen stuff
	 */
	public boolean getisOpen(){
		return isOpen;
	}
	public void changeOpenState(boolean changeOpenorClose){
		isOpen=changeOpenorClose;
		
	}
	
	/*
	 * MissedCustomer stuff
	 */
	public int getMissedCustomer(){
		return missedCustomer;
	}
	public void addMissedCustomer(){
		missedCustomer++;
		return;
	}
	
	/*
	 * debitedCustomer stuff
	 */
	public int getDebitedCustomer(){
		return debitedCustomer;
	}
	public void addDebitedCustomer(){
		debitedCustomer++;
		return;
	}
	
	/*
	 * CurrentCustomerAmount stuff
	 */
	public int getcurrentCustomerAmount(){
		return currentCustomerAmount;	
	}
	public void addCurrentCustomerAmount(){
		currentCustomerAmount++;
		return;	
	}
	public void subCurrentCustomerAmount(){
		currentCustomerAmount--;
		return;	
	}
	
	/* 
	 * Update time statistics
	 */
	public void updateTimeStatistics(double newTime) {
		waitedTime = waitedTime + (newTime-time)*customerAmountInQueue();
		int numOfFreeCashRegs = 0;
		for (int i = 0; i < cashRegister.length; i++) {
			numOfFreeCashRegs += 1 - cashRegister[i];
		}
		freeCashRegTime = freeCashRegTime + (newTime-time)*numOfFreeCashRegs;
	}
	
	
	
	
	
	public double getSkill(){
		return skill;
	}
	
	public int[] getcashRegister(){
		return cashRegister;
	}
	public int getmaxCustomerAmount(){
		return maxCustomerAmount;
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
	
	
	
	
	

}




/*
 * 
 * 
	
	
	
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
	
	public get
	
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
	
	*/


/*
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
 * 
 */


