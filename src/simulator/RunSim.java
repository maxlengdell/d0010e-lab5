package simulator;

import random.ExponentialRandomStream;

public class RunSim {
    /*
    So basically we get a generated time from the randomgen. This value is gonna be passed to the respective event.
    Example exponential has the random lambda generator. Event has to call this and get the value somehow?

*/
    //When we get the stop signal we set run to false!



    State S;
    EventQueue EQ;
    public void run(){
        this.EQ = new EventQueue();
        while(S.getisActive()){
            //get next event in queue and execute
            EQ.eventList.get(0).Execute();
        }
    }
    public static void main(String[] args) {
        //Start simulation by client enter --> it will be put in queue and run will handle it
        ExponentialRandomStream exp = new ExponentialRandomStream(1,1234);
        System.out.println("rand value: "+exp.next());


    }

}
