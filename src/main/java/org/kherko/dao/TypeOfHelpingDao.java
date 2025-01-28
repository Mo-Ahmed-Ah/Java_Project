package org.kherko.dao;

import org.kherko.model.TypeOfHelping;

import java.util.List;

public interface TypeOfHelpingDao {
    void addTypeOfHelping(String name);

    void  deleteTypeOfHelping(int id);

    boolean isTrueId(int id);

    List<TypeOfHelping> getAllType();

}
