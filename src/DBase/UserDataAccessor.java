package DBase;

import praxe.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDataAccessor extends AbstractDataAccessor implements DataAccessor<User>{
            
    // in real projects, use a connection pool....

    @Override
    public List<User> findAll() throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public List<User> findAllStudents() throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Uzivatel WHERE role LIKE 'student'"); 
            List<User> studentsList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id_uziv");
                String fname = rs.getString("jmeno");
                String lname = rs.getString("prijmeni");
                int rok = rs.getInt("rocnik");
                String fakulta = rs.getString("fakulta");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String heslo = rs.getString("heslo");
                User student = new User(id, fname, lname, rok, fakulta, email, role, heslo);
                studentsList.add(student);
            }
            return studentsList;
        }
    }
    
    public List<User> findAllTeachers() throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();                 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Uzivatel WHERE role LIKE 'ucitel'"); 
            List<User> teacherList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id_uziv");
                String fname = rs.getString("jmeno");
                String lname = rs.getString("prijmeni");
                int rok = rs.getInt("rocnik");
                String fakulta = rs.getString("fakulta");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String heslo = rs.getString("heslo");
                User teacher = new User(id, fname, lname, rok, fakulta, email, role, heslo);
                teacherList.add(teacher);
            }
            return teacherList;
        }
    }
    
    @Override
    public User findById(int id) throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement(); 
            String sql = ("SELECT id_uziv, jmeno, prijmeni, rocnik, fakulta, email, role, heslo FROM Uzivatel WHERE id_uziv = " + id);
            ResultSet resultSet = stmnt.executeQuery(sql); 
        
            if(resultSet.next()){
                User s = new User();
                s.setId(id);
                s.setFirstName(resultSet.getString("jmeno"));
                s.setLastName(resultSet.getString("prijmeni"));
                s.setYear_of_study(resultSet.getInt("rocnik"));
                s.setFaculty(resultSet.getString("fakulta"));
                s.setEmail(resultSet.getString("email"));
                s.setRole(resultSet.getString("role"));
                s.setHeslo(resultSet.getString("heslo"));
                
                return s;
            }
            else {
                return null;
            }
        }
    }
    @Override
    public User findByEmailAndPass(String email, String pass) throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement(); 
            String sql = ("SELECT id_uziv, jmeno, prijmeni, rocnik, fakulta, email, role, heslo FROM Uzivatel WHERE email LIKE '" + email + "' AND heslo = HASHBYTES('md5', '" + pass+"')");
            System.out.println(sql);
            ResultSet resultSet = stmnt.executeQuery(sql); 
        
            if(resultSet.next()){
                User s = new User();
                s.setId(resultSet.getInt("id_uziv"));
                s.setFirstName(resultSet.getString("jmeno"));
                s.setLastName(resultSet.getString("prijmeni"));
                s.setYear_of_study(resultSet.getInt("rocnik"));
                s.setFaculty(resultSet.getString("fakulta"));
                s.setEmail(resultSet.getString("email"));
                s.setRole(resultSet.getString("role"));
                s.setHeslo(resultSet.getString("heslo"));
                
                return s;
            }
            else {
                return null;
            }
        }
    }

    @Override
    public User save(User s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();
            String name = s.getFirstName();
            String lname = s.getLastName();
            int rok = s.getYear_of_study();
            String fakulta = s.getFaculty();
            String mail = s.getEmail();
            String role = s.getRole();
            String heslo = s.getHeslo();
            String sql = String.format("INSERT INTO Uzivatel (jmeno, prijmeni, rocnik, fakulta, email, role, heslo) VALUES ('%s', '%s', %d, '%s', '%s', '%s', HASHBYTES('md5','%s'))", name, lname, rok, fakulta, mail, role, heslo);
            
            stmnt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = stmnt.getGeneratedKeys();
            User newUser = new User(s);
            if(resultSet.next()){
                newUser.setId(resultSet.getInt(1));
            }
            return newUser;
        }
    }
    
    public User saveP(User s) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "INSERT INTO Uzivatel (jmeno, prijmeni, rocnik, fakulta, email, role, heslo) VALUES (?,?,?,?,?,?, HASHBYTES('md5', ?))";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,s.getFirstName());
            preparedStatement.setString(2,s.getLastName());
            preparedStatement.setInt(3,s.getYear_of_study());
            preparedStatement.setString(4,s.getFaculty());
            preparedStatement.setString(5,s.getEmail());
            preparedStatement.setString(6,s.getRole());
            preparedStatement.setString(7,s.getHeslo());
            System.out.println(s.getHeslo());
            preparedStatement.executeUpdate();
            User newUser = new User(s);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                newUser.setId(resultSet.getInt(1));
            }
            return newUser;
        }
    }

    @Override
    public void delete(User s) throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            Statement stmnt = connection.createStatement();
            int id = s.getId();
            String sql = ("DELETE FROM Uzivatel WHERE id_uziv = " + id);
            stmnt.executeUpdate(sql);
        }
    }
    
    public void deleteP(User s) throws SQLException{
        try(Connection connection = dataSource.getConnection()){       
            String sql = "DELETE FROM Uzivatel WHERE id_uziv =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, s.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
