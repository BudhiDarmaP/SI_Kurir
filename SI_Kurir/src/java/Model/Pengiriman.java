/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public double Biaya(double jarak) {
        double harga = 0;
        return harga;
    }

    public static void tambahPengiriman(Pengiriman p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_PEMESANAN VALUES"
                    + "(?,?,?,?,?,?,?)");
            ps.setString(1, p.getID_pelanggan());
            ps.setString(2, p.getID_kurir());
            ps.setString(3, p.getTanggal());
            ps.setString(4, p.getAsal());
            ps.setString(5, p.getTujuan());
            ps.setString(6, p.getBarang());
            ps.setDouble(7, p.getBiaya());
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah ditambahkan";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void hapusPengiriman(String ID, String Kurir, String Tanggal) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_PEMESANAN "
                    + "WHERE ID='" + ID + "' AND KURIR='"+Kurir+"'"
                    + "AND TANGGAL='"+Tanggal+"'");
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah dihapus";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    public static Pengiriman[] getListStatusTagihan(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Pengiriman po[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) "
                    + "TOTAL FROM PEMESANAN WHERE ID = '" + id + "' ORDER BY TANGGAL ASC");
            rs.next();
            po = new Pengiriman[rs.getInt(1)];
            rs = st.executeQuery("SELECT *"
                    + "FROM PTI_PEMESANAN WHERE ID = '" + id + "' ORDER BY TANGGAL ASC");
            int index = 0;
            while (rs.next()) {
                po[index] = new Pengiriman();
                po[index].setID_pelanggan(rs.getString(1));
                po[index].setID_kurir(rs.getString(2));
                po[index].setTanggal(rs.getString(3));
                po[index].setAsal(rs.getString(4));
                po[index].setTujuan(rs.getString(5));
                po[index].setBarang(rs.getString(6));
                po[index].setBiaya(rs.getDouble(7));
                index++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return po;
    }
}