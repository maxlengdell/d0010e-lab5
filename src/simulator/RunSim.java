package simulator;

import random.ExponentialRandomStream;
import supermarket.EventArrival;
import supermarket.SuperMarket;

public class RunSim {
    /*
    So basically we get a generated time from the randomgen. This value is gonna be passed to the respective event.
    Example exponential has the random lambda generator. Event has to call this and get the value somehow?
    Every ArrivalEvent is to generate the next arrival event aswell. So arrival event has to call for exporandom
*/
    //When we get the stop signal we set run to false!



    public static void run(EventQueue EQ, SuperMarket S){
        while(S.getisActive()){
            //get next event in queue and execute
            EQ.eventList.get(0).Execute();
        }
    }

    public static void main(String[] args) {
        //Start simulation by calling for the arrival event -> will put in Eque and all will start
        //Create all objects for the constructors give supermarket EQ and give supermarket to EA
        EventQueue EQ = new EventQueue();
        SuperMarket SM = new SuperMarket(0,true,EQ);
        EventArrival EA = new EventArrival(0,SM);
        EA.execute();
        //now run eventQueue
        run(EQ,SM);


    }

}
