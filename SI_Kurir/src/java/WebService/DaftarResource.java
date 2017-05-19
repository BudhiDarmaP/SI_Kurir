/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Model.Pelanggan;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author budhidarmap
 */
@Path("Daftar")
public class DaftarResource {

    @POST
    @Consumes("application/json")
    public Response daftarPelanggan(JsonObject pelanggan) {
        Pelanggan p = new Pelanggan();
        String result = "Gagal Terdaftar";
        String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
        String number = "000";
        int count = p.panggilID(timeStamp) + 1;
        //generate ID
        if (count < 10) {
            number = "00" + String.valueOf(count);
        } else if (count < 100) {
            number = "0" + String.valueOf(count);
        } else {
            number = String.valueOf(count);
        }
        //exception
        //Check kelengkapan inputan
        if (pelanggan.getString("nama").equals("")) {
            result = "Nama Belum Terisi";
        }
        if (pelanggan.getString("email").equals("")) {
            result = "Email Belum Terisi";
        }
        if (pelanggan.getString("no").equals("")) {
            result = "No Telephone Belum Terisi";
        }
        if (pelanggan.getString("alamat").equals("")) {
            result = "Alamat Belum Terisi";
        }
        if (pelanggan.getString("password").equals("")) {
            result = "Password Belum Terisi";
        }
        if (!Pattern.matches("[a-zA-Z]+", pelanggan.getString("nama"))) {
            result = "Nama Mengandung Huruf";
        }
        if (isValidEmailAddress(pelanggan.getString("email"))) {
            result = "Format Email Salah!";
        }
        if (!p.getNo_tlp().contains("[0-9]+") && p.getNo_tlp().length() < 11 || p.getNo_tlp().length() > 13) {
            result = "Digit Number kurang atau Format Telephone Salah";
        }
        if (p.cekPelanggan(p.getEmail()) == 1) {
            result = "Pelanggan Sudah Terdaftar";
        } else {
            //Bongkar json menjadi obyek pelanggan
            p.setID(timeStamp + number);
            p.setNama(pelanggan.getString("nama"));
            p.setEmail(pelanggan.getString("email"));
            p.setNo_tlp(pelanggan.getString("no"));
            p.setAlamat(pelanggan.getString("alamat"));
            p.setPassword(pelanggan.getString("password"));
            //Simpan anggota ke database
            Pelanggan.tambahMember(p);
            result = p.getID();
        }
        //kembalikan status OK
        return Response.status(201).entity(result).build();
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[!#$%&'*+/=?^_`{|}-~]+"
                + "@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
                + "|(([\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
