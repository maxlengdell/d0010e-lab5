package supermarket;

import simulator.View;

public class SuperMarketView extends View {
	
	SuperMarket superMarket;
	
	public SuperMarketView(SuperMarket superMarket) {
		this.superMarket = superMarket;
		/*
		Time 	= Time of event
		Event 	= Type of event
		Customer = Id of customer
		?		= Is the store open
		led		= Number of free registers
		ledt	= total free register time
		I 		= Number of customers in the shop
		*/
		System.out.println("Time\tEvent\tCustomer\t?\tled\tledt\tCustCount");
	}
	
	public void update() {
		
	}
}
