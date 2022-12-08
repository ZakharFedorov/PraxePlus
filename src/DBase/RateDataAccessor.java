/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBase2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import praxe.Practice;
import praxe.Rate;

/**
 *
 * @author Пользователь
 */
public class RateDataAccessor extends AbstractDataAccessor implements DataAccessor<Rate> {
    
    public Rate saveP(Rate s) throws SQLException {
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
            Rate newRate = new Rate(s);
            
            return newRate;
        }
    }
    
    @Override
    public Rate save(Rate t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Rate t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Rate t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deletePracticeP(Practice p) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = ("DELETE FROM Hodnoceni WHERE rok =? AND tema LIKE ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p.getYear());
            preparedStatement.setString(2, p.getTopic());
            preparedStatement.executeUpdate();
            
        }
    }

    @Override
    public Rate findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rate findByEmailAndPass(String email, String pass) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rate> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
