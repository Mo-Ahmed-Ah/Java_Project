package model;

import builders.TypesStatusBulder;

public class TypesStatus {
    private int id;
    private String statustitle;

    public TypesStatus(){

    }

    public TypesStatus(int id , String statustitle){
        this.id = id;
        this.statustitle = statustitle;
    }
    public String getStatustitle() {
        return statustitle;
    }

    public void setStatustitle(String statustitle) {
        this.statustitle = statustitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypesStatus{" +
                "id=" + id +
                ", statustitle='" + statustitle + '\'' +
                '}';
    }

    public static TypesStatusBulder builder(){
        return new TypesStatusBulder();
    }
}
