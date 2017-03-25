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
public class Kurir {
    private String ID;
    private String nama;
    private String email;
    private String no_tlp;
    private String alamat;
    protected String password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public static void tambahKurir(Kurir k){
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_KURIR VALUES"
                    + "(?,?,?,?,?)");
            ps.setString(1, k.getID());
            ps.setString(2, k.getNama());
            ps.setString(3, k.getEmail());
            ps.setString(4, k.getNo_tlp());
            ps.setString(5, k.getNo_tlp());
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
    public static void hapusMember(String email){
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_KURIR "
                    + "WHERE EMAIL='"+email+"'");
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
    public static String editKurir(Kurir k){
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_KURIR SET"
                    + "(NAMA, EMAIL, NO_TLP, ALAMAT) VALUES(?,?,?,?,?)");
            ps.setString(1, k.getNama());
            ps.setString(2, k.getEmail());
            ps.setString(3, k.getNo_tlp());
            ps.setString(4, k.getAlamat());
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
    public static Kurir panggilKurir(String email, String password){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Kurir k = new Kurir();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PTI_KURIR");
            rs.next();
            rs = st.executeQuery("SELECT ID, NAMA, NO_TLP, ALAMAT FROM PTI_KURIR"
                    + "WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'");
            int index = 0;
            while (rs.next()) {
                k.setID(rs.getString(1));
                k.setNama(rs.getString(2));
                k.setEmail(email);
                k.setNo_tlp(rs.getString(3));
                k.setAlamat(rs.getString(4));
                k.setPassword(password);
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
        return k;
    }
}
