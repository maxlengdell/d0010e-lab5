package supermarket;

/**
 *
 * @author Shahin, Max, Johan, Linus
 *
 */

public class Customer {
    int id;
    double timeEnt;
    double queEnt;
    public Customer(int id, double timeEnt){
        // When you create a customer object you assign it an customer id
        this.id = id;
        this.timeEnt = timeEnt;
    }

    public double custExit(double time){
        //return total time in store
        return  time-this.timeEnt;
    }
    // customer enter queue
    public void enterQue(double time){
        this.queEnt=time;
    }
    //customer exit queue return time in queue
    public double exitQue(double time){
        return time-this.queEnt;
    }


}
