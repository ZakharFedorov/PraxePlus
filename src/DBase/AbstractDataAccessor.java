package DBase;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author Zakhar Fedorov
 */
public class AbstractDataAccessor {

    protected SQLServerDataSource dataSource;
    
    public AbstractDataAccessor() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName(Config.serverName);
        dataSource.setDatabaseName(Config.databaseName);
        dataSource.setUser(Config.username);
        dataSource.setPassword(Config.password);        
    }
}
