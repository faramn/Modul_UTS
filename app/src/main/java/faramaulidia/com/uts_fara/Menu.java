package faramaulidia.com.uts_fara;

public class Menu {
    private String nama;
    private String bahanBaku;
    private String harga;

    public Menu(String nama, String bahanBaku ,String harga) {
        this.nama = nama;
        this.bahanBaku = bahanBaku;
        this.harga = harga;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getBahanBaku() {

        return bahanBaku;
    }

    public void setBahanBaku(String bahanBaku) {

        this.bahanBaku = bahanBaku;
    }

    public String getHarga() {

        return harga;
    }

    public void setHarga(String harga) {

        this.harga = harga;
    }

}
