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
    double exitQue;
    double exitStore;
    // When you create a customer object you assign it a customer id and time of entry
    public Customer(int id, double timeEnt){
        this.id = id;
        this.timeEnt = timeEnt;
    }

    //time roaming in store, time enter until in que == roam
    public double roaming(double Roamtime){
        return Roamtime - this.timeEnt;
    }

    //return total time in store
    public double custExit(double time){
        exitStore = time-timeEnt;
        return exitStore;
    }
    // customer enter queue this ends roam and returns it. Could change this and make it separate.
    public double enterQue(double time){
        double roamTime = roaming(time);
        queEnt=time;
        return roamTime;
    }
    //customer exit queue return time in queue
    public double exitQue(double time){
        exitQue = time-queEnt;
        return exitQue;
    }

    //time paying and scanning: from exit que to exit store. Nullpointer dangerZONE
    public double getPaytime(){
        return exitStore - exitQue;
    }


}
