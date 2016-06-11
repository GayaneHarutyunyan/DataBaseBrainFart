package accesors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by gaya on 11.06.2016.
 */
public abstract class FileDataSourceAccessor {


    public BufferedReader load() throws FileNotFoundException {

        File file = new File(this.getDataSourceName());
        return new BufferedReader(new FileReader(file));
    }

    //получить имя источника данных
    public abstract String getDataSourceName();
}
