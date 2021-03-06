package supermarket;
import simulator.*;
/**
*
* @author Shahin Salehi, Max Lengdell , Johan Jirlén, Linus Lindahl Marjavaara
*
*/
/**The supermarket class*/
public class SuperMarket extends State {
	
	private boolean isOpen=false;
	
	double time;




	// SuperMarket variables
	// we put this in RunSim and give to constructor instead thank u.

	private double skill;
	private int maxCustomerAmount;
	private int numberOfCashRegisters;
	private double timeOpen;
	
	// SuperMarket statistics
	private int missedCustomer = 0;
	private int debitedCustomer = 0;
	private int queuedCustomer = 0;
	private double waitedTime = 0; 
	private double freeCashRegTime = 0;
	private double lastCustomerDeparture = 0;
	
	// Current State data
	private int[] cashRegister = new int[numberOfCashRegisters]; // 0 for vacant, 1 for occupied cashregister
	private Customer[] customerQueue = new Customer[maxCustomerAmount]; // public ArrayList <Customer> customerQueue=new ArrayList<Customer>(); This an alternative to a customer array
	private int currentCustomerAmount = 0;
	private int customerIDCount = 0;
	
	// Resources This needs to be a method
	private SuperMarketRandomGen rng;
	
	// Event tracking
	private Customer currentEventCustomer;
	
	/*
	 * Constructor
	 */
	@SuppressWarnings("deprecation")
/**
 * Constructor for the class SuperMarket. Creates a SuperMarket object
 * with the following parameters.
 * @param time
 * @param isActive
 * @param eventQueue
 * @param skill
 * @param max
 * @param cash
 * @param timeopen
 */
	public SuperMarket(double time, boolean isActive, EventQueue eventQueue, double skill, int max, int cash, double timeopen){
		super(time, isActive, eventQueue);
		this.time = time;
		this.skill=skill;
		this.maxCustomerAmount=max;
		this.numberOfCashRegisters=cash;
		this.timeOpen=timeopen;
		cashRegister = new int[cash];
		customerQueue=new Customer[max];

	}

	/**
	 * This method takes the values for the random generator from the simulator and returns the value
	 * @param seed
	 * @param lambda
	 * @param uLow
	 * @param uUp
	 * @return
	 */
	public void initRandGen(int seed, double lambda, double uLowDebiting, double uUpDebiting, double uLowDeparture, double uUpDeparture){
		rng = new SuperMarketRandomGen(seed,lambda,uLowDebiting,uUpDebiting,uLowDeparture,uUpDeparture);
		return;

	}
	/**
	 * returns number of cash registers. 
	 * @return
	 */
	public int numofcashregs(){
		return numberOfCashRegisters;
	}

/**This method changes the amount of cash registers for each run of the simulation
	
	 * 
	 * @param newNumberOfCashRegs
	 */
	public void changeVariables(int newNumberOfCashRegs) {
		cashRegister = new int[newNumberOfCashRegs];
	}
//Customer stuff	
/**This method returns the queue of customers/ cash register queue
 * 
 * @return
 */
	public Customer[] getCustomerQueue() {
		return customerQueue;
	}
/**This method removes the first customer from the customer queue/cash register queue after the customer has finished paying
 * 
 * @return
 */
	public Customer takeFirstCustomerFromQueue() {
		Customer firstCustomer = customerQueue[0];
		for (int i = 1; i < customerQueue.length; i++) {
			customerQueue[i-1] = customerQueue[i];
		}
		customerQueue[customerQueue.length-1] = null;
		return firstCustomer;
	}
/**This method adds a customer to the customer queue/cash register queue
 * 
 * @param newCustomer
 */
	public void addCustomerToQueue(Customer newCustomer) {
		for (int i = 0; i < customerQueue.length; i++) {
			if (customerQueue[i] == null) {
				customerQueue[i] = newCustomer;
				break;
			}
		}
		return;
	}
/**>This method counts the amount of customers in the customer queue/cash register queue
 * 
 * @return
 */
	public int customerAmountInQueue() {
		int queueCount = 0;
		for (int i = 0; i < customerQueue.length; i++) {
			if (customerQueue[i] == null) {
				break;
			}
			queueCount++;
		}
		return queueCount;
	}
	/**This method updates the time for every ovent that occurs
	 * 
	 */
	public void setTimeState(double newTime){
		this.time = newTime;
		super.setTimeState(newTime);
		return;
	}
	
