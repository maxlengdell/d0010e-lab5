package simulator;

<<<<<<< HEAD:src/simulator/Simulator.java
public class Simulator {
    boolean run = true;
    EventQueue EQ;
    public void run(){
        this.EQ = new EventQueue();
        while(run){
            //get by time??????
            EQ.eventList.get(0);

        }
    }
=======
public class RunSim {
>>>>>>> bc8bc21ed92ae0a74fad0cbdbdfce2b4017f0443:src/simulator/RunSim.java
    public static void main(String[] args) {
        //Start simulation by client enter --> it will be put in queue and run will handle it
        Event e = new Event();
        e.custArrives();
    }

}
