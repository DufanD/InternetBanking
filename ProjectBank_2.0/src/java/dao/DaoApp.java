/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;


/**
 *
 * @author Diend
 * @param <T>
 * @param <ID>
 */
public interface DaoApp <ID, T> {
    public void save(T t);
    
    public void delete(ID id);
    
    public T findById(ID id);
    
    public void insertSQL(T t)throws SQLException;
    
    public void deleteSQL(ID id)throws SQLException;
    
    public String createTableSQL();
}
