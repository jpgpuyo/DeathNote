package com.jpuyo.deathnote.database.daos;

import java.util.Collection;
import java.util.List;

public interface GenericDao<T, ID> {
    T findByPrimaryKey(ID id);
    List<T> findAllFromPlayer(int playerId);
    T save(T entity);
    int update(T entity);
    int delete(T entity);
    int delete(Collection<T> entityList);
    int refresh(T entity);
    void deleteAll();
}
