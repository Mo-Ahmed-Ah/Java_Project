package database;

import model.Status;


import java.util.Date;
import java.util.List;

public interface StatusDB {
    List<Status> getAll();
    Status getStatusById(int id);
    List<Status> getStatusByName(String name);
    Status getStatusByPhone(String phone);
    List<Status> getStatusByNickname(String nickname);
    List<Status> getStatusByLocation(String location);
    List<Status> getStatusByJoundate(Date joundate);
    List<Status> getStatusByGender(boolean gender);
    Status getStatusByGid(int gid);
    void addStatus(Status status);
    void updateStatus(Status status);
    void deleteStatus(int id);

}
