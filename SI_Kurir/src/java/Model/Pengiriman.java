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

    private String ID;
    private String ID_pelanggan;
    private String ID_kurir;
    private String tanggal;
    private String asal;
    private String tujuan;
    private double jarak;
    private String barang;
    private double biaya;
    private boolean status;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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
        harga=jarak*3000;
        return harga;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public static void tambahPengiriman(Pengiriman p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_PEMESANAN VALUES"
                 +"(?,NULL,TO_DATE(?, 'DD-MM-YYYY'),?,?,?,?,?,'0',?)");
            ps.setString(1, p.getID_pelanggan());
            ps.setString(2, p.getTanggal());
            ps.setString(3, p.getAsal());
            ps.setString(4, p.getTujuan());
            ps.setDouble(5, p.getJarak());
            ps.setString(6, p.getBarang());
            ps.setDouble(7, p.getBiaya());
            ps.setString(8, p.getID());
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah ditambahkan";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menambahkan");
            }
        }
            System.out.println(text);
    }
    
     public static Pengiriman panggilPemesanan(String member, String time){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        int index = 0;
        Pengiriman p = new Pengiriman();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PTI_PEMESANAN "
                    + "WHERE ID_MEMBER='"+member+"' AND TANGGAL=TO_DATE"
                    + "('" + time + "','DD-MM-YYYY') AND STATUS='0'");
            while (rs.next()) {
                p.setID_pelanggan(member);
                p.setID_kurir(rs.getString(2));
                p.setTanggal(rs.getString(3));
                p.setAsal(rs.getString(4));
                p.setTujuan(rs.getString(5));
                p.setJarak(rs.getDouble(6));
                p.setBarang(rs.getString(7));
                p.setBiaya(rs.getDouble(8));
                p.setID(rs.getString(10));
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
        return p;
    }
     public static Pengiriman panggilPesanan(String id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        int index = 0;
        Pengiriman p = new Pengiriman();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PTI_PEMESANAN "
                    + "WHERE ID='"+id+"' AND STATUS='0'");
            while (rs.next()) {
                p.setID_pelanggan(rs.getString(1));
                p.setID_kurir(rs.getString(2));
                p.setTanggal(rs.getString(3));
                p.setAsal(rs.getString(4));
                p.setTujuan(rs.getString(5));
                p.setJarak(rs.getDouble(6));
                p.setBarang(rs.getString(7));
                p.setBiaya(rs.getDouble(8));
                p.setID(id);
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
        return p;
    }
     
    public static String editPengiriman(Pengiriman p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_PEMESANAN SET " 
                    +"ASAL=?, TUJUAN=?, JARAK=?, BARANG=?, BIAYA=? "
                    +"WHERE ID=? AND ID_MEMBER=?");
            ps.setString(1, p.getAsal());
            ps.setString(2, p.getTujuan());
            ps.setDouble(3, p.getJarak());
            ps.setString(4, p.getBarang());
            ps.setDouble(5, p.getBiaya());
            ps.setString(6, p.getID());
            ps.setString(7, p.getID_pelanggan());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
        return text;
    }

    public static void hapusPengiriman(String ID, String Pelanggan) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_PEMESANAN "
                    + "WHERE ID='" + ID + "' AND ID_MEMBER='"+Pelanggan+"'");
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
        System.out.println(text);
    }
    
    public static Pengiriman[] getListPengiriman(String time) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Pengiriman po[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) "
                    + "TOTAL FROM PTI_PEMESANAN WHERE TANGGAL=TO_DATE"
                    + "('" + time + "','DD-MM-YYYY') "
                    + "AND STATUS='0' ORDER BY TANGGAL ASC");
            rs.next();
            po = new Pengiriman[rs.getInt(1)];
            rs = st.executeQuery("SELECT *"
                    + "FROM PTI_PEMESANAN WHERE TANGGAL=TO_DATE"
                    + "('" + time + "','DD-MM-YYYY') "
                    + "AND STATUS='0' ORDER BY TANGGAL ASC");
            int index = 0;
            while (rs.next()) {
                po[index] = new Pengiriman();
                po[index].setID_pelanggan(rs.getString(1));
                po[index].setID_kurir(rs.getString(2));
                po[index].setTanggal(rs.getString(3));
                po[index].setAsal(rs.getString(4));
                po[index].setTujuan(rs.getString(5));
                po[index].setJarak(rs.getDouble(6));
                po[index].setBarang(rs.getString(7));
                po[index].setBiaya(rs.getDouble(8));
                po[index].setStatus(rs.getBoolean(9));
                po[index].setID(rs.getString(10));
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
    public static String ubahStatus(Pengiriman p){
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_PEMESANAN SET"
                    + " STATUS=1, ID_KURIR=? WHERE ID=?");
            ps.setString(1, p.getID_kurir());
            ps.setString(2, p.getID());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {

        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
        return text;
    }
}