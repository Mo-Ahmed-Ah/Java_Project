package org.kherko.model;

public class TypeOfHelping {
    private int id;
    private String helpingName;

    public TypeOfHelping() {
    }

    public TypeOfHelping(int id, String helpingName) {
        this.id = id;
        this.helpingName = helpingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHelpingName() {
        return helpingName;
    }

    public void setHelpingName(String helpingName) {
        this.helpingName = helpingName;
    }

    @Override
    public String toString() {
        return "TypeOfHelping{" +
                "id=" + id +
                ", helpingName='" + helpingName + '\'' +
                '}';
    }
}
