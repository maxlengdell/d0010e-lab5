package supermarket;

/**
 *
 * @author Shahin, Max, Johan, Linus
 *
 */

/**This class describes a customer*/
public class Customer {
    int id;
    double timeEnt;
    double queEnt;
    double exitQue;
    double exitStore;
    // When you create a customer object you assign it a customer id and time of entry
    /**Constructor for the class Customer. When a customer object is created it is assigned a customer ID and 
     * a time of entering the supermarket. /**
     * 
     */
    /**
     * 
     * @param id
     * @param timeEnt
     */
    public Customer(int id, double timeEnt){
        this.id = id;
        this.timeEnt = timeEnt;
    }

    //time roaming in supermarket, time enter until in queue == roam
    /**This method returns the time that a customer is roaming the supermarket until the customer enters the cash register queue*/
    /**
     * 
     * @param Roamtime
     * @return
     */
    public double roaming(double Roamtime){
        return Roamtime - this.timeEnt;
    }

    //return total time in store
    /**This method returns how long the customer has been in the supermarket when leaving*/
    /**
     * 
     * @param time
     * @return
     */
    public double custExit(double time){
        exitStore = time-timeEnt;
        return exitStore;
    }
    // customer enter queue this ends roam and returns it. Could change this and make it separate.
    /**This method makes a customer enter a cash register queue. It also returns the time a customer has spent roaming*/
    /**
     * 
     * @param time
     * @return
     */
    public double enterQue(double time){
        double roamTime = roaming(time);
        queEnt=time;
        return roamTime;
    }
    //customer exit queue return time in queue
    /**This method returns the time a customer has spent in the queue and also makes a customer exit the supermarket*/
    /**
     * 
     * @param time
     * @return
     */
    public double exitQue(double time){
        exitQue = time-queEnt;
        return exitQue;
    }

    //time paying and scanning: from exit que to exit store. Nullpointer dangerZONE
    /**This method returns the time spent paying in the cash register*/
    /**
     * 
     * @return
     */
    public double getPaytime(){
        return exitStore - exitQue;
    }
    /**This method returns the customer ID*/
    /**
     * 
     * @return
     */
    public int getID(){
        return id;
    }


}
