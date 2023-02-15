package utility.comparator;

import models.Person;

import java.util.Comparator;

public class PersonLastnameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
       int res = p1.getLastname().toLowerCase().compareTo(p2.getLastname().toLowerCase());
       if (p1.getLastname().equals(p2.getLastname())){
           res = p1.getFirstname().toLowerCase().compareTo(p2.getFirstname().toLowerCase());
       }
        return res;
    }
}
