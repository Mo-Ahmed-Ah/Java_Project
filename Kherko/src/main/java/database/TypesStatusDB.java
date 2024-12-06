package database;

import java.util.List;

public interface TypesStatusDB {
    List<model.TypesStatus> getall();

    model.TypesStatus getStatusByTitle(String statustitle);

    void addstatus(String statustitle);

}
