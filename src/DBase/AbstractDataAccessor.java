/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBase2;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author JV
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
