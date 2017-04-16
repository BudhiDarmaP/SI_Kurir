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
public class testPanggilPemesanan {
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        Pengiriman p = Pengiriman.panggilPemesanan("170407001", timeStamp);
        System.out.println(p.getTujuan());
    }
}
