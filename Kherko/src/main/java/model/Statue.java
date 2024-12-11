package model;

import builders.StatueBulder;
import builders.TypesStatusBulder;

public class Statue {
    private int typestatus_id;
    private int people_id;

    public int getTypestatus_id() {
        return typestatus_id;
    }

    public void setTypestatus_id(int typestatus_id) {
        this.typestatus_id = typestatus_id;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "typestatus_id=" + typestatus_id +
                ", people_id=" + people_id +
                '}';
    }

    public static StatueBulder builder(){
        return new StatueBulder();
    }
}
