/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBase;

import java.sql.SQLException;
import java.util.List;

/**
 * Generic data accessor specifying required methods
 * @author JV
 * @param <T>
 */
public interface DataAccessor<T> {
    public T save(T t) throws SQLException; //insert
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    public T findById(int id) throws SQLException;
    public T findByEmailAndPass(String email, String pass) throws SQLException;
    public List<T> findAll()throws SQLException;
}
