package builders;

import model.TypesStatus;

public class TypesStatusBulder {
    private int id;
    private String statustitle;

    public TypesStatusBulder id(int id){
        this.id = id;
        return this;
    }
    public TypesStatusBulder statustitle(String statustitle){
        this.statustitle = statustitle;
        return this;
    }

    public TypesStatus build(){
        return new TypesStatus(id , statustitle);
    }


}
