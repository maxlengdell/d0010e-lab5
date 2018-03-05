package simulator;
/**
*
* @author Shahin, Max, Johan, Linus
*
*/
import supermarket.*;

public class RunSim {
    /*
    So basically we get a generated time from the randomgen. This value is going to be passed to the respective event.
    Example exponential has the random lambda generator. Event has to call this and get the value somehow?
    Every ArrivalEvent is to generate the next arrival event as well. So arrival event has to call for exporandom
*/
    //When we get the stop signal we set run to false!



    public static void run(EventQueue eq, SuperMarket S){
        while(S.getisActive()){
            //get next event in queue and execute
            if (!eq.executeNext()) {
            	break;
            }
        }
    }

    public static void main(String[] args) {
        //Start simulation by calling for the arrival event -> will put in Eque and all will start
        //Create all objects for the constructors give supermarket EQ and give supermarket to EA
        EventQueue eq = new EventQueue();
        
        SuperMarket sm = new SuperMarket(0,true,eq, 0.5,10,2,8.0);
        SuperMarketView smView = new SuperMarketView(sm);
        
        eq.addEvent(new EventOpen(sm, 0));
        double time = sm.getRnG().getRnGExponential();
        eq.addEvent(new EventArrival(time, sm));
        eq.addEvent(new EventClose(8, sm));
        
        //now run eventQueue
        run(eq,sm);


    }

}
