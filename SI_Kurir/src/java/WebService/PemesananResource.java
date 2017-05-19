/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Controller.LongLivedCookie;
import Model.Pengiriman;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.json.JsonObject;
import javax.servlet.http.Cookie;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author budhidarmap
 */
@Path("Pemesanan")
public class PemesananResource {

    @POST
    @Consumes("application/json")
    public Response getPemensanan(JsonObject pengiriman) {
        Pengiriman p = new Pengiriman();
        String result;
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        //Bongkar json menjadi obyek anggota
            p.setID_pelanggan(pengiriman.getString("ID_pelanggan"));
            p.setTanggal(pengiriman.getString("tanggal"));
            p.setAsal(pengiriman.getString("asal"));
            p.setTujuan(pengiriman.getString("tujuan"));
            p.setJarak(pengiriman.getInt("jarak"));
            p.setBarang(pengiriman.getString("Barang"));
            //biaya
            p.setBiaya(p.Biaya((pengiriman.getInt("jarak"))));
            p.setID(timeStamp + p.getID());
            //simpan pengiriman
            p.tambahPengiriman(p);
        //Simpan anggota ke database
        result = p.getID();
        //kembalikan status OK
        return Response.status(201).entity(result).build();
    }
}
