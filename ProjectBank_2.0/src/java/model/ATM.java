package model;

import model.KartuATM.TypeKartu;
import singleton.AppSingleton;

public class ATM extends TransaksiOffline {
    public String alamat;

    public ATM(Tabungan tabungan, String alamat) {
        super(tabungan);
        this.alamat = alamat;
    }
    
    @Override
    public boolean ambil(Long nominal) {
        if (tabungan.getSaldo() - nominal >= 0 
                && nominal < tabungan.getKartu().getType().getLimit()) {
            tabungan.setSaldo(tabungan.getSaldo() - nominal);
            AppSingleton.getInstance().getTabunganService()
                        .update(tabungan.getRekening(), tabungan);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean login(Long rekening, String pass) {
        Tabungan tbg = AppSingleton.getInstance().getTabunganService()
                       .login(new Tabungan(pass, rekening));
        
        if (tbg != null && tbg.getKartu().getType() != TypeKartu.NONE) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
