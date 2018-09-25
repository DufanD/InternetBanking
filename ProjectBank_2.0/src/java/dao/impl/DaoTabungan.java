/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoApp;
import model.Tabungan;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Diend
 */
public class DaoTabungan extends ConnectionMaker 
        implements DaoApp <Long, Tabungan> {
    public DaoTabungan() {
        createDatabase();
        create_table_tabungan();
    }
        
    @Override
    public void save(Tabungan tabungan) {
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            insertSQL(tabungan);
        } catch (SQLException ex) {
            Logger.getLogger(DaoTabungan.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
        closeConnection();
    }
    
    @Override
    public void insertSQL(Tabungan tabungan) throws SQLException {
        String sql = "INSERT INTO " + getTABEL_TABUNGAN() 
                     + " (rekening, user, pass, saldo, atm, id_nasabah)"
                     + "VALUES ("
                     + tabungan.getRekening() + ","
                     + "'" + tabungan.getUser() + "',"
                     + "'" + tabungan.getPass() + "',"
                     + tabungan.getSaldo() + ",'" 
                     + tabungan.getKartu().getType() + "',"
                     + tabungan.getIdNasabah() + ")";
        getStmt().executeUpdate(sql);
    }
    
    public void update(Long rekening, Tabungan tabungan) {
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            updateTabungan(rekening, tabungan);
        } catch (SQLException ex) {
            Logger.getLogger(DaoTabungan.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
        closeConnection();
    }
    
    private void updateTabungan(Long rekening, Tabungan tabungan) 
            throws SQLException {
        String sql = "UPDATE " + getTABEL_TABUNGAN()
                     + " SET user = '" + tabungan.getUser() + "'" 
                     + ", pass = '" + tabungan.getPass() + "'" 
                     + ", saldo = " + tabungan.getSaldo() 
                     + ", atm = '" + tabungan.getKartu().getType() + "'"
                     + "WHERE rekening = " + rekening;
        getStmt().executeUpdate(sql);
    }
    
    @Override
    public void delete(Long rekening){
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            deleteSQL(rekening);
        } catch (SQLException ex) {
            Logger.getLogger(DaoTabungan.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
        closeConnection();
    }
    
    @Override
    public void deleteSQL(Long rekening) throws SQLException {
        String sql = "DELETE FROM " + getTABEL_TABUNGAN() 
                     + " WHERE rekening = " + rekening;
        getStmt().executeUpdate(sql);
    }
    
    public Tabungan findByUser(Tabungan tabungan){
        Tabungan new_tabungan = null;
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            new_tabungan = selectByUser(tabungan);
        } catch (SQLException ex) {
            Logger.getLogger(DaoTabungan.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
        closeConnection();
        return new_tabungan;
    }
    
    @Override
    public Tabungan findById(Long rekening) {
        Tabungan tabungan = null;
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            tabungan        = selectByRek(rekening);
        } catch (SQLException ex) {
            Logger.getLogger(DaoTabungan.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
        closeConnection();
        return tabungan;
    }
    
    private Tabungan selectByUser(Tabungan tabungan) throws SQLException {
        String sql      = "SELECT * FROM " + getTABEL_TABUNGAN() 
                          + " WHERE user = '" + tabungan.getUser() + "'";
        ResultSet rs    = getStmt().executeQuery(sql);
        return cekResultSet(rs, tabungan);
    }
    
    private Tabungan selectByRek(Long rekening) throws SQLException {
        String sql      = "SELECT * FROM " + getTABEL_TABUNGAN() 
                          + " WHERE rekening = " + rekening;
        ResultSet rs    = getStmt().executeQuery(sql);
        return cekResultSet(rs);
    }
    
    private Tabungan cekResultSet(ResultSet rs, Tabungan tabungan) throws 
            SQLException {
        Tabungan newTabungan = null;
        
        if (rs.first()) {
            newTabungan = makeTemporaryTabungan(rs);
            
            if (newTabungan.getPass().equals(tabungan.getPass())) {
                rs.close();
                return newTabungan;
            }
        }
        return null;
    }
    
    private Tabungan cekResultSet(ResultSet rs) throws SQLException {
        Tabungan newTabungan = null;
        
        if (rs.first()) {
            newTabungan = makeTemporaryTabungan(rs);
            cekKartu(rs, newTabungan);
            rs.close();
            return newTabungan;
        }
        return null;
    }
    
    private Tabungan makeTemporaryTabungan(ResultSet rs) throws SQLException {
        Long nrekening     = rs.getLong("rekening");
        String user        = rs.getString("user");
        String pass        = rs.getString("pass");
        Long saldo         = rs.getLong("saldo");
        return new Tabungan(nrekening, user, pass, saldo);
    }
            
    public void create_table_tabungan() {
        Connection conn = null;
        Statement stmt  = null;
        
        try {
            executeCreate(conn, stmt, 2);
        } catch (SQLException | ClassNotFoundException ex) {}
        finally {
            finallyCreate(conn, stmt);
        }
    }
            
    @Override
    public String createTableSQL() {
        String sql = "CREATE TABLE IF NOT EXISTS " + getTABEL_TABUNGAN()
                     + " (rekening BIGINT NOT NULL AUTO_INCREMENT, "
                     + " user VARCHAR(255), "
                     + " pass VARCHAR(255), "
                     + " saldo BIGINT, "
                     + " atm VARCHAR(255), "
                     + " id_nasabah BIGINT, "
                     + " PRIMARY KEY ( rekening ), "
                     + " FOREIGN KEY ( id_nasabah ) REFERENCES nasabah( id ))";
        return sql;
    }    
}
