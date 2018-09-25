package model;

import singleton.AppSingleton;

public class TransaksiOffline extends SystemTransaksi {

    public TransaksiOffline(Tabungan tabungan) {
        super(tabungan);
    }
    
    public boolean login(Long rekening, String pass) {
        Tabungan tbg = AppSingleton.getInstance().getTabunganService()
                       .login(new Tabungan(pass, rekening));
        
        if (tbg != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean simpan(Long nominal) {
        if (tabungan.getSaldo() >= 0) {
            tabungan.setSaldo(tabungan.getSaldo() + nominal);
            AppSingleton.getInstance().getTabunganService()
                        .update(tabungan.getRekening(), tabungan);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean ambil(Long nominal) {
        if (tabungan.getSaldo() - nominal >= 0) {
            tabungan.setSaldo(tabungan.getSaldo() - nominal);
            AppSingleton.getInstance().getTabunganService()
                        .update(tabungan.getRekening(), tabungan);
            return true;
        } else {
            return false;
        }
    }
}