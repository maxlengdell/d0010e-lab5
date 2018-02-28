package simulator;

public class RunSim {
    /*
    Programmet skapar ett starttillstånd, definierat av	parametrarna, och en
    händelsekö i vilken	läggs in en	starthändelse, en stängningshändelse och en
    stophändelse. En vy	skapas och läggs till som observatör på	tillståndsobjektet.
    Sen	skapas ett simulatorobjekt, med	hjälp av tillståndet och kön, varpå	dess
    metod run anropas och loopen börjar arbeta.

    stäng och stop läggas in med bestämda tider?
*/

    boolean run = true;
    EventQueue EQ;
    public void run(){
        this.EQ = new EventQueue();
        while(run){
            //get by time??????
           // EQ.eventList.get(0);
        }
    }
    public static void main(String[] args) {
        //Start simulation by client enter --> it will be put in queue and run will handle it

    }

}
