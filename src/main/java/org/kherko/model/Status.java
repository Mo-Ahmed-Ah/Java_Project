package org.kherko.model;

public class Status {
    private int id;
    private String stat_name;

    public Status() {}
    public Status(int id, String stat_name) {
        this.id = id;
        this.stat_name = stat_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStat_name() {
        return stat_name;
    }

    public void setStat_name(String stat_name) {
        this.stat_name = stat_name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", stat_name='" + stat_name + '\'' +
                '}';
    }
}
