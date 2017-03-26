/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPelanggan;

import Model.Pelanggan;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author budhidarmap
 */
public class testIDGenerate {

    public static void main(String[] args) {
        Pelanggan p = new Pelanggan();
        String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
        System.out.println(p.panggilID(timeStamp));
    }
}
