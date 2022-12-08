/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBase2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import praxe.KeyWords;
import praxe.Practice;

/**
 *
 * @author Пользователь
 */
public class KeyWordsDataAccessor extends AbstractDataAccessor implements DataAccessor<KeyWords>{

    public KeyWords saveP(KeyWords w) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Klicova_slova (slovo, tema, rok) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,w.getWord());
            preparedStatement.setString(2,w.getTopic());
            preparedStatement.setInt(3,w.getRok());
            preparedStatement.executeUpdate();
            KeyWords newKeyWords = new KeyWords(w);
            
            return newKeyWords;
        }
    }
    
    public void deleteP(List<KeyWords> wlist) throws SQLException{
        try(Connection connection = dataSource.getConnection()){
            for(int i =0; i<wlist.size();i++){
                String sql = ("DELETE FROM Klicova_slova WHERE rok =? AND tema LIKE ? AND slovo LIKE ?");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, wlist.get(i).getRok());
                preparedStatement.setString(2, wlist.get(i).getTopic());
                preparedStatement.setString(3, wlist.get(i).getWord());
                preparedStatement.executeUpdate();
            }
        }
    }
    
    public void deletePracticeP(Practice p) throws SQLException{
        try(Connection connection = dataSource.getConnection()){
            String sql = ("DELETE FROM Klicova_slova WHERE rok =? AND tema LIKE ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p.getYear());
            preparedStatement.setString(2, p.getTopic());
            preparedStatement.executeUpdate();
            
        }
    }
    
    @Override
    public KeyWords save(KeyWords t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(KeyWords t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(KeyWords t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyWords findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyWords findByEmailAndPass(String email, String pass) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<KeyWords> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<KeyWords> findAllFromPractice(Practice p) throws SQLException {
      try(Connection connection = dataSource.getConnection()){
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT slovo, tema, rok FROM Klicova_slova WHERE tema LIKE '"+p.getTopic()+"'"); 
            List<KeyWords> KeyWordsList = new ArrayList<>();
            while (rs.next()) {
                String slovo = rs.getString("slovo");
                String tema = rs.getString("tema");
                int rok = rs.getInt("rok"); 
                
                KeyWords keywords = new KeyWords(slovo, tema, rok);
                KeyWordsList.add(keywords);
            }
            return KeyWordsList;
      }
    }
}
