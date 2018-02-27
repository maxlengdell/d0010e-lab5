package supermarket;

public class Customer {
    int id;
    double timeEnt;
    double que;
    public Customer(int id, double timeEnt){
        // When you create a customer object you assign it an customer id
        this.id = id;
        this.timeEnt = timeEnt;
    }

    public double custExit(double time){
        //return total time in store
        return this.timeEnt - time;
    }


}
