package dao;

import models.Model;

import java.util.List;

/**
 * Created by gaya on 11.06.2016.
 */
public interface ItemDao<T extends Model> {

    public List<T> getAll();

    public T getById(Long id);

    public void add(T model);

    public void update(T model);

    public void remove(T model);

}
