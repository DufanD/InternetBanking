package model;

public class Tabungan {
    private String user;
    private String pass;
    private Long rekening;
    private Long saldo;
    private KartuATM kartu;
    private Long idNasabah; 
    
    public Tabungan(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public Tabungan() {
        this.user   = "";
        this.pass   = "";
        this.saldo  = 0L;
    }

    public Tabungan(String user, String pass, Long saldo) {
        this.user   = user;
        this.pass   = pass;
        this.saldo  = saldo;
        this.kartu  = new KartuATM(new Tabungan());
    }
        
    public Tabungan(Long rekening, String user, String pass, Long saldo) {
        this.rekening   = rekening;
        this.user       = user;
        this.pass       = pass;
        this.saldo      = saldo;
        this.kartu      = new KartuATM(new Tabungan());
    }

    public Tabungan(Long rekening) {
        this.rekening = rekening;
    }

    public Tabungan(String pass, Long rekening) {
        this.pass       = pass;
        this.rekening   = rekening;
    }

    public Tabungan(Tabungan tabungan, Long idNasabah) {
        this.user       = tabungan.getUser();
        this.pass       = tabungan.getPass();
        this.rekening   = tabungan.getRekening();
        this.saldo      = tabungan.getSaldo();
        this.idNasabah  = idNasabah;
        this.kartu      = new KartuATM(new Tabungan());
    }
            
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getRekening() {
        return rekening;
    }

    public void setRekening(Long rekening) {
        this.rekening = rekening;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
    
    public KartuATM getKartu() {
        return kartu;
    }

    public void setKartu(KartuATM kartu) {
        this.kartu = kartu;
    }

    public Long getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(Long idNasabah) {
        this.idNasabah = idNasabah;
    }
    
}