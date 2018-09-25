/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.impl.DaoNasabah;
import java.util.ArrayList;
import model.Nasabah;
import model.Tabungan;

/**
 *
 * @author Diend
 */
public class NasabahService implements Service<Long, Nasabah> {
    DaoNasabah daoNasabah;

    public NasabahService() {
        daoNasabah = new DaoNasabah();
    }
    
    @Override
    public Nasabah login(Nasabah nasabah) {
        return daoNasabah.findById(nasabah.getId());
    }
    
    @Override
    public void delete(Long rekening) {
        daoNasabah.delete(rekening);
    }
            
    @Override
    public Long register(Nasabah nasabah) {
        daoNasabah.save(nasabah);
        return nasabah.getId();
    }
        
    public ArrayList<Tabungan> getAllTabungan(Long id) {
        return daoNasabah.getAllTabungan(id);
    }
    
    public ArrayList<Nasabah> getAll() {
        return daoNasabah.getAll();
    }
}
