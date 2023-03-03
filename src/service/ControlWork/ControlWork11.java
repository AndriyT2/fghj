package service.ControlWork;

import models.Role;
import service.PersonService;
import utility.utilityLog.LogFactory;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ControlWork11 {

    public int getPersonTotal() {
        return personTotal;
    }

    private final int personTotal = 10;
    PersonService personServiceCW = new PersonService();


    public void createPerson(){

        int needPerson = personTotal -personServiceCW.countStudent();
        if (needPerson > 0) {
            for (int i = 0; i < needPerson; i++) {
                String lastname = "Lastname" + i;
                String firstname = "Firstname" + i;
                personServiceCW.addPerson(lastname, firstname, Role.STUDENT);
            }
        }
        LogFactory.debug(this.getClass().getName(), "Finish createPerson");
    }
    public int randomTime(){
        return (int) ( Math.random()*7 + 8);
    }

    public Set<Integer> createTask() {

        Set<Integer> task = new LinkedHashSet<>();
        while (task.size() < personTotal) {

            task.add(new Random().nextInt(personTotal)+1);
        }
       LogFactory.debug(this.getClass().getName(), "Finish getTask. Create Task List");
        return task;

    }



}
