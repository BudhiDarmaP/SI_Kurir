/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitKurir;

import UnitPelanggan.*;
import Model.Kurir;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author budhidarmap
 */
public class testIDGenerate {

    public static void main(String[] args) {
        Kurir k = new Kurir();
        String timeStamp = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
        System.out.println(k.panggilID(timeStamp));
    }
}
