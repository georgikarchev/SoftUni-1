package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> date;
    private Integer id;

    public Repository(){
        this.date = new HashMap<>();
        this.id = 0;
    }

    public void add(Person person){
        this.date.put(this.id, person);
        this.id++;
    }

    public Person get(int idOfPerson){
        return this.date.get(idOfPerson);
    }

    public boolean update(int idOfPerson, Person newPerson){
        if(this.date.containsKey(idOfPerson)){
            this.date.put(idOfPerson, newPerson);
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(int idOfPerson){
        if(this.date.containsKey(idOfPerson)){
            this.date.remove(idOfPerson);
            return true;
        }
        return false;
    }

    public int getCount(){
        return this.date.size();
    }


}
