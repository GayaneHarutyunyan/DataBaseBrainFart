package dao;

import models.Model;

import java.util.List;

/**
 * Created by gaya on 11.06.2016.
 */
public interface ItemDao<T extends Model> {

    List<T> getAll();

    T getById(Long id);

    void add(T model);

    void update(T model);

    void remove(T model);
}
