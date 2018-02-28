package simulator;

public class RunSim {
    boolean run = true;
    EventQueue EQ;
    public void run(){
        this.EQ = new EventQueue();
        while(run){
            //get by time??????
            EQ.eventList.get(0);

        }
    }

    public static void main(String[] args) {
        //Start simulation by client enter --> it will be put in queue and run will handle it
        Event e = new Event();
        e.custArrives();
    }

}
