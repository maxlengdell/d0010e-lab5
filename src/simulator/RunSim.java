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

    }

}
