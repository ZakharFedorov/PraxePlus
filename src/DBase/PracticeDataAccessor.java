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
import praxe.Practice;
import praxe.User;

/**
 *
 * @author Пользователь
 */
public class PracticeDataAccessor extends AbstractDataAccessor implements DataAccessor<Practice>{

    public Practice saveNewP(Practice s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, rok) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getTopic());
            preparedStatement.setString(2,s.getDescription());
            preparedStatement.setString(3,s.getRequirement());
            preparedStatement.setString(4,s.getCity());
            preparedStatement.setString(5,s.getOrientation());
            preparedStatement.setInt(6,s.getState());
            preparedStatement.setString(7,s.getConsult_first_name());
            preparedStatement.setString(8,s.getConsult_last_name());
            preparedStatement.setString(9,s.getConsult_email());
            preparedStatement.setString(10,s.getFirm_name());
            preparedStatement.setInt(11,s.getYear());
            preparedStatement.executeUpdate();
            Practice newPractice = new Practice(s);
            
            return newPractice;
        }
    }
    
    public Practice saveP(Practice s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getTopic());
            preparedStatement.setString(2,s.getDescription());
            preparedStatement.setString(3,s.getRequirement());
            preparedStatement.setString(4,s.getCity());
            preparedStatement.setString(5,s.getOrientation());
            preparedStatement.setInt(6,s.getState());
            preparedStatement.setString(7,s.getConsult_first_name());
            preparedStatement.setString(8,s.getConsult_last_name());
            preparedStatement.setString(9,s.getConsult_email());
            preparedStatement.setString(10,s.getFirm_name());
            preparedStatement.setInt(11,s.getStudent_id());
            preparedStatement.setInt(12,s.getTeacher_id());
            preparedStatement.setInt(13,s.getYear());
            preparedStatement.executeUpdate();
            Practice newPractice = new Practice(s);
            
            return newPractice;
        }
    }
    
    @Override
    public Practice save(Practice t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Practice t) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            String sql = ("UPDATE Praxe SET stav=1 WHERE stav =? AND tema LIKE ? AND Firmy_nazev_firmy LIKE ? AND popis LIKE ? AND pozadavky LIKE ? AND misto_vykonu LIKE ? AND zamereni LIKE ? AND jmeno_konzultanta LIKE ? AND prijmeni_konzultanta LIKE ? AND rok=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, t.getState());
            preparedStatement.setString(2, t.getTopic());
            preparedStatement.setString(3, t.getFirm_name());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setString(5, t.getRequirement());
            preparedStatement.setString(6, t.getCity());
            preparedStatement.setString(7, t.getOrientation());
            preparedStatement.setString(8, t.getConsult_first_name());
            preparedStatement.setString(9, t.getConsult_last_name());
            preparedStatement.setInt(10, t.getYear());
            preparedStatement.executeUpdate();
        }
    }
    
    public void update2(Practice t, User s, User u) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            String sql = ("UPDATE Praxe SET stav=2, id_studenta =?, id_ucitele=? WHERE stav =? AND tema LIKE ? AND Firmy_nazev_firmy LIKE ? AND popis LIKE ? AND pozadavky LIKE ? AND misto_vykonu LIKE ? AND zamereni LIKE ? AND jmeno_konzultanta LIKE ? AND prijmeni_konzultanta LIKE ? AND rok=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, s.getId());
            preparedStatement.setInt(2, u.getId());
            preparedStatement.setInt(3, t.getState());
            preparedStatement.setString(4, t.getTopic());
            preparedStatement.setString(5, t.getFirm_name());
            preparedStatement.setString(6, t.getDescription());
            preparedStatement.setString(7, t.getRequirement());
            preparedStatement.setString(8, t.getCity());
            preparedStatement.setString(9, t.getOrientation());
            preparedStatement.setString(10, t.getConsult_first_name());
            preparedStatement.setString(11, t.getConsult_last_name());
            preparedStatement.setInt(12, t.getYear());
            preparedStatement.executeUpdate();
        }
    }
    
    public void update3(Practice t) throws SQLException {
        try(Connection connection = dataSource.getConnection()){   
            String sql = ("UPDATE Praxe SET stav=3 WHERE stav =2 AND tema LIKE ? AND Firmy_nazev_firmy LIKE ? AND popis LIKE ? AND pozadavky LIKE ? AND misto_vykonu LIKE ? AND zamereni LIKE ? AND jmeno_konzultanta LIKE ? AND prijmeni_konzultanta LIKE ? AND rok=? AND id_studenta=? AND id_ucitele=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getTopic());
            preparedStatement.setString(2, t.getFirm_name());
            preparedStatement.setString(3, t.getDescription());
            preparedStatement.setString(4, t.getRequirement());
            preparedStatement.setString(5, t.getCity());
            preparedStatement.setString(6, t.getOrientation());
            preparedStatement.setString(7, t.getConsult_first_name());
            preparedStatement.setString(8, t.getConsult_last_name());
            preparedStatement.setInt(9, t.getYear());
            preparedStatement.setInt(10, t.getStudent_id());
            preparedStatement.setInt(11, t.getTeacher_id());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Practice t) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();
            int stav = t.getState();
            String tema = t.getTopic();
            String firma = t.getFirm_name();
            String popis = t.getDescription();
            String pozadavky = t.getRequirement();
            String mesto = t.getCity();
            String zamereni = t.getOrientation();
            String jmeno = t.getConsult_first_name();
            String prijmeni = t.getConsult_last_name();
            int rok = t.getYear();
            
                    //delete from dd from (select top 1 * from Praxe where stav=2) dd
            String sql = ("DELETE FROM dd FROM (SELECT TOP 1 * FROM Praxe WHERE stav =" + stav + " AND tema LIKE '"+tema+"' AND Firmy_nazev_firmy LIKE '"+firma+"' AND popis LIKE '"+popis+"' AND pozadavky LIKE '"+pozadavky+"' AND misto_vykonu LIKE '"+mesto+"' AND zamereni LIKE '"+zamereni+"' AND jmeno_konzultanta LIKE '"+jmeno+"' AND prijmeni_konzultanta LIKE '"+prijmeni +"' AND rok="+rok+") dd ");
            stmnt.executeUpdate(sql);
        }
    }
    
    public void deleteP(Practice t) throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            String sql = ("DELETE FROM dd FROM (SELECT TOP 1 * FROM Praxe WHERE stav =? AND tema LIKE ? AND Firmy_nazev_firmy LIKE ? AND popis LIKE ? AND pozadavky LIKE ? AND misto_vykonu LIKE ? AND zamereni LIKE ? AND jmeno_konzultanta LIKE ? AND prijmeni_konzultanta LIKE ? AND rok=?) dd ");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, t.getState());
            preparedStatement.setString(2, t.getTopic());
            preparedStatement.setString(3, t.getFirm_name());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setString(5, t.getRequirement());
            preparedStatement.setString(6, t.getCity());
            preparedStatement.setString(7, t.getOrientation());
            preparedStatement.setString(8, t.getConsult_first_name());
            preparedStatement.setString(9, t.getConsult_last_name());
            preparedStatement.setInt(10, t.getYear());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Practice findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Practice findByEmailAndPass(String email, String pass) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Practice> findAll() throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Praxe"); 
            List<Practice> PracticeList = new ArrayList<>();
            while (rs.next()) {
                String topic = rs.getString("tema"); //by column name
                String description = rs.getString("popis");
                String requirement = rs.getString("pozadavky"); //by column number - prumer
                String city = rs.getString("misto_vykonu");
                String orientation = rs.getString("zamereni");
                int state = rs.getInt("stav");
                String cons_name = rs.getString("jmeno_konzultanta");
                String cons_sername = rs.getString("prijmeni_konzultanta");
                String cons_email = rs.getString("email_konzultanta");
                String firm_name = rs.getString("Firmy_nazev_firmy");
                int student_id = rs.getInt("id_studenta");
                int teacher_id = rs.getInt("id_ucitele");
                int year = rs.getInt("rok");
                
                Practice practice = new Practice(topic, description, requirement, city, orientation, state, cons_name, cons_sername, cons_email, firm_name, student_id, teacher_id, year);
                PracticeList.add(practice);
            }
            return PracticeList;
        }
    }
    
    public List<Practice> findAllWhereFirm(String firmName) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Praxe WHERE Firmy_nazev_firmy LIKE '"+firmName+"'"); 
            List<Practice> PracticeList = new ArrayList<>();
            while (rs.next()) {
                String topic = rs.getString("tema"); //by column name
                String description = rs.getString("popis");
                String requirement = rs.getString("pozadavky"); //by column number - prumer
                String city = rs.getString("misto_vykonu");
                String orientation = rs.getString("zamereni");
                int state = rs.getInt("stav");
                String cons_name = rs.getString("jmeno_konzultanta");
                String cons_sername = rs.getString("prijmeni_konzultanta");
                String cons_email = rs.getString("email_konzultanta");
                String firm_name = rs.getString("Firmy_nazev_firmy");
                int student_id = rs.getInt("id_studenta");
                int teacher_id = rs.getInt("id_ucitele");
                int year = rs.getInt("rok");
                
                Practice practice = new Practice(topic, description, requirement, city, orientation, state, cons_name, cons_sername, cons_email, firm_name, student_id, teacher_id, year);
                PracticeList.add(practice);
            }
            return PracticeList;
        }
    }
    
    public List<Practice> findAllWhereStudent(int sid) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Praxe WHERE id_studenta = "+sid); 
            List<Practice> PracticeList = new ArrayList<>();
            while (rs.next()) {
                String topic = rs.getString("tema");
                String description = rs.getString("popis");
                String requirement = rs.getString("pozadavky");
                String city = rs.getString("misto_vykonu");
                String orientation = rs.getString("zamereni");
                int state = rs.getInt("stav");
                String cons_name = rs.getString("jmeno_konzultanta");
                String cons_sername = rs.getString("prijmeni_konzultanta");
                String cons_email = rs.getString("email_konzultanta");
                String firm_name = rs.getString("Firmy_nazev_firmy");
                int student_id = rs.getInt("id_studenta");
                int teacher_id = rs.getInt("id_ucitele");
                int year = rs.getInt("rok");
                
                Practice practice = new Practice(topic, description, requirement, city, orientation, state, cons_name, cons_sername, cons_email, firm_name, student_id, teacher_id, year);
                PracticeList.add(practice);
            }
            return PracticeList;
        }
    }
    
    public List<Practice> findAllWhereStudentStateOne() throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Praxe WHERE stav = 1"); 
            List<Practice> PracticeList = new ArrayList<>();
            while (rs.next()) {
                String topic = rs.getString("tema");
                String description = rs.getString("popis");
                String requirement = rs.getString("pozadavky");
                String city = rs.getString("misto_vykonu");
                String orientation = rs.getString("zamereni");
                int state = rs.getInt("stav");
                String cons_name = rs.getString("jmeno_konzultanta");
                String cons_sername = rs.getString("prijmeni_konzultanta");
                String cons_email = rs.getString("email_konzultanta");
                String firm_name = rs.getString("Firmy_nazev_firmy");
                int student_id = rs.getInt("id_studenta");
                int teacher_id = rs.getInt("id_ucitele");
                int year = rs.getInt("rok");
                
                Practice practice = new Practice(topic, description, requirement, city, orientation, state, cons_name, cons_sername, cons_email, firm_name, student_id, teacher_id, year);
                PracticeList.add(practice);
            }
            return PracticeList;
        }
    }
    
}
