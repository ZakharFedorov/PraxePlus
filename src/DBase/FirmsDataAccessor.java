/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBase2;

import praxe.Firms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Пользователь
 */
public class FirmsDataAccessor extends AbstractDataAccessor implements DataAccessor<Firms> {

    public Firms saveP(Firms s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Firmy (nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) VALUES (?,?,?,?,?,HASHBYTES('md5', ?),?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getName());
            preparedStatement.setString(2,s.getBranch_office());
            preparedStatement.setString(3,s.getFirst_name_cp());
            preparedStatement.setString(4,s.getLast_name_cp());
            preparedStatement.setString(5,s.getEmail_cp());
            preparedStatement.setString(6,s.getPassword_cp());
            preparedStatement.setString(7,s.getCity());
            preparedStatement.executeUpdate();
            Firms newFirms = new Firms(s);
            return newFirms;
        }
    }
    
    @Override
    public Firms save(Firms t) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();
            String FirmName = t.getName();
            String pobocka = t.getBranch_office();
            String nameCP = t.getFirst_name_cp();
            String lnameCP = t.getLast_name_cp();
            String mailCP = t.getEmail_cp();
            String passCP = t.getPassword_cp();
            String city = t.getCity();
            String sql = String.format("INSERT INTO Firmy (nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) VALUES ('%s', '%s', '%s', '%s', '%s', HASHBYTES('md5','%s'), '%s')", FirmName, pobocka, nameCP, lnameCP, mailCP, passCP, city);
            
            stmnt.executeUpdate(sql);
            Firms newFirms = new Firms(t);
            
            return newFirms;
        }
    }

    @Override
    public void delete(Firms t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Firms findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Firms findByEmailAndPass(String email, String pass) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement(); 
            String sql = ("SELECT nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto FROM Firmy WHERE email_KO LIKE '" + email + "' AND heslo_KO = HASHBYTES('md5', '" + pass+"')");
            System.out.println(sql);
            ResultSet resultSet = stmnt.executeQuery(sql); 
        
            if(resultSet.next()){
                Firms s = new Firms();
                s.setName(resultSet.getString("nazev_firmy"));
                s.setFirst_name_cp(resultSet.getString("jmeno_KO"));
                s.setLast_name_cp(resultSet.getString("prijmeni_KO"));
                s.setBranch_office(resultSet.getString("pobocka"));
                s.setEmail_cp(resultSet.getString("email_KO"));
                s.setPassword_cp(resultSet.getString("heslo_KO"));
                s.setCity(resultSet.getString("mesto"));
                
                return s;
            }
            else {
                return null;
            }
        }
    }

    @Override
    public List<Firms> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Firms t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
