/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Diend
 */
public class Koneksi {
    private String JDBC_DRIVER    = "com.mysql.jdbc.Driver";
    private String DB_NAME        = "data_bank";
    private String DB_URL         = "jdbc:mysql://localhost/" + DB_NAME;
    private String USER           = "root";
    private String PASS           = "";
    private String TABEL_TABUNGAN = "tabungan";
    private String TABEL_NASABAH  = "nasabah";
    private Connection conn       = null;
    private Statement stmt        = null;

    public Koneksi() {}

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public void setJDBC_DRIVER(String JDBC_DRIVER) {
        this.JDBC_DRIVER = JDBC_DRIVER;
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public void setDB_NAME(String DB_NAME) {
        this.DB_NAME = DB_NAME;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getTABEL_TABUNGAN() {
        return TABEL_TABUNGAN;
    }

    public void setTABEL_TABUNGAN(String TABEL_TABUNGAN) {
        this.TABEL_TABUNGAN = TABEL_TABUNGAN;
    }

    public String getTABEL_NASABAH() {
        return TABEL_NASABAH;
    }

    public void setTABEL_NASABAH(String TABEL_NASABAH) {
        this.TABEL_NASABAH = TABEL_NASABAH;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
