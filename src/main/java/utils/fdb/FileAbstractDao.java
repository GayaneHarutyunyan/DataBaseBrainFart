package utils.fdb;

import utils.FileDataSourceAccessor;
import models.Model;


public abstract class FileAbstractDao<T extends Model> extends FileDataSourceAccessor{

    public void add(T model) {

    }

    public void update(T model) {

    }



    public void remove(T model){
    //    this.remove(model.getId());
    }

}

