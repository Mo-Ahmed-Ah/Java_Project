package org.kherko.dao;

import org.kherko.model.Status;

import java.util.List;

public interface StatusDao {
    List<Status> getAll();

    String getNameByID(int id);

    void addStatus(String sta_name);

    void deleteStatus(int id);

    boolean isTrueID(int id);
}