	/**This method returns the ID value for each customer
	 * 
	 * @return
	 */
	public int nextCustomerId() {
		customerIDCount++;
		return customerIDCount;
	}
	//Isopen stuff
	/**This method returns a boolean variable for if the supermarket is open or not
	 * 
	 * @return
	 */
	public boolean getisOpen(){
		return isOpen;
	}
	/**This method changes the isOpen variable from true to false
	 * 
	 * @param changeOpenorClose
	 */
	public void changeOpenState(boolean changeOpenorClose){
		isOpen=changeOpenorClose;
		
	}
	//Missed customer stuff
	/**This method returns the amount of missed customers
	 * 
	 * @return
	 */
	public int getMissedCustomer(){
		return missedCustomer;
	}
	/**This method adds a customer to the amount of missed customers
	 * 
	 */
	public void addMissedCustomer(){
		missedCustomer++;
		return;
	}
	//Debited customer stuff
	/**This method returns the amount of debited customers
	 * 
	 * @return
	 */
	public int getDebitedCustomer(){
		return debitedCustomer;
	}
	/**This method adds a customer to the amount of debited customers 
	 */
	public void addDebitedCustomer(){
		debitedCustomer++;
		return;
	}
	//Queued customer stuff
	/**This method returns the amount of customers that are currently in the cash register queue
	 * 
	 * @return
	 */
	public int getQueuedCustomer() {
		return queuedCustomer;
	}
	/**This method adds a customer to the amount of customer that are currently in the cash register queue
	 * 
	 */
	public void addQueuedCustomer() {
		queuedCustomer++;
		return;
	}
	//Current customer amount stuff
	/**This method returns the current amount of customers that are in the supermarket
	 * 
	 * @return
	 */
	public int getcurrentCustomerAmount(){
		return currentCustomerAmount;	
	}
	/**This method adds a customer to the current amount of customers that are in the supermarket
	 * 
	 */
	public void addCurrentCustomerAmount(){
		currentCustomerAmount++;
		return;	
	}
	/**This method removes a customer from the current amount of customers that are in the supermarket
	 * 
	 */
	public void subCurrentCustomerAmount(){
		currentCustomerAmount--;
		return;	
	}
	//Observer stuff
	/**This method notifies the observers that a change has occurred
	 * 
	 */
	public void notifyStateObs(){
		setChanged();
		notifyObservers();
	}
	//Time statistic stuff
	/**This method updates the time for the waited time variable and the time a cash register has been free (no customer queue)
	 * 
	 * @param newTime
	 */
	public void updateTimeStatistics(double newTime) {
		waitedTime = waitedTime + (newTime-time)*customerAmountInQueue();
		int numOfFreeCashRegs = 0;
		for (int i = 0; i < cashRegister.length; i++) {
			numOfFreeCashRegs += 1 - cashRegister[i];
		}
		freeCashRegTime = freeCashRegTime + (newTime-time)*numOfFreeCashRegs;
	}
	//Cash register stuff
	/**This method checks if any cash registers are free
	 * 
	 */
	public void freeCashRegister() {
		for (int i = 0; i < cashRegister.length; i++) {
			if (cashRegister[i] == 1) {
				cashRegister[i] = 0;
				return;
			}
		}
		return;
	}
	/**This method returns true or false depending on if a customer is in the cash register queue or not
	 * 
	 * @return
	 */
	public boolean cashRegStatus(){
		for (int i = 0; i < cashRegister.length; i++) {
			if (cashRegister[i] == 0) {
				return true;	// There is at least one free cash register
			}
		}
		return false;
	}
	/**This method makes a customer take a free cash register
	 * 
	 */
	public void takeCashRegister() {
		for (int i = 0; i < cashRegister.length; i++) {
			if (cashRegister[i] == 0) {
				cashRegister[i] = 1;
				return;
			}
		}
		return;
	}
	/**This method returns the amount of free cash register
	 * 
	 * @return
	 */
	public int amountOfFreeCashRegs() {
		int regCount = 0;
		for (int i = 0; i < cashRegister.length; i++) {
			if (cashRegister[i] == 0) {
				regCount++;
			}
		}
		return regCount;
	}
	
	/*
	 * Event tracking stuff
	 */
	/**This method sets the current event to a new event of the type Customer
	 * 
	 * @param newEventCustomer
	 */
	public void setEventCustomer(Customer newEventCustomer) {
		currentEventCustomer = newEventCustomer;
	}
	/**This method returns the event ID for a customer
	 * 
	 * @return
	 */
	public int getEventCustomerId() {
		if (currentEventCustomer == null) {
			return 0;
		}
		else {
			return currentEventCustomer.getID();
		}
	}
	
	/*
	 * RandomGen stuff
	 */
	/**This constructor returns a variable that randomizes each variable for every individual run of the program
	 * 
	 * @return
	 */
	public SuperMarketRandomGen getRnG() {
		return rng;
	}
	/**This method returns the skill for each cash register operator
	 * 
	 * @return
	 */
	public double getSkill(){
		return skill;
	}
	/**This method returns the amount of cash registers
	 * 
	 * @return
	 */
	public int[] getcashRegister(){
		return cashRegister;
	}
	/**This method returns the max amount of customers allowed in the supermarket
	 * 
	 * @return
	 */
	public int getmaxCustomerAmount(){
		return maxCustomerAmount;
	}
	/**This method returns the amount of time a customer has waited in line to a cash register
	 * 
	 * @return
	 */
	public double getwaitedTime(){
		return waitedTime;
	}
	/**This method returns the customer ID count
	 * 
	 * @return
	 */
	public int getcustomerIDCount(){
		return customerIDCount;
	}
	/**This method returns the time that the supermarket has been open
	 * 
	 * @return
	 */
	public double getTimeOpen(){
		return timeOpen;
	}
	/**This method returns the amount of time that a cash register has been free (no customers in queue)
	 * 
	 * @return
	 */
	public double getFreeCashRegTime(){
		return this.freeCashRegTime;
		
	}
/**
 * Returns lambda
 * @return
 */
	public double getLamda() {
		return rng.lambda;
	}
	/**
	 * returns upperdebiting limit
	 * @return
	 */
	public double getPlockTidUpper() {
		return rng.uniUpperDebiting;	
	}
	/**
	 * returns lower debiting limit
	 * @return
	 */
	public double getPlockTidLower() {
		return rng.uniLowerDebiting;
	}
	/**
	 * returns upper detarture limit
	 * @return
	 */
	public double getPayTimeUpper() {
		return rng.uniUpperDeparture;
	}
	/**
	 * returns lower departure limit
	 * @return
	 */
	public double getPayTimeLower() {
		return rng.uniLowerDeparture;
	}
	/**
	 * returns seed
	 * @return
	 */
	public long getSeed() {
		return rng.seed;
	}
	
	public double getLastCustomerDeparture() {
		return lastCustomerDeparture;
	}
	public void setLastCustomerDeparture(double time) {
		lastCustomerDeparture = time;
		return;
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


