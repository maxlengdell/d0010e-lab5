package supermarket;
import supermarket.SuperMarket;

public class EventArrival {
	private SuperMarket supermarket;
//define time!!

	public void Arrives() {
		//Initierar (check)
		//Skapar id för kunden. (check)
		//customer creates new object  to customer. (check)
		//Puts the customer in the "shopping" list
		if (supermarket.getisOpen()) {
			int id = 0;
			Customer customer = new Customer(id, time);
			id++;
		} else if (!(supermarket.getisOpen())) {
			//Missad kund! add counter??
		}

	}
}

/*
public void custArrives() {
//Initierar (check)
//Skapar id för kunden. (check)
//customer creates new object  to customer. (check)
//Puts the customer in the "shopping" list
if (supermarket.getisOpen()) {
	int id = 0;
	Customer customer = new Customer(id, time);
	id++;
} else if (!(supermarket.getisOpen())) {
	//Missad kund! add counter??
}
*/