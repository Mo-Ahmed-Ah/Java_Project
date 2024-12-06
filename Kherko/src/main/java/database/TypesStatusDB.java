package database;

import model.TypesStatus;

import java.util.List;

public interface TypesStatusDB {
    List<TypesStatus> getall();

    model.TypesStatus getStatusByTitle(String statustitle);

    void addstatus(String statustitle);

}
