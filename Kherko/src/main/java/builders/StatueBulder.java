package builders;

import model.Statue;
import model.TypesStatus;

public class StatueBulder {
    private int typestatus_id;
    private int people_id;

    public StatueBulder typestatus_id(int typestatus_id){
        this.typestatus_id = typestatus_id;
        return this;
    }
    public StatueBulder people_id(int people_id){
        this.people_id = people_id;
        return this;
    }

    public StatueBulder build(){
        return new Statue(typestatus_id , people_id);
    }
}
