# PraxePlus
![logo](https://github.com/ZakharFedorov/PraxePlus/blob/main/logo.png)


## Výzva
V rámci studia oboru Mechatroniky absolvují studenti praxe ve firmách. Chybí systém, který by umožnil
firmy se studentami propojit.

## Řešení
Systém umožňuje evidovat studentské praxe pro obor Mechatronika. Praxe vypisují
zaregistrované firmy. Po schválení praxe garantem oboru, je tato
přístupná v ponuke pro studenty. Studenti mají možnost si praxe prohlížet a filtrovat. Pokud je některá
zaujme, kontaktují mimo systém garanta oboru a dohodnou realizaci praxe. Garant v systému přiřadí k
praxi studenta a vedoucího práce z fakulty. Po skončení praxe, firma v systému vyplní hodnocení. Firmy, Studenti a Učitelé
se do systému registrují a pak se hlásí pomocí přihlašovacího jména a hesla.



## Návrh databázového schématu
![Návrh databázového schématu](https://github.com/ZakharFedorov/PraxePlus/blob/main/SQLTables/Tables.png)

## Use Case Diagram
![Use Case Diagram](https://github.com/ZakharFedorov/PraxePlus/blob/main/UseCase%20Diagarm.png)

## Použité technologie

1. **Java** - hlavní kód programu.
2. **JavaFX** - design aplikace.
3. **MSSQL** - návrh databáze.
   
## Připojení k databáze
```
package DBase;

public class Config {
    public final static String serverName = "147.230.21.34";
    public final static String databaseName = "DBS2022_ZakharFedorovPraxe3";
    public final static String username = "student";
    public final static String password = "student";
}
```
```
package DBase;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

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
```
## Přiklád SQL Injection
```
public Rate saveP(User s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Hodnoceni (tema, rok, splneni, kvalita, spokojenost_s_pristupem, slovni_hodnoceni) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getTema());
            preparedStatement.setInt(2,s.getRok());
            preparedStatement.setString(3,s.getSpleni());
            preparedStatement.setString(4,s.getKvalita());
            preparedStatement.setString(5,s.getSpokojenost_s_pristupem());
            preparedStatement.setString(6,s.getSlovni_hodnoceni());
            preparedStatement.executeUpdate();
    }
}
```