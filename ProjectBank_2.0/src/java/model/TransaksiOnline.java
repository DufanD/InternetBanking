package model;

import singleton.AppSingleton;

public class TransaksiOnline extends SystemTransaksi {
    
    public TransaksiOnline(Tabungan tabungan) {
        super(tabungan);
    }
    
    public boolean transfer(Long nominal, Long rekeningTujuan, String pass) {
        Tabungan tbg = AppSingleton.getInstance().getTabunganService()
                       .login(new Tabungan(pass, rekeningTujuan));
        
        if (tbg != null) {
            tbg.setSaldo(tbg.getSaldo() + nominal);
            tabungan.setSaldo(tabungan.getSaldo() - nominal);
            AppSingleton.getInstance().getTabunganService()
                        .update(tbg.getRekening(), tbg);
            AppSingleton.getInstance().getTabunganService()
                        .update(tabungan.getRekening(), tabungan);
            return true;
        } else {
            return false;
        }
    }
}