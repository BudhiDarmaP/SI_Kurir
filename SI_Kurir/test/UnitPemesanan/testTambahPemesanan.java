/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPemesanan;

import Model.Pengiriman;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author budhidarmap
 */
public class testTambahPemesanan {
    public static void main(String[] args) {
        Pengiriman p = new Pengiriman();
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        p.setID_pelanggan("170407001");
        p.setTanggal(timeStamp);
        p.setAsal("Indonesia");
        p.setTujuan("Korut");
        p.setJarak(3000);
        p.setBarang("VX");
        p.setBiaya(p.Biaya(p.getJarak()));
        p.setID(timeStamp+p.getID_pelanggan());
        System.out.println(p.getBiaya());
        System.out.println(p.getID());
        p.tambahPengiriman(p);
    }
}
