package service;

import dao.impl.DaoTabungan;
import model.Nasabah;
import model.Tabungan;
import singleton.AppSingleton;

public class TabunganService implements Service<Long, Tabungan> {
    DaoTabungan daoTabungan;

    public TabunganService() {
        daoTabungan = new DaoTabungan();
    }
    
    @Override
    public Tabungan login(Tabungan tabungan) {
        if (tabungan.getRekening() == null) {
            return daoTabungan.findByUser(tabungan);
        } else {
            return daoTabungan.findById(tabungan.getRekening());
        }
    }
    
    @Override
    public void delete(Long rekening) {
        daoTabungan.delete(rekening);
    }
                    
    @Override
    public Long register(Tabungan tabungan) {
        if (tabungan.getIdNasabah() == null) {
            Long id = AppSingleton.getInstance().getNasabahService()
                      .register(new Nasabah());
            tabungan.setIdNasabah(id);
        }
        daoTabungan.save(tabungan);
        return 0L;
    }
    
    public void update(Long rekening, Tabungan tabungan) {
        daoTabungan.update(rekening, tabungan);
    }
    
    public void settingTabungan(Long rekening, Tabungan tabungan, 
            String newpass, String newuser) {
        tabungan.setUser(newuser);
        tabungan.setPass(newpass);
        daoTabungan.update(rekening, tabungan);
    }
    
    public void createATM(Long rekening, Tabungan tabungan) {
        daoTabungan.update(rekening, tabungan);
    }
    
}
