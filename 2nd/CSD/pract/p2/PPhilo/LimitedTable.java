// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    int philos = 0;

    public LimitedTable(StateManager state) {super(state);}

    public synchronized void enter(int id) throws InterruptedException {
        while(philos == 4) { wait(); }
        philos++;
    }

    public synchronized void exit(int id)  { philos--; }
}
