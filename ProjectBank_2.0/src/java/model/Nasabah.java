/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Ini class Nasabah
 * @author Diend
 */
public class Nasabah {
    private Long id;
    private ArrayList listTabungan;

    public Nasabah(Long id) {
        this.id = id;
    }

    public Nasabah() {}
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public ArrayList getListTabungan() {
        return listTabungan;
    }

    public void setListTabungan(ArrayList listTabungan) {
        this.listTabungan = listTabungan;
    }
}
