package model;

import singleton.AppSingleton;

public class SystemTransaksi {
    protected Tabungan tabungan;

    public SystemTransaksi(Tabungan tabungan) {
        this.tabungan = tabungan;
    }
        
    public boolean transfer(Long nominal, Long rekeningTujuan) {
        Tabungan tbg = AppSingleton.getInstance().getTabunganService()
                       .login(new Tabungan(rekeningTujuan));
        
        if (tbg != null) {
            tbg.setSaldo(tbg.getSaldo() + nominal);
            this.tabungan.setSaldo(this.tabungan.getSaldo() - nominal);
            AppSingleton.getInstance().getTabunganService()
                        .update(tbg.getRekening(), tbg);
            AppSingleton.getInstance().getTabunganService()
                        .update(tabungan.getRekening(), tabungan);
            return true;
        } else {
            return false;
        }
    }

    public String cekSaldo() {
        return String.valueOf(tabungan.getSaldo());
    }

    public boolean login(String user, String pass) {
        Tabungan tbg = AppSingleton.getInstance().getTabunganService()
                       .login(new Tabungan(user, pass));
        
        if (tbg != null) {
            return true;
        } else {
            return false;
        }
    }

    public Tabungan getTabungan() {
        return tabungan;
    }

    public void setTabungan(Tabungan tabungan) {
        this.tabungan = tabungan;
    }    
}