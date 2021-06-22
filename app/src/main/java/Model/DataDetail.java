package Model;

public class DataDetail {
    private String nama,agama, alamat,roles,tgl_lahir,telepon,email,gender,password,id,keterangan,status;
    private String jam_masuk,jam_keluar,tanggal,lembur,produksi;


    public DataDetail(String nama, String agama, String alamat, String roles, String tgl_lahir,
                      String telepon, String email, String gender, String password, String id,
                      String keterangan, String status, String jam_masuk,
                      String jam_keluar, String tanggal, String lembur, String produksi) {
        this.nama = nama;
        this.agama = agama;
        this.alamat = alamat;
        this.roles = roles;
        this.tgl_lahir = tgl_lahir;
        this.telepon = telepon;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.id = id;
        this.keterangan = keterangan;
        this.status = status;
        this.jam_masuk = jam_masuk;
        this.jam_keluar = jam_keluar;
        this.tanggal = tanggal;
        this.lembur = lembur;
        this.produksi = produksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLembur() {
        return lembur;
    }

    public void setLembur(String lembur) {
        this.lembur = lembur;
    }

    public String getProduksi() {
        return produksi;
    }

    public void setProduksi(String produksi) {
        this.produksi = produksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKet() {
        return keterangan;
    }

    public void setKet(String ket) {
        this.keterangan = ket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public void setJam_masuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
