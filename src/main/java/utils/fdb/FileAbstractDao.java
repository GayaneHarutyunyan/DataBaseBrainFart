package utils.fdb;

import accesors.FileDataSourceAccessor;
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

