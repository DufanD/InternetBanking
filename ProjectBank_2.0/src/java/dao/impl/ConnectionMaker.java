/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KartuATM;
import model.Tabungan;

/**
 *
 * @author Diend
 */
public class ConnectionMaker extends Koneksi {
        
    protected void openConnection() {
        try {
            Class.forName(getJDBC_DRIVER());
            setConn(DriverManager.getConnection(getDB_URL(), 
                            getUSER(), getPASS())); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
    }
    
    protected void closeConnection() {
        try {
            if (getConn() != null) {
                getConn().close();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DaoNasabah.class.getName()).log(Level.SEVERE,
                                                             null, ex);
        }
    }
    
    protected void cekConnection() {
        if (getConn() == null) {
            System.out.println("conn is null");
        }
    }
    
    protected void cekKartu(ResultSet rs, Tabungan tabungan) 
            throws SQLException {
        String type;
        
        try {
            type = rs.getString("atm");
        } catch (NullPointerException npe) {
            type = "NONE";
        }
        setTipeKartu(type, tabungan);
    }
    
    protected void setTipeKartu(String type, Tabungan tabungan) {
        if (null == type || type.equals("NONE")) {
            tabungan.getKartu().setType(KartuATM.TypeKartu.NONE);
        } else switch (type) {
            case "GOLD":
                tabungan.getKartu().setType(KartuATM.TypeKartu.GOLD);
                break;
            case "PLATINUM":
                tabungan.getKartu().setType(KartuATM.TypeKartu.PLATINUM);
                break;
            case "SILVER":
                tabungan.getKartu().setType(KartuATM.TypeKartu.SILVER);
                break;
            default:
                break;
        }
    }
    
    protected void createDatabase() {
        Connection conn = null;
        Statement stmt  = null;
        
        try {
            executeCreate(conn, stmt, 1);
        } catch (SQLException | ClassNotFoundException ex) {} 
        finally {
            finallyCreate(conn, stmt);
        }
    }
    
    protected void executeCreate(Connection conn, Statement stmt, int flag) 
            throws ClassNotFoundException, SQLException {
        Class.forName(getJDBC_DRIVER());
            
        conn        = DriverManager.getConnection("jdbc:mysql://localhost/", 
                                                  getUSER(), 
                                                  getPASS());
        stmt        = conn.createStatement();
        String sql  = sqlCreate(flag);
        stmt.executeUpdate(sql);
    }
    
    private String sqlCreate(int flag) {
        String sql = null;
        
        if (flag == 1) {
            sql = "CREATE DATABASE IF NOT EXISTS " + getDB_NAME();
        } else {
            sql = createTableSQL();
        }
        return sql;
    }
    
    public String createTableSQL() {
        String sql = "";
        return sql;
    }
    
    protected void finallyCreate(Connection conn, Statement stmt) {
        try { 
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {}
        try { 
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {}
    }
}
