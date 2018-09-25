/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;
import dao.DaoApp;
import model.Nasabah;
import model.Tabungan;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import singleton.AppSingleton;

/**
 *
 * @author Diend
 */
public class DaoNasabah extends ConnectionMaker 
        implements DaoApp <Long, Nasabah> {
    public DaoNasabah() {
        createDatabase();
        create_table_nasabah();
    }
        
    @Override
    public void save(Nasabah nasabah) {
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            insertSQL(nasabah);
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
        closeConnection();
    }
    
    @Override
    public void insertSQL(Nasabah nasabah) throws SQLException {
        String sql = "INSERT INTO " + getTABEL_NASABAH() + " (id) "
                     + "VALUES (" + nasabah.getId() + ")";
        getStmt().executeUpdate(sql);
    }
            
    @Override
    public void delete(Long id) {
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            deleteSQL(id);
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
        closeConnection();
    }
    
    @Override
    public void deleteSQL(Long id) throws SQLException {
        String sql2 = "DELETE FROM " + getTABEL_TABUNGAN() 
                      + " WHERE id_nasabah = " + id;
        getStmt().executeUpdate(sql2);
        String sql  = "DELETE FROM " + getTABEL_NASABAH() 
                      + " WHERE id = " + id;
        getStmt().executeUpdate(sql);
    }
        
    @Override
    public Nasabah findById(Long id) {
        Nasabah nasabah = null;
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            nasabah         = selectById(id);
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
        closeConnection();
        return nasabah;
    }
    
    private Nasabah selectById(Long id) throws SQLException {
        String sql      = "SELECT * FROM " + getTABEL_NASABAH() 
                          + " WHERE id = " + id;
        ResultSet rs    = getStmt().executeQuery(sql);
        return cekResultSet(rs);
    }
    
    private Nasabah cekResultSet(ResultSet rs) throws SQLException {
        Nasabah newNasabah = null;
        
        if (rs.first()) {
            Long nid    = rs.getLong("id");
            newNasabah  = new Nasabah(nid);
            rs.close();
            return newNasabah;
        }
        return null;
    }
    
    public ArrayList<Tabungan> getAllTabungan(Long id) {
        ArrayList<Tabungan> listTabungan = new ArrayList();
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            listTabungan = selectTabunganById(id);
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
        closeConnection();
        return listTabungan;
    }
    
    private ArrayList<Tabungan> selectTabunganById(Long id) 
            throws SQLException {
        String sql      = "SELECT * FROM " + getTABEL_TABUNGAN() 
                          + " WHERE id_nasabah = " + id;
        ResultSet rs    = getStmt().executeQuery(sql);
        return cekResultSetTabungan(rs);
    }
    
    private ArrayList<Tabungan> cekResultSetTabungan(ResultSet rs) 
            throws SQLException {
        Tabungan tabungan                   = null;
        ArrayList<Tabungan> listTabungan    = new ArrayList();
        rs.first();
        
        while (!rs.isAfterLast()) {
            Long nrekening  = rs.getLong("rekening");
            tabungan        = AppSingleton.getInstance().getTabunganService()
                              .login(new Tabungan(nrekening));
            cekKartu(rs, tabungan);
            listTabungan.add(tabungan);
            rs.next();
        }
        rs.close();
        return listTabungan;
    }
                    
    public ArrayList<Nasabah> getAll() {
        ArrayList<Nasabah> listNasabah = new ArrayList();
        openConnection();
        
        try {
            cekConnection();
            setStmt(getConn().createStatement());
            listNasabah     = selectNasabah();            
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
        closeConnection();
        return listNasabah;
    }
    
    private ArrayList<Nasabah> selectNasabah() throws SQLException {
        String sql      = "SELECT * FROM " + getTABEL_NASABAH();
        ResultSet rs    = getStmt().executeQuery(sql);
        return cekResultSetNasabah(rs);
    }
    
    private ArrayList<Nasabah> cekResultSetNasabah(ResultSet rs) 
            throws SQLException {
        Nasabah nasabah                 = null;
        ArrayList<Nasabah> listNasabah  = new ArrayList();
        rs.first();
        
        while (!rs.isAfterLast()) {
            Long nid    = rs.getLong("id");
            nasabah     = new Nasabah(nid);
            listNasabah.add(nasabah);
            rs.next();
        }
        rs.close();
        return listNasabah;
    }
            
    public void create_table_nasabah() {
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
        String sql = "CREATE TABLE IF NOT EXISTS " + getTABEL_NASABAH()
                     + " (id BIGINT NOT NULL AUTO_INCREMENT, "
                     + " PRIMARY KEY ( id ))";
        return sql;
    }
}
