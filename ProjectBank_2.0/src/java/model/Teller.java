package model;

public class Teller extends TransaksiOffline {
    public String namaTeller;

    public Teller(Tabungan tabungan, String namaTeller) {
        super(tabungan);
        this.namaTeller = namaTeller;
    }
    
    public String getNamaTeller() {
        return namaTeller;
    }

    public void setNamaTeller(String namaTeller) {
        this.namaTeller = namaTeller;
    }
}