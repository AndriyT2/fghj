package service.ControlWork;

import service.PersonService;
import utility.utilityLog.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ControlWork14 {
    ControlWork11 cW11 = new ControlWork11();
    List<Thread> cW13 = new ArrayList<>();
    Set<Integer> task = cW11.createTask();

    PersonService pS = new PersonService();


    private void createControlWork(){
        LogFactory.debug(this.getClass().getName(), "Run createControlWork");
        cW11.createPerson();
        for (int i = 0; i < cW11.getPersonTotal(); i++) {
            cW13.add(new Thread(new ControlWork12((Integer) task.toArray()[i], pS.studentList().get(i).getLastname(), cW11.randomTime())));
        }

    }


    public synchronized void runControlWork() {
        LogFactory.debug(this.getClass().getName(), "Run Control Work");

        createControlWork();

        Thread timeEnd = new Thread(new ControlWork13(12));
        timeEnd.start();

        for (Thread thread : cW13) {
            thread.start();
            }


        try {
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            LogFactory.warning(this.getClass().getName(), "Sleep exception", e.getStackTrace());
        }
    }
}
