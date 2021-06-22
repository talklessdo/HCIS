package Model;

public class DataModel {
    private int id;
    private String nama,agama, alamat,roles,tgl_lahir,telepon,gender,email,password,jam_masuk,jam_keluar,tanggal;
    private String keterangan,status,id_detail;

    public DataModel(int id, String nama, String agama, String alamat, String roles, String tgl_lahir,
                     String telepon, String gender, String email, String password, String jam_masuk,
                     String jam_keluar, String tanggal, String keterangan, String status, String id_detail) {
        this.id = id;
        this.id_detail = id_detail;
        this.nama = nama;
        this.agama = agama;
        this.alamat = alamat;
        this.roles = roles;
        this.tgl_lahir = tgl_lahir;
        this.telepon = telepon;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.jam_masuk = jam_masuk;
        this.jam_keluar = jam_keluar;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.status = status;
    }

    public String getId_detail() {
        return id_detail;
    }

    public void setId_detail(String id_detail) {
        this.id_detail = id_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
