package accesors;


import javax.sql.DataSource;

/**
 * Created by gaya on 11.06.2016.
 */
public abstract class DatabaseDataSourceAccessor {


    public DataSource load() {
        return null;
    }

    public abstract String getHost();

    public abstract int getPort();
}
