/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author budhidarmap
 */
public class Pengiriman {
    private String ID_pelanggan;
    private String ID_kurir;
    private String tanggal;
    private String asal;
    private String tujuan;
    private double jarak;
    private String barang;
    private double biaya;

    public String getID_pelanggan() {
        return ID_pelanggan;
    }

    public void setID_pelanggan(String ID_pelanggan) {
        this.ID_pelanggan = ID_pelanggan;
    }

    public String getID_kurir() {
        return ID_kurir;
    }

    public void setID_kurir(String ID_kurir) {
        this.ID_kurir = ID_kurir;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
    public double Biaya(double jarak){
        double harga = 0;
        return harga;
    }
    public void tambahPengiriman(String ID){
        
    }
    public void hapusPengiriman(String ID){
        
    }
}
