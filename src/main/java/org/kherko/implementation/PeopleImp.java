package org.kherko.implementation;

import org.kherko.dao.PeopleDao;
import org.kherko.model.People;

import java.util.List;

public class PeopleImp implements PeopleDao
{

    @Override
    public List<People> getAll() {
        return List.of();
    }

    @Override
    public People getById(int id) {
        return null;
    }

    @Override
    public List<People> getByName(String name) {
        return List.of();
    }

    @Override
    public List<People> getByNickname(String nickname) {
        return List.of();
    }

    @Override
    public List<People> getByLocation(String location) {
        return List.of();
    }

    @Override
    public People getByPhone(String phone) {
        return null;
    }

    @Override
    public People getByGid(String gid) {
        return null;
    }

    @Override
    public List<People> getByGender(String gender) {
        return List.of();
    }

    @Override
    public List<People> getByJoinDate(String joinDate) {
        return List.of();
    }

    @Override
    public void addPerson(People person) {

    }

    @Override
    public void updatePerson(People person) {

    }

    @Override
    public void deletePerson(int id) {

    }
}
